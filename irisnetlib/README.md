# irisnet-java-client

## Requirements

Building the API client library requires [Maven](https://maven.apache.org/) to be installed.

## Installation

To install the API client library to your local Maven repository, simply execute:

```shell
mvn install
```

To deploy it to a remote Maven repository instead, configure the settings of the repository and execute:

```shell
mvn deploy
```

Refer to the [official documentation](https://maven.apache.org/plugins/maven-deploy-plugin/usage.html) for more information.

### Maven users

Add this dependency to your project's POM:

```xml
<dependency>
    <groupId>de.irisnet.java.client</groupId>
    <artifactId>irisnet-java-client</artifactId>
    <version>1.0.0</version>
    <scope>compile</scope>
</dependency>
```

### Gradle users

Add this dependency to your project's build file:

```groovy
compile "de.irisnet.java.client:irisnet-java-client:1.0.0"
```

### Others

At first generate the JAR by executing:

    mvn package

Then manually install the following JARs:

- target/irisnet-java-client-1.0.0.jar
- target/lib/*.jar

## Getting Started

Please follow the [installation](#installation) instruction and execute the following Java code:

```java

import de.irisnet.java.client.AIOperationsApi;

public class AIOperationsApiExample {

    public static void main(String[] args) {
        AIOperationsApi apiInstance = new AIOperationsApi();
        String licenseKey = null; // String | License obtained from irisnet.de shop.
        Integer detail = 1; // Integer | Sets the response details. Use 1 for minimum detail (better API performance), 2 for medium details and 3 for all details.
        File file = null; // File | 
        try {
            IrisNet result = apiInstance.checkImage(licenseKey, detail, file);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling AIOperationsApi#checkImage");
            e.printStackTrace();
        }
    }
}

```

## Documentation for API Endpoints

All URIs are relative to *https://api.irisnet.de*

Class | Method | HTTP request | Description
------------ | ------------- | ------------- | -------------
*AIOperationsApi* | [**checkImage**](docs/AIOperationsApi.md#checkImage) | **POST** /v1/check-image/{licenseKey} | Upload and check image against previously chosen configuration.
*AIOperationsApi* | [**checkImageUrl**](docs/AIOperationsApi.md#checkImageUrl) | **POST** /v1/check-url/{licenseKey} | Check image url against previously chosen configuration.
*AIOperationsApi* | [**downloadProcessed**](docs/AIOperationsApi.md#downloadProcessed) | **GET** /v1/download/{filename} | Get the resulting image file.
*AIOperationsApi* | [**setINDefine**](docs/AIOperationsApi.md#setINDefine) | **POST** /v1/set-definition | Set definitions via pre-defined prototypes.
*AIOperationsApi* | [**setINParams**](docs/AIOperationsApi.md#setINParams) | **POST** /v1/set-parameters | Set the behaviour parameters for one object class.
*LicenseKeyOperationsApi* | [**getAICost**](docs/LicenseKeyOperationsApi.md#getAICost) | **GET** /v1/cost | Get the cost of the previously set parameters. The cost of the configuration is subtracted from the license key during each check.
*LicenseKeyOperationsApi* | [**getLicenseInfo**](docs/LicenseKeyOperationsApi.md#getLicenseInfo) | **GET** /v1/info/{licenseKey} | Get information from given license key.


## Documentation for Models

 - [Error](docs/Error.md)
 - [INDefault](docs/INDefault.md)
 - [INDefineAI](docs/INDefineAI.md)
 - [INImage](docs/INImage.md)
 - [INObject](docs/INObject.md)
 - [INParam](docs/INParam.md)
 - [INParams](docs/INParams.md)
 - [INRule](docs/INRule.md)
 - [InlineObject](docs/InlineObject.md)
 - [IrisNet](docs/IrisNet.md)
 - [LicenseInfo](docs/LicenseInfo.md)


## Documentation for Authorization

All endpoints do not require authorization.
Authentication schemes defined for the API:

## Recommendation

It's recommended to create an instance of `ApiClient` per thread in a multithreaded environment to avoid any potential issues.

## Author



