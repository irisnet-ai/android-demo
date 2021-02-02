## My Irisnet Application

A demo application for irisnet use on android.

<img alt="irisnet logo" src="https://irisnet.de/wp-content/uploads/2020/04/irisnet_logo.svg" width="40%">

---

The application uses generated code from the [OpenAPI generator](https://github.com/OpenAPITools/openapi-generator). See [README](irisnetlib/README.md) to learn more about library usage.

### How to build and install

Follow the instructions on [developer.android.com](https://developer.android.com/studio/run) to run the app on your device or an emulator using Android Studio. If you don't have Android Studio installed or do not want to install it, follow these instructions on how to [build and install](https://developer.android.com/studio/build/building-cmdline) the app from command line.

### How to use

Uppon first start you are redirected to the settings menu, where you can enter a license key and where you can modify the rules that should be applied. Press the back button when finished.

>A license key can be obtained here: [irisnet.de](https://www.irisnet.de/prices)

>Or get a limited license for demonstrational or testing purposes: [free license key](https://www.irisnet.de/kasse?add-to-cart=26542)

On the main screen use the `LOAD IMAGE` button to select an image from the app gallery. When the image is loaded you'll see it in the main screen. Press the `PROCESS IMAGE` button to check the image for the given rules. After the check has completed the image will be replaced with the result showing bluring and/or frames around the recognized objects. On top of the image a text will appear showing the number of broken rules. Repeat the process to test a new image.

### Code

The coding for making calles to the ai is located within the `MainActivity` class between the comments `Start of ai relevant code` and `End of ai relevand code`.