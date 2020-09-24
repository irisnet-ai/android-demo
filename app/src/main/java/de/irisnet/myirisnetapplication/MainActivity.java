package de.irisnet.myirisnetapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.preference.PreferenceManager;
import de.irisnet.java.ApiCallback;
import de.irisnet.java.ApiClient;
import de.irisnet.java.ApiException;
import de.irisnet.java.Configuration;
import de.irisnet.java.client.AiOperationsApi;
import de.irisnet.java.client.model.INDefineAI;
import de.irisnet.java.client.model.INImage;
import de.irisnet.java.client.model.INParam;
import de.irisnet.java.client.model.INParams;
import de.irisnet.java.client.model.IrisNet;
import okhttp3.JavaNetCookieJar;
import okhttp3.OkHttpClient;

import android.Manifest;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.net.CookieManager;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import static de.irisnet.java.client.model.INParam.InClassEnum.*;

public class MainActivity extends AppCompatActivity {
    private static final int PERMISSION = 99;
    private static final int PICK_IMAGE = 100;

    TextView textView;
    ImageView imageView;
    Button btnLoad;
    Button btnProcess;

    Uri imageUri;

    OkHttpClient httpClient;

    String licenseKey;
    int faceMin;
    int faceMax;
    static Map<String, Boolean> rules = new HashMap<String, Boolean>() {{
        for (INImage.ProtoEnum proto : INImage.ProtoEnum.values()) {
            put(proto.getValue(), false);
        }
    }};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.textView);
        imageView = findViewById(R.id.imageView);
        btnLoad = findViewById(R.id.buttonLoadImage);
        btnProcess = findViewById(R.id.buttonProcessImage);

        httpClient = new OkHttpClient.Builder().cookieJar(new JavaNetCookieJar(new CookieManager())).build();

        btnLoad.setOnClickListener(v -> {
            if (!isStoragePermissionGranted(MainActivity.this)) {
                return;
            }

            openGalleryImage();
        });

        btnProcess.setOnClickListener(v -> {
            if (imageUri == null) {
                Toast.makeText(v.getContext(), R.string.load_image, Toast.LENGTH_LONG).show();
                return;
            }

            // --- Start of ai relevant code ---

            // Create a list of INImage objects for each rules activated in the settings
            List<INImage> inImages = new ArrayList<>();
            for (Map.Entry<String, Boolean> entry : rules.entrySet()) {
                if (entry.getValue()) {
                    INImage inImage = new INImage();
                    inImage.setProto(INImage.ProtoEnum.fromValue(entry.getKey()));
                    inImages.add(inImage);
                }
            }

            // Create a INDefineAI and fill it with the previously created list
            INDefineAI inDefineAI = new INDefineAI();
            inDefineAI.setInImage(inImages);

            // Create INParams according to app settings. This is only required for NudityCheck and AgeVerification,
            // since IllegalSymbols does not require face recognition to recognize illegal symbols.
            INParams inParams = null;
            if (rules.get(INImage.ProtoEnum.NUDITYCHECK.getValue()) || rules.get(INImage.ProtoEnum.AGEVERIFICATION.getValue())) {
                // Create INParam object to define face min and max from app settings
                INParam faceParam = new INParam();
                faceParam.setInClass(INParam.InClassEnum.FACE);
                faceParam.setMin(faceMin);
                faceParam.setMax(faceMax);

                // Create INParam container to use on API call
                inParams = new INParams();
                inParams.addInParamItem(faceParam);

                // Create INParam object to define draw mode for nudity check (this is only for visual purposes on small screens)
                List<INParam.InClassEnum> nudityClasses = Arrays.asList(BREAST, VULVA, PENIS, VAGINA, BUTTOCKS, ANUS);
                for (INParam.InClassEnum classification : nudityClasses) {
                    INParam param = new INParam();
                    param.setInClass(classification);
                    param.drawMode(2);
                    inParams.addInParamItem(param);
                }
            }

            // Set some variables for image check
            String license = licenseKey; // String | License obtained from irisnet.de shop.
            Integer detail = 2; // Integer | Sets the response details. Use 1 for minimum detail (better API performance), 2 for medium details and 3 for all details.
            final File file = new File(getRealPathFromURI(imageUri)); // File |

            // Create ApiClient with custom httpClient that contains a CookieJar
            ApiClient defaultClient = Configuration.getDefaultApiClient();
            defaultClient
                    .setHttpClient(httpClient)
                    .setBasePath("https://api.irisnet.de");

            // Create api instance from client
            final AiOperationsApi apiInstance = new AiOperationsApi(defaultClient);

            /*
             * Defining callbacks for each api call. The success of each api call will make the next api call.
             * Succession: 'set-definition', 'set-parameters', 'check-image' and 'download'.
             * The callbacks are created in reverse order.
             */
            // Download callback is required if the modified image should be downloaded. In our case we display the image in our imageView in case of success
            ApiCallback<File> downloadCallback = new ApiCallback<File>() {
                @Override
                public void onFailure(ApiException e, int statusCode, Map<String, List<String>> responseHeaders) {
                    runOnUiThread(() -> Toast.makeText(v.getContext(), MainActivity.this.getString(R.string.download_error, e.getMessage()), Toast.LENGTH_LONG).show());
                    e.printStackTrace();
                }

                @Override
                public void onSuccess(File result, int statusCode, Map<String, List<String>> responseHeaders) {
                    // set the downloaded image into se imageView
                    runOnUiThread(() -> imageView.setImageURI(Uri.fromFile(result)));
                }

                @Override
                public void onUploadProgress(long bytesWritten, long contentLength, boolean done) {
                }

                @Override
                public void onDownloadProgress(long bytesRead, long contentLength, boolean done) {
                }
            };

            // Check callback sets the text in the textView and starts the download of the modified image in case of success
            ApiCallback<IrisNet> checkCallback = new ApiCallback<IrisNet>() {
                @Override
                public void onFailure(ApiException e, int statusCode, Map<String, List<String>> responseHeaders) {
                    runOnUiThread(() -> Toast.makeText(v.getContext(), MainActivity.this.getString(R.string.check_failure, e.getMessage()), Toast.LENGTH_LONG).show());
                    e.printStackTrace();
                }

                @Override
                public void onSuccess(IrisNet result, int statusCode, Map<String, List<String>> responseHeaders) {
                    MainActivity.this.runOnUiThread(() -> {
                        if (result.getRulesBroken() > 0) {
                            textView.setTextColor(getColor(R.color.colorTextAccent));
                            textView.setText(MainActivity.this.getString(R.string.image_not_ok, result.getRulesBroken()));
                        } else {
                            textView.setTextColor(getColor(R.color.colorText));
                            textView.setText(R.string.image_ok);
                        }
                    });

                    try {
                        // Download processed image
                        apiInstance.downloadProcessedAsync(file.getName(), downloadCallback);
                    } catch (ApiException e) {
                        Toast.makeText(v.getContext(), MainActivity.this.getString(R.string.download_error, e.getMessage()), Toast.LENGTH_LONG).show();
                        e.printStackTrace();
                    }

                    imageUri = null;
                }

                @Override
                public void onUploadProgress(long bytesWritten, long contentLength, boolean done) {
                }

                @Override
                public void onDownloadProgress(long bytesRead, long contentLength, boolean done) {
                }
            };

            // InParam callback starts the check image process in case of success.
            ApiCallback<Void> inParamCallback = new ApiCallback<Void>() {
                @Override
                public void onFailure(ApiException e, int statusCode, Map<String, List<String>> responseHeaders) {
                    runOnUiThread(() -> Toast.makeText(v.getContext(), MainActivity.this.getString(R.string.rules_error, e.getMessage()), Toast.LENGTH_LONG).show());
                    e.printStackTrace();
                }

                @Override
                public void onSuccess(Void result, int statusCode, Map<String, List<String>> responseHeaders) {
                    try {
                        // Check image
                        apiInstance.checkImageAsync(license, detail, file, checkCallback);
                    } catch (ApiException e) {
                        runOnUiThread(() -> Toast.makeText(v.getContext(), MainActivity.this.getString(R.string.rules_error, e.getMessage()), Toast.LENGTH_LONG).show());
                        e.printStackTrace();
                    }
                }

                @Override
                public void onUploadProgress(long bytesWritten, long contentLength, boolean done) {
                }

                @Override
                public void onDownloadProgress(long bytesRead, long contentLength, boolean done) {
                }
            };

            // InDefine callback sets the parameters in case of success. This callback could start the check image process if there is no need to define parameters.
            INParams finalInParams = inParams;
            ApiCallback<Void> inDefineCallback = new ApiCallback<Void>() {
                @Override
                public void onFailure(ApiException e, int statusCode, Map<String, List<String>> responseHeaders) {
                    Toast.makeText(v.getContext(), MainActivity.this.getString(R.string.rules_error, e.getMessage()), Toast.LENGTH_LONG).show();
                    e.printStackTrace();
                }

                @Override
                public void onSuccess(Void result, int statusCode, Map<String, List<String>> responseHeaders) {
                    if (finalInParams != null) {
                        try {
                            // Define parameters for the given rules
                            apiInstance.setINParamsAsync(finalInParams, inParamCallback);
                        } catch (ApiException e) {
                            Toast.makeText(v.getContext(), MainActivity.this.getString(R.string.rules_error, e.getMessage()), Toast.LENGTH_LONG).show();
                            e.printStackTrace();
                        }
                    } else {
                        try {
                            // Check image
                            apiInstance.checkImageAsync(license, detail, file, checkCallback);
                        } catch (ApiException e) {
                            runOnUiThread(() -> Toast.makeText(v.getContext(), MainActivity.this.getString(R.string.rules_error, e.getMessage()), Toast.LENGTH_LONG).show());
                            e.printStackTrace();
                        }
                    }
                }

                @Override
                public void onUploadProgress(long bytesWritten, long contentLength, boolean done) {
                }

                @Override
                public void onDownloadProgress(long bytesRead, long contentLength, boolean done) {
                }
            };

            try {
                // Start the API call chain by setting the INDefine rules
                apiInstance.setINDefineAsync(inDefineAI, inDefineCallback);
            } catch (ApiException e) {
                runOnUiThread(() -> Toast.makeText(v.getContext(), MainActivity.this.getString(R.string.rules_error, e.getMessage()), Toast.LENGTH_LONG).show());
                e.printStackTrace();
            }

            // --- end of ai relevant code ---
        });
    }

    @Override
    protected void onStart() {
        super.onStart();

        // initialize preferences default values
        PreferenceManager.setDefaultValues(this, R.xml.root_preferences, false);

        // load preferences and store them into variables
        licenseKey = PreferenceManager.getDefaultSharedPreferences(this).getString("license", "");
        if (licenseKey == null || licenseKey.trim().isEmpty()) {
            startActivity(new Intent(this, SettingsActivity.class));
            return;
        }

        faceMin = Integer.parseInt(Objects.requireNonNull(PreferenceManager.getDefaultSharedPreferences(this).getString("faceMin", "-1")));
        faceMax = Integer.parseInt(Objects.requireNonNull(PreferenceManager.getDefaultSharedPreferences(this).getString("faceMax", "-1")));

        for (Map.Entry<String, Boolean> entry : rules.entrySet()) {
            rules.put(entry.getKey(), PreferenceManager.getDefaultSharedPreferences(this).getBoolean(entry.getKey(), entry.getValue()));
        }
    }

    // ---- Android specific code ----

    private void openGalleryImage() {
        Intent gallery = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.INTERNAL_CONTENT_URI);
        startActivityForResult(gallery, PICK_IMAGE);
    }

    private String getRealPathFromURI(Uri contentUri) {
        String [] proj = {MediaStore.Images.Media.DATA};
        Cursor cursor = managedQuery(contentUri, proj, null, null, null);
        int column_index = cursor.getColumnIndexOrThrow(MediaStore.Images.Media.DATA);
        cursor.moveToFirst();
        return cursor.getString(column_index);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK && requestCode == PICK_IMAGE){
            imageUri = data.getData();
            imageView.setImageURI(imageUri);
            textView.setText("");
        }
    }

    @SuppressLint("ObsoleteSdkInt")
    public boolean isStoragePermissionGranted(Activity activity) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (ContextCompat.checkSelfPermission(activity, Manifest.permission.READ_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED) {
                return true;
            } else {
                ActivityCompat.requestPermissions(activity, new String[]{Manifest.permission.READ_EXTERNAL_STORAGE}, PERMISSION);
                return false;
            }
        } else {
            return true;
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        if (grantResults[0] == PackageManager.PERMISSION_DENIED) {
            Toast.makeText(this, R.string.permission_required, Toast.LENGTH_LONG).show();
        } else {
            openGalleryImage();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            startActivity(new Intent(this, SettingsActivity.class));
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}