# approveapi-client

ApproveAPISwagger
- API version: 1.0.1

The simple API to request a user's approval on anything via email + sms.


*Automatically generated by the [OpenAPI Generator](https://openapi-generator.tech)*


## Requirements

Building the API client library requires:
1. Java 1.7+
2. Maven/Gradle

## Installation

To install the API client library to your local Maven repository, simply execute:

```shell
mvn clean install
```

To deploy it to a remote Maven repository instead, configure the settings of the repository and execute:

```shell
mvn clean deploy
```

Refer to the [OSSRH Guide](http://central.sonatype.org/pages/ossrh-guide.html) for more information.

### Maven users

Add this dependency to your project's POM:

```xml
<dependency>
  <groupId>com.approveapi</groupId>
  <artifactId>approveapi-client</artifactId>
  <version>1.0.9</version>
  <scope>compile</scope>
</dependency>
```

### Gradle users

Add this dependency to your project's build file:

```groovy
compile "com.approveapi:approveapi-client:1.0.9"
```

### Others

At first generate the JAR by executing:

```shell
mvn clean package
```

Then manually install the following JARs:

* `target/approveapi-client-1.0.9.jar`
* `target/lib/*.jar`

## Getting Started

Please follow the [installation](#installation) instruction and execute the following Java code:

```java

import com.approveapi.*;
import com.approveapi.auth.*;
import com.approveapi.*;
import com.approveapi.ApproveApi;

import java.io.File;
import java.util.*;

public class ApproveApiExample {

    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        
        // Configure HTTP basic authorization: apiKey
        HttpBasicAuth apiKey = (HttpBasicAuth) defaultClient.getAuthentication("apiKey");
        apiKey.setUsername("YOUR USERNAME");
        apiKey.setPassword("YOUR PASSWORD");

        ApproveApi apiInstance = new ApproveApi();
        CreatePromptRequest createPromptRequest = new CreatePromptRequest(); // CreatePromptRequest | 
        try {
            Prompt result = apiInstance.createPrompt(createPromptRequest);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling ApproveApi#createPrompt");
            e.printStackTrace();
        }
    }
}

```

## Documentation for API Endpoints

All URIs are relative to *https://approve.sh*

Class | Method | HTTP request | Description
------------ | ------------- | ------------- | -------------
*ApproveApi* | [**createPrompt**](docs/ApproveApi.md#createPrompt) | **POST** /prompt | Sending a prompt
*ApproveApi* | [**getPrompt**](docs/ApproveApi.md#getPrompt) | **GET** /prompt/{id} | Retrieve a prompt
*ApproveApi* | [**getPromptStatus**](docs/ApproveApi.md#getPromptStatus) | **GET** /prompt/{id}/status | Check prompt status


## Documentation for Models

 - [AnswerMetadata](docs/AnswerMetadata.md)
 - [CreatePromptRequest](docs/CreatePromptRequest.md)
 - [Error](docs/Error.md)
 - [Prompt](docs/Prompt.md)
 - [PromptAnswer](docs/PromptAnswer.md)
 - [PromptMetadata](docs/PromptMetadata.md)
 - [PromptStatus](docs/PromptStatus.md)


## Documentation for Authorization

Authentication schemes defined for the API:
### apiKey

- **Type**: HTTP basic authentication


## Recommendation

It's recommended to create an instance of `ApiClient` per thread in a multithreaded environment to avoid any potential issues.

## Author

dev@approveapi.com

