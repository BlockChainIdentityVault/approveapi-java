/*
 * ApproveAPISwagger
 * The simple API to request a user's approval on anything via email + sms.
 *
 * OpenAPI spec version: 1.0.1
 * Contact: dev@approveapi.com
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */


package com.approveapi;

import com.approveapi.ApiCallback;
import com.approveapi.ApiClient;
import com.approveapi.ApiException;
import com.approveapi.ApiResponse;
import com.approveapi.Configuration;
import com.approveapi.Pair;
import com.approveapi.ProgressRequestBody;
import com.approveapi.ProgressResponseBody;

import com.google.gson.reflect.TypeToken;

import java.io.IOException;


import com.approveapi.CreatePromptRequest;
import com.approveapi.Error;
import com.approveapi.Prompt;
import com.approveapi.PromptStatus;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ApproveApi {
    private ApiClient localVarApiClient;

    public ApproveApi() {
        this(Configuration.getDefaultApiClient());
    }

    public ApproveApi(ApiClient apiClient) {
        this.localVarApiClient = apiClient;
    }

    public ApiClient getApiClient() {
        return localVarApiClient;
    }

    public void setApiClient(ApiClient apiClient) {
        this.localVarApiClient = apiClient;
    }

    /**
     * Build call for createPrompt
     * @param createPromptRequest  (required)
     * @param _progressListener Progress listener
     * @param _progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    public okhttp3.Call createPromptCall(CreatePromptRequest createPromptRequest, final ProgressResponseBody.ProgressListener _progressListener, final ProgressRequestBody.ProgressRequestListener _progressRequestListener) throws ApiException {
        Object localVarPostBody = createPromptRequest;

        // create path and map variables
        String localVarPath = "/prompt";

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        Map<String, Object> localVarFormParams = new HashMap<String, Object>();
        final String[] localVarAccepts = {
            "application/json"
        };
        final String localVarAccept = localVarApiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) {
            localVarHeaderParams.put("Accept", localVarAccept);
        }

        final String[] localVarContentTypes = {
            "application/json"
        };
        final String localVarContentType = localVarApiClient.selectHeaderContentType(localVarContentTypes);
        localVarHeaderParams.put("Content-Type", localVarContentType);

        if (_progressListener != null) {
            localVarApiClient.setHttpClient(localVarApiClient.getHttpClient().newBuilder().addNetworkInterceptor(new okhttp3.Interceptor() {
                @Override
                public okhttp3.Response intercept(okhttp3.Interceptor.Chain chain) throws IOException {
                    okhttp3.Response originalResponse = chain.proceed(chain.request());
                    return originalResponse.newBuilder()
                            .body(new ProgressResponseBody(originalResponse.body(), _progressListener))
                            .build();
                }
            }).build());
        }

        String[] localVarAuthNames = new String[] { "apiKey" };
        return localVarApiClient.buildCall(localVarPath, "POST", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, _progressRequestListener);
    }

    @SuppressWarnings("rawtypes")
    private okhttp3.Call createPromptValidateBeforeCall(CreatePromptRequest createPromptRequest, final ProgressResponseBody.ProgressListener _progressListener, final ProgressRequestBody.ProgressRequestListener _progressRequestListener) throws ApiException {
        
        // verify the required parameter 'createPromptRequest' is set
        if (createPromptRequest == null) {
            throw new ApiException("Missing the required parameter 'createPromptRequest' when calling createPrompt(Async)");
        }
        

        okhttp3.Call localVarCall = createPromptCall(createPromptRequest, _progressListener, _progressRequestListener);
        return localVarCall;

    }

    /**
     * Sending a prompt
     * Creates a prompt and pushes it to the user (sends via email, sms, or other supported protocols).
     * @param createPromptRequest  (required)
     * @return Prompt
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public Prompt createPrompt(CreatePromptRequest createPromptRequest) throws ApiException {
        ApiResponse<Prompt> localVarResp = createPromptWithHttpInfo(createPromptRequest);
        return localVarResp.getData();
    }

    /**
     * Sending a prompt
     * Creates a prompt and pushes it to the user (sends via email, sms, or other supported protocols).
     * @param createPromptRequest  (required)
     * @return ApiResponse&lt;Prompt&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<Prompt> createPromptWithHttpInfo(CreatePromptRequest createPromptRequest) throws ApiException {
        okhttp3.Call localVarCall = createPromptValidateBeforeCall(createPromptRequest, null, null);
        Type localVarReturnType = new TypeToken<Prompt>(){}.getType();
        return localVarApiClient.execute(localVarCall, localVarReturnType);
    }

    /**
     * Sending a prompt (asynchronously)
     * Creates a prompt and pushes it to the user (sends via email, sms, or other supported protocols).
     * @param createPromptRequest  (required)
     * @param _callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public okhttp3.Call createPromptAsync(CreatePromptRequest createPromptRequest, final ApiCallback<Prompt> _callback) throws ApiException {

        ProgressResponseBody.ProgressListener _progressListener = null;
        ProgressRequestBody.ProgressRequestListener _progressRequestListener = null;

        if (_callback != null) {
            _progressListener = new ProgressResponseBody.ProgressListener() {
                @Override
                public void update(long bytesRead, long contentLength, boolean done) {
                    _callback.onDownloadProgress(bytesRead, contentLength, done);
                }
            };

            _progressRequestListener = new ProgressRequestBody.ProgressRequestListener() {
                @Override
                public void onRequestProgress(long bytesWritten, long contentLength, boolean done) {
                    _callback.onUploadProgress(bytesWritten, contentLength, done);
                }
            };
        }

        okhttp3.Call localVarCall = createPromptValidateBeforeCall(createPromptRequest, _progressListener, _progressRequestListener);
        Type localVarReturnType = new TypeToken<Prompt>(){}.getType();
        localVarApiClient.executeAsync(localVarCall, localVarReturnType, _callback);
        return localVarCall;
    }
    /**
     * Build call for getPrompt
     * @param id The identifier for a pending or completed prompt. This is returned when you create a prompt. (required)
     * @param longPoll If true, the request waits (long-polls) until the user responds to the prompt or more than 10 minutes pass. Defaults to false. (optional)
     * @param _progressListener Progress listener
     * @param _progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    public okhttp3.Call getPromptCall(String id, Boolean longPoll, final ProgressResponseBody.ProgressListener _progressListener, final ProgressRequestBody.ProgressRequestListener _progressRequestListener) throws ApiException {
        Object localVarPostBody = new Object();

        // create path and map variables
        String localVarPath = "/prompt/{id}"
            .replaceAll("\\{" + "id" + "\\}", localVarApiClient.escapeString(id.toString()));

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        if (longPoll != null) {
            localVarQueryParams.addAll(localVarApiClient.parameterToPair("long_poll", longPoll));
        }

        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        Map<String, Object> localVarFormParams = new HashMap<String, Object>();
        final String[] localVarAccepts = {
            "application/json"
        };
        final String localVarAccept = localVarApiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) {
            localVarHeaderParams.put("Accept", localVarAccept);
        }

        final String[] localVarContentTypes = {
            
        };
        final String localVarContentType = localVarApiClient.selectHeaderContentType(localVarContentTypes);
        localVarHeaderParams.put("Content-Type", localVarContentType);

        if (_progressListener != null) {
            localVarApiClient.setHttpClient(localVarApiClient.getHttpClient().newBuilder().addNetworkInterceptor(new okhttp3.Interceptor() {
                @Override
                public okhttp3.Response intercept(okhttp3.Interceptor.Chain chain) throws IOException {
                    okhttp3.Response originalResponse = chain.proceed(chain.request());
                    return originalResponse.newBuilder()
                            .body(new ProgressResponseBody(originalResponse.body(), _progressListener))
                            .build();
                }
            }).build());
        }

        String[] localVarAuthNames = new String[] { "apiKey" };
        return localVarApiClient.buildCall(localVarPath, "GET", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, _progressRequestListener);
    }

    @SuppressWarnings("rawtypes")
    private okhttp3.Call getPromptValidateBeforeCall(String id, Boolean longPoll, final ProgressResponseBody.ProgressListener _progressListener, final ProgressRequestBody.ProgressRequestListener _progressRequestListener) throws ApiException {
        
        // verify the required parameter 'id' is set
        if (id == null) {
            throw new ApiException("Missing the required parameter 'id' when calling getPrompt(Async)");
        }
        

        okhttp3.Call localVarCall = getPromptCall(id, longPoll, _progressListener, _progressRequestListener);
        return localVarCall;

    }

    /**
     * Retrieve a prompt
     * Retrieve the prompt object with the given ID.
     * @param id The identifier for a pending or completed prompt. This is returned when you create a prompt. (required)
     * @param longPoll If true, the request waits (long-polls) until the user responds to the prompt or more than 10 minutes pass. Defaults to false. (optional)
     * @return Prompt
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public Prompt getPrompt(String id, Boolean longPoll) throws ApiException {
        ApiResponse<Prompt> localVarResp = getPromptWithHttpInfo(id, longPoll);
        return localVarResp.getData();
    }

    /**
     * Retrieve a prompt
     * Retrieve the prompt object with the given ID.
     * @param id The identifier for a pending or completed prompt. This is returned when you create a prompt. (required)
     * @param longPoll If true, the request waits (long-polls) until the user responds to the prompt or more than 10 minutes pass. Defaults to false. (optional)
     * @return ApiResponse&lt;Prompt&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<Prompt> getPromptWithHttpInfo(String id, Boolean longPoll) throws ApiException {
        okhttp3.Call localVarCall = getPromptValidateBeforeCall(id, longPoll, null, null);
        Type localVarReturnType = new TypeToken<Prompt>(){}.getType();
        return localVarApiClient.execute(localVarCall, localVarReturnType);
    }

    /**
     * Retrieve a prompt (asynchronously)
     * Retrieve the prompt object with the given ID.
     * @param id The identifier for a pending or completed prompt. This is returned when you create a prompt. (required)
     * @param longPoll If true, the request waits (long-polls) until the user responds to the prompt or more than 10 minutes pass. Defaults to false. (optional)
     * @param _callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public okhttp3.Call getPromptAsync(String id, Boolean longPoll, final ApiCallback<Prompt> _callback) throws ApiException {

        ProgressResponseBody.ProgressListener _progressListener = null;
        ProgressRequestBody.ProgressRequestListener _progressRequestListener = null;

        if (_callback != null) {
            _progressListener = new ProgressResponseBody.ProgressListener() {
                @Override
                public void update(long bytesRead, long contentLength, boolean done) {
                    _callback.onDownloadProgress(bytesRead, contentLength, done);
                }
            };

            _progressRequestListener = new ProgressRequestBody.ProgressRequestListener() {
                @Override
                public void onRequestProgress(long bytesWritten, long contentLength, boolean done) {
                    _callback.onUploadProgress(bytesWritten, contentLength, done);
                }
            };
        }

        okhttp3.Call localVarCall = getPromptValidateBeforeCall(id, longPoll, _progressListener, _progressRequestListener);
        Type localVarReturnType = new TypeToken<Prompt>(){}.getType();
        localVarApiClient.executeAsync(localVarCall, localVarReturnType, _callback);
        return localVarCall;
    }
    /**
     * Build call for getPromptStatus
     * @param id The prompt identifier. (required)
     * @param _progressListener Progress listener
     * @param _progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    public okhttp3.Call getPromptStatusCall(String id, final ProgressResponseBody.ProgressListener _progressListener, final ProgressRequestBody.ProgressRequestListener _progressRequestListener) throws ApiException {
        Object localVarPostBody = new Object();

        // create path and map variables
        String localVarPath = "/prompt/{id}/status"
            .replaceAll("\\{" + "id" + "\\}", localVarApiClient.escapeString(id.toString()));

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        Map<String, Object> localVarFormParams = new HashMap<String, Object>();
        final String[] localVarAccepts = {
            "application/json"
        };
        final String localVarAccept = localVarApiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) {
            localVarHeaderParams.put("Accept", localVarAccept);
        }

        final String[] localVarContentTypes = {
            
        };
        final String localVarContentType = localVarApiClient.selectHeaderContentType(localVarContentTypes);
        localVarHeaderParams.put("Content-Type", localVarContentType);

        if (_progressListener != null) {
            localVarApiClient.setHttpClient(localVarApiClient.getHttpClient().newBuilder().addNetworkInterceptor(new okhttp3.Interceptor() {
                @Override
                public okhttp3.Response intercept(okhttp3.Interceptor.Chain chain) throws IOException {
                    okhttp3.Response originalResponse = chain.proceed(chain.request());
                    return originalResponse.newBuilder()
                            .body(new ProgressResponseBody(originalResponse.body(), _progressListener))
                            .build();
                }
            }).build());
        }

        String[] localVarAuthNames = new String[] {  };
        return localVarApiClient.buildCall(localVarPath, "GET", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, _progressRequestListener);
    }

    @SuppressWarnings("rawtypes")
    private okhttp3.Call getPromptStatusValidateBeforeCall(String id, final ProgressResponseBody.ProgressListener _progressListener, final ProgressRequestBody.ProgressRequestListener _progressRequestListener) throws ApiException {
        
        // verify the required parameter 'id' is set
        if (id == null) {
            throw new ApiException("Missing the required parameter 'id' when calling getPromptStatus(Async)");
        }
        

        okhttp3.Call localVarCall = getPromptStatusCall(id, _progressListener, _progressRequestListener);
        return localVarCall;

    }

    /**
     * Check prompt status
     * Returns whether a prompt has been completed by the user. This request does not require authentication, and so can be used client-side without sharing API credentials.
     * @param id The prompt identifier. (required)
     * @return PromptStatus
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public PromptStatus getPromptStatus(String id) throws ApiException {
        ApiResponse<PromptStatus> localVarResp = getPromptStatusWithHttpInfo(id);
        return localVarResp.getData();
    }

    /**
     * Check prompt status
     * Returns whether a prompt has been completed by the user. This request does not require authentication, and so can be used client-side without sharing API credentials.
     * @param id The prompt identifier. (required)
     * @return ApiResponse&lt;PromptStatus&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<PromptStatus> getPromptStatusWithHttpInfo(String id) throws ApiException {
        okhttp3.Call localVarCall = getPromptStatusValidateBeforeCall(id, null, null);
        Type localVarReturnType = new TypeToken<PromptStatus>(){}.getType();
        return localVarApiClient.execute(localVarCall, localVarReturnType);
    }

    /**
     * Check prompt status (asynchronously)
     * Returns whether a prompt has been completed by the user. This request does not require authentication, and so can be used client-side without sharing API credentials.
     * @param id The prompt identifier. (required)
     * @param _callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public okhttp3.Call getPromptStatusAsync(String id, final ApiCallback<PromptStatus> _callback) throws ApiException {

        ProgressResponseBody.ProgressListener _progressListener = null;
        ProgressRequestBody.ProgressRequestListener _progressRequestListener = null;

        if (_callback != null) {
            _progressListener = new ProgressResponseBody.ProgressListener() {
                @Override
                public void update(long bytesRead, long contentLength, boolean done) {
                    _callback.onDownloadProgress(bytesRead, contentLength, done);
                }
            };

            _progressRequestListener = new ProgressRequestBody.ProgressRequestListener() {
                @Override
                public void onRequestProgress(long bytesWritten, long contentLength, boolean done) {
                    _callback.onUploadProgress(bytesWritten, contentLength, done);
                }
            };
        }

        okhttp3.Call localVarCall = getPromptStatusValidateBeforeCall(id, _progressListener, _progressRequestListener);
        Type localVarReturnType = new TypeToken<PromptStatus>(){}.getType();
        localVarApiClient.executeAsync(localVarCall, localVarReturnType, _callback);
        return localVarCall;
    }
}
