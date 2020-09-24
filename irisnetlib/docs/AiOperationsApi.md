# AiOperationsApi

All URIs are relative to *https://api.irisnet.de*

Method | HTTP request | Description
------------- | ------------- | -------------
[**checkImage**](AiOperationsApi.md#checkImage) | **POST** /v1/check-image/{licenseKey} | Upload and check image against previously chosen configuration.
[**checkImageUrl**](AiOperationsApi.md#checkImageUrl) | **POST** /v1/check-url/{licenseKey} | Check image url against previously chosen configuration.
[**downloadProcessed**](AiOperationsApi.md#downloadProcessed) | **GET** /v1/download/{filename} | Get the resulting image file.
[**setINDefine**](AiOperationsApi.md#setINDefine) | **POST** /v1/set-definition | Set definitions via pre-defined prototypes.
[**setINParams**](AiOperationsApi.md#setINParams) | **POST** /v1/set-parameters | Set the behaviour parameters for one object class.


<a name="checkImage"></a>
# **checkImage**
> IrisNet checkImage(licenseKey, detail, file)

Upload and check image against previously chosen configuration.

### Example
```java
// Import classes:
import de.irisnet.java.ApiClient;
import de.irisnet.java.ApiException;
import de.irisnet.java.Configuration;
import de.irisnet.java.models.*;
import de.irisnet.java.client.AiOperationsApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.irisnet.de");

    AiOperationsApi apiInstance = new AiOperationsApi(defaultClient);
    String licenseKey = "licenseKey_example"; // String | License obtained from irisnet.de shop.
    Integer detail = 1; // Integer | Sets the response details. Use 1 for minimum detail (better API performance), 2 for medium details and 3 for all details.
    File file = new File("/path/to/file"); // File | 
    try {
      IrisNet result = apiInstance.checkImage(licenseKey, detail, file);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling AiOperationsApi#checkImage");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **licenseKey** | **String**| License obtained from irisnet.de shop. |
 **detail** | **Integer**| Sets the response details. Use 1 for minimum detail (better API performance), 2 for medium details and 3 for all details. | [optional] [default to 1]
 **file** | **File**|  | [optional]

### Return type

[**IrisNet**](IrisNet.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: multipart/form-data
 - **Accept**: application/xml, application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | successful operation |  -  |
**402** | Not enough credits |  -  |

<a name="checkImageUrl"></a>
# **checkImageUrl**
> IrisNet checkImageUrl(url, licenseKey, detail)

Check image url against previously chosen configuration.

### Example
```java
// Import classes:
import de.irisnet.java.ApiClient;
import de.irisnet.java.ApiException;
import de.irisnet.java.Configuration;
import de.irisnet.java.models.*;
import de.irisnet.java.client.AiOperationsApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.irisnet.de");

    AiOperationsApi apiInstance = new AiOperationsApi(defaultClient);
    String url = "url_example"; // String | 
    String licenseKey = "licenseKey_example"; // String | License obtained from irisnet.de shop.
    Integer detail = 1; // Integer | Sets the response details. Use 1 for minimum detail (better API performance), 2 for medium details and 3 for all details.
    try {
      IrisNet result = apiInstance.checkImageUrl(url, licenseKey, detail);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling AiOperationsApi#checkImageUrl");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **url** | **String**|  |
 **licenseKey** | **String**| License obtained from irisnet.de shop. |
 **detail** | **Integer**| Sets the response details. Use 1 for minimum detail (better API performance), 2 for medium details and 3 for all details. | [optional] [default to 1]

### Return type

[**IrisNet**](IrisNet.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/xml, application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | successful operation |  -  |
**402** | Not enough credits |  -  |

<a name="downloadProcessed"></a>
# **downloadProcessed**
> File downloadProcessed(filename)

Get the resulting image file.

### Example
```java
// Import classes:
import de.irisnet.java.ApiClient;
import de.irisnet.java.ApiException;
import de.irisnet.java.Configuration;
import de.irisnet.java.models.*;
import de.irisnet.java.client.AiOperationsApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.irisnet.de");

    AiOperationsApi apiInstance = new AiOperationsApi(defaultClient);
    String filename = "filename_example"; // String | 
    try {
      File result = apiInstance.downloadProcessed(filename);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling AiOperationsApi#downloadProcessed");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **filename** | **String**|  |

### Return type

[**File**](File.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/octet-stream

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**404** | Specified file was not found. |  -  |
**200** | Returns the file AI produced file with masking or blurring, depending on given AI parameters. |  -  |

<a name="setINDefine"></a>
# **setINDefine**
> setINDefine(inDefineAI)

Set definitions via pre-defined prototypes.

Each available prototype groups together a pre-defined set of parameters that will define the behaviour of the AI. Additionally you can overwrite specific parameters using &#39;set-parameters&#39;. Any prior request to &#39;set-parameters&#39; are invalidated when calling this request. This can also be used to reset the AI configuration.

### Example
```java
// Import classes:
import de.irisnet.java.ApiClient;
import de.irisnet.java.ApiException;
import de.irisnet.java.Configuration;
import de.irisnet.java.models.*;
import de.irisnet.java.client.AiOperationsApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.irisnet.de");

    AiOperationsApi apiInstance = new AiOperationsApi(defaultClient);
    INDefineAI inDefineAI = <?xml version="1.0" encoding="UTF-8"?>
<inDefineAI>
	<inImage proto="checkNudity"/>
</inDefineAI>; // INDefineAI | 
    try {
      apiInstance.setINDefine(inDefineAI);
    } catch (ApiException e) {
      System.err.println("Exception when calling AiOperationsApi#setINDefine");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **inDefineAI** | [**INDefineAI**](INDefineAI.md)|  |

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/xml, application/json
 - **Accept**: Not defined

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**400** | Bad request. Check for badly formatted request body. |  -  |
**200** | successful operation |  -  |

<a name="setINParams"></a>
# **setINParams**
> setINParams(inParams)

Set the behaviour parameters for one object class.

Overwrites or extends the default configuration of the AI. By setting precise behaviour parameters, the AI can be fine tuned for specific use cases. To reset the parameters to their default values, make a post request to &#39;set-definition&#39;.

### Example
```java
// Import classes:
import de.irisnet.java.ApiClient;
import de.irisnet.java.ApiException;
import de.irisnet.java.Configuration;
import de.irisnet.java.models.*;
import de.irisnet.java.client.AiOperationsApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.irisnet.de");

    AiOperationsApi apiInstance = new AiOperationsApi(defaultClient);
    INParams inParams = <?xml version="1.0" encoding="UTF-8" standalone="yes"?>
<inParams>
	<inDefault thresh="0.5" grey="127"/>
	<inParam inClass="face" min="-1" max="-1" drawMode="0" grey="127"/>
	<inParam inClass="hand" min="-1" max="-1" drawMode="0" grey="127"/>
	<inParam inClass="breast" min="0" max="0" drawMode="2" grey="127"/>
	<inParam inClass="vulva" min="0" max="0" drawMode="2" grey="127"/>
	<inParam inClass="penis" min="0" max="0" drawMode="2" grey="127"/>
	<inParam inClass="vagina" min="0" max="0" drawMode="2" grey="127"/>
	<inParam inClass="buttocks" min="0" max="0" drawMode="2" grey="127"/>
	<inParam inClass="anus" min="0" max="0" drawMode="2" grey="127"/>
</inParams>; // INParams | 
    try {
      apiInstance.setINParams(inParams);
    } catch (ApiException e) {
      System.err.println("Exception when calling AiOperationsApi#setINParams");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **inParams** | [**INParams**](INParams.md)|  |

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/xml, application/json
 - **Accept**: Not defined

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**400** | Bad request. Check for badly formatted request body. |  -  |
**200** | successful operation |  -  |

