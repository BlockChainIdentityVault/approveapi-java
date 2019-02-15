# ApproveApi

All URIs are relative to *https://approve.sh*

Method | HTTP request | Description
------------- | ------------- | -------------
[**createPrompt**](ApproveApi.md#createPrompt) | **POST** /prompt | Sending a prompt
[**getPrompt**](ApproveApi.md#getPrompt) | **GET** /prompt/{id} | Retrieve a prompt
[**getPromptStatus**](ApproveApi.md#getPromptStatus) | **GET** /prompt/{id}/status | Check prompt status


<a name="createPrompt"></a>
# **createPrompt**
> Prompt createPrompt(createPromptRequest)

Sending a prompt

Creates a prompt and pushes it to the user (sends via email, sms, or other supported protocols).

### Example
```java
// Import classes:
//import com.approveapi.ApiClient;
//import com.approveapi.ApiException;
//import com.approveapi.Configuration;
//import com.approveapi.auth.*;
//import com.approveapi.ApproveApi;

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
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **createPromptRequest** | [**CreatePromptRequest**](CreatePromptRequest.md)|  |

### Return type

[**Prompt**](Prompt.md)

### Authorization

[apiKey](../README.md#apiKey)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="getPrompt"></a>
# **getPrompt**
> Prompt getPrompt(id, longPoll)

Retrieve a prompt

Retrieve the prompt object with the given ID.

### Example
```java
// Import classes:
//import com.approveapi.ApiClient;
//import com.approveapi.ApiException;
//import com.approveapi.Configuration;
//import com.approveapi.auth.*;
//import com.approveapi.ApproveApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure HTTP basic authorization: apiKey
HttpBasicAuth apiKey = (HttpBasicAuth) defaultClient.getAuthentication("apiKey");
apiKey.setUsername("YOUR USERNAME");
apiKey.setPassword("YOUR PASSWORD");

ApproveApi apiInstance = new ApproveApi();
String id = "id_example"; // String | The identifier for a pending or completed prompt. This is returned when you create a prompt.
Boolean longPoll = true; // Boolean | If true, the request waits (long-polls) until the user responds to the prompt or more than 10 minutes pass. Defaults to false.
try {
    Prompt result = apiInstance.getPrompt(id, longPoll);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ApproveApi#getPrompt");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **String**| The identifier for a pending or completed prompt. This is returned when you create a prompt. |
 **longPoll** | **Boolean**| If true, the request waits (long-polls) until the user responds to the prompt or more than 10 minutes pass. Defaults to false. | [optional]

### Return type

[**Prompt**](Prompt.md)

### Authorization

[apiKey](../README.md#apiKey)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="getPromptStatus"></a>
# **getPromptStatus**
> PromptStatus getPromptStatus(id)

Check prompt status

Returns whether a prompt has been completed by the user. This request does not require authentication, and so can be used client-side without sharing API credentials.

### Example
```java
// Import classes:
//import com.approveapi.ApiException;
//import com.approveapi.ApproveApi;


ApproveApi apiInstance = new ApproveApi();
String id = "id_example"; // String | The prompt identifier.
try {
    PromptStatus result = apiInstance.getPromptStatus(id);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ApproveApi#getPromptStatus");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **String**| The prompt identifier. |

### Return type

[**PromptStatus**](PromptStatus.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

