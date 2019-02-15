package com.approveapi;

import com.approveapi.ApiClient;

import com.approveapi.CreatePromptRequest;
import com.approveapi.Error;
import com.approveapi.Prompt;
import com.approveapi.PromptStatus;

import com.fasterxml.jackson.core.type.TypeReference;
import com.google.api.client.http.GenericUrl;
import com.google.api.client.http.HttpContent;
import com.google.api.client.http.InputStreamContent;
import com.google.api.client.http.HttpMethods;
import com.google.api.client.http.HttpResponse;
import com.google.api.client.json.Json;

import javax.ws.rs.core.UriBuilder;
import java.io.IOException;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.ArrayList;


public class ApproveApi {
    private ApiClient apiClient;

    public ApproveApi() {
        this(new ApiClient());
    }

    public ApproveApi(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    public ApiClient getApiClient() {
        return apiClient;
    }

    public void setApiClient(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

  /**
    * Sending a prompt
    * Creates a prompt and pushes it to the user (sends via email, sms, or other supported protocols).
    * <p><b>200</b> - OK
    * <p><b>504</b> - Polling timed out with no user response
    * <p><b>401</b> - Missing or invalid API key in the username basic auth field
    * <p><b>400</b> - Invalid parameters
    * @param createPromptRequest The createPromptRequest parameter
    * @return Prompt
    * @throws IOException if an error occurs while attempting to invoke the API
    **/
    public Prompt createPrompt(CreatePromptRequest createPromptRequest) throws IOException {
        HttpResponse response = createPromptForHttpResponse(createPromptRequest);
        TypeReference typeRef = new TypeReference<Prompt>() {};
        return apiClient.getObjectMapper().readValue(response.getContent(), typeRef);
    }

  /**
    * Sending a prompt
    * Creates a prompt and pushes it to the user (sends via email, sms, or other supported protocols).
    * <p><b>200</b> - OK
    * <p><b>504</b> - Polling timed out with no user response
    * <p><b>401</b> - Missing or invalid API key in the username basic auth field
    * <p><b>400</b> - Invalid parameters
    * @param createPromptRequest The createPromptRequest parameter
    * @param params Map of query params. A collection will be interpreted as passing in multiple instances of the same query param.
    * @return Prompt
    * @throws IOException if an error occurs while attempting to invoke the API
    **/
    public Prompt createPrompt(CreatePromptRequest createPromptRequest, Map<String, Object> params) throws IOException {
        HttpResponse response = createPromptForHttpResponse(createPromptRequest, params);
        TypeReference typeRef = new TypeReference<Prompt>() {};
        return apiClient.getObjectMapper().readValue(response.getContent(), typeRef);
    }

    public HttpResponse createPromptForHttpResponse(CreatePromptRequest createPromptRequest) throws IOException {
        // verify the required parameter 'createPromptRequest' is set
        if (createPromptRequest == null) {
            throw new IllegalArgumentException("Missing the required parameter 'createPromptRequest' when calling createPrompt");
        }
        UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/prompt");

        String url = uriBuilder.build().toString();
        GenericUrl genericUrl = new GenericUrl(url);

        HttpContent content = apiClient.new JacksonJsonHttpContent(createPromptRequest);
        return apiClient.getHttpRequestFactory().buildRequest(HttpMethods.POST, genericUrl, content).execute();
    }

      public HttpResponse createPromptForHttpResponse(java.io.InputStream createPromptRequest, String mediaType) throws IOException {
          // verify the required parameter 'createPromptRequest' is set
              if (createPromptRequest == null) {
              throw new IllegalArgumentException("Missing the required parameter 'createPromptRequest' when calling createPrompt");
              }
              UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/prompt");

              String url = uriBuilder.build().toString();
              GenericUrl genericUrl = new GenericUrl(url);

              HttpContent content = createPromptRequest == null ?
                apiClient.new JacksonJsonHttpContent(null) :
                new InputStreamContent(mediaType == null ? Json.MEDIA_TYPE : mediaType, createPromptRequest);
              return apiClient.getHttpRequestFactory().buildRequest(HttpMethods.POST, genericUrl, content).execute();
      }

    public HttpResponse createPromptForHttpResponse(CreatePromptRequest createPromptRequest, Map<String, Object> params) throws IOException {
        // verify the required parameter 'createPromptRequest' is set
        if (createPromptRequest == null) {
            throw new IllegalArgumentException("Missing the required parameter 'createPromptRequest' when calling createPrompt");
        }
        UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/prompt");

        // Copy the params argument if present, to allow passing in immutable maps
        Map<String, Object> allParams = params == null ? new HashMap<String, Object>() : new HashMap<String, Object>(params);

        for (Map.Entry<String, Object> entry: allParams.entrySet()) {
            String key = entry.getKey();
            Object value = entry.getValue();

            if (key != null && value != null) {
                if (value instanceof Collection) {
                    uriBuilder = uriBuilder.queryParam(key, ((Collection) value).toArray());
                } else if (value instanceof Object[]) {
                    uriBuilder = uriBuilder.queryParam(key, (Object[]) value);
                } else {
                    uriBuilder = uriBuilder.queryParam(key, value);
                }
            }
        }

        String url = uriBuilder.build().toString();
        GenericUrl genericUrl = new GenericUrl(url);

        HttpContent content = apiClient.new JacksonJsonHttpContent(createPromptRequest);
        return apiClient.getHttpRequestFactory().buildRequest(HttpMethods.POST, genericUrl, content).execute();
    }


  /**
    * Retrieve a prompt
    * Retrieve the prompt object with the given ID.
    * <p><b>200</b> - OK
    * <p><b>404</b> - A prompt with this identifier could not be found
    * @param id The identifier for a pending or completed prompt. This is returned when you create a prompt.
    * @param longPoll If true, the request waits (long-polls) until the user responds to the prompt or more than 10 minutes pass. Defaults to false.
    * @return Prompt
    * @throws IOException if an error occurs while attempting to invoke the API
    **/
    public Prompt getPrompt(String id, Boolean longPoll) throws IOException {
        HttpResponse response = getPromptForHttpResponse(id, longPoll);
        TypeReference typeRef = new TypeReference<Prompt>() {};
        return apiClient.getObjectMapper().readValue(response.getContent(), typeRef);
    }

  /**
    * Retrieve a prompt
    * Retrieve the prompt object with the given ID.
    * <p><b>200</b> - OK
    * <p><b>404</b> - A prompt with this identifier could not be found
    * @param id The identifier for a pending or completed prompt. This is returned when you create a prompt.
    * @param params Map of query params. A collection will be interpreted as passing in multiple instances of the same query param.
    * @return Prompt
    * @throws IOException if an error occurs while attempting to invoke the API
    **/
    public Prompt getPrompt(String id, Map<String, Object> params) throws IOException {
        HttpResponse response = getPromptForHttpResponse(id, params);
        TypeReference typeRef = new TypeReference<Prompt>() {};
        return apiClient.getObjectMapper().readValue(response.getContent(), typeRef);
    }

    public HttpResponse getPromptForHttpResponse(String id, Boolean longPoll) throws IOException {
        // verify the required parameter 'id' is set
        if (id == null) {
            throw new IllegalArgumentException("Missing the required parameter 'id' when calling getPrompt");
        }
        // create a map of path variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("id", id);
        UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/prompt/{id}");
        if (longPoll != null) {
            String key = "long_poll";
            Object value = longPoll;
            if (value instanceof Collection) {
                uriBuilder = uriBuilder.queryParam(key, ((Collection) value).toArray());
            } else if (value instanceof Object[]) {
                uriBuilder = uriBuilder.queryParam(key, (Object[]) value);
            } else {
                uriBuilder = uriBuilder.queryParam(key, value);
            }
        }

        String url = uriBuilder.buildFromMap(uriVariables).toString();
        GenericUrl genericUrl = new GenericUrl(url);

        HttpContent content = null;
        return apiClient.getHttpRequestFactory().buildRequest(HttpMethods.GET, genericUrl, content).execute();
    }

    public HttpResponse getPromptForHttpResponse(String id, Map<String, Object> params) throws IOException {
        // verify the required parameter 'id' is set
        if (id == null) {
            throw new IllegalArgumentException("Missing the required parameter 'id' when calling getPrompt");
        }
        // create a map of path variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("id", id);
        UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/prompt/{id}");

        // Copy the params argument if present, to allow passing in immutable maps
        Map<String, Object> allParams = params == null ? new HashMap<String, Object>() : new HashMap<String, Object>(params);

        for (Map.Entry<String, Object> entry: allParams.entrySet()) {
            String key = entry.getKey();
            Object value = entry.getValue();

            if (key != null && value != null) {
                if (value instanceof Collection) {
                    uriBuilder = uriBuilder.queryParam(key, ((Collection) value).toArray());
                } else if (value instanceof Object[]) {
                    uriBuilder = uriBuilder.queryParam(key, (Object[]) value);
                } else {
                    uriBuilder = uriBuilder.queryParam(key, value);
                }
            }
        }

        String url = uriBuilder.buildFromMap(uriVariables).toString();
        GenericUrl genericUrl = new GenericUrl(url);

        HttpContent content = null;
        return apiClient.getHttpRequestFactory().buildRequest(HttpMethods.GET, genericUrl, content).execute();
    }


  /**
    * Check prompt status
    * Returns whether a prompt has been completed by the user. This request does not require authentication, and so can be used client-side without sharing API credentials.
    * <p><b>200</b> - OK
    * <p><b>404</b> - A prompt with this identifier could not be found
    * @param id The prompt identifier.
    * @return PromptStatus
    * @throws IOException if an error occurs while attempting to invoke the API
    **/
    public PromptStatus getPromptStatus(String id) throws IOException {
        HttpResponse response = getPromptStatusForHttpResponse(id);
        TypeReference typeRef = new TypeReference<PromptStatus>() {};
        return apiClient.getObjectMapper().readValue(response.getContent(), typeRef);
    }

  /**
    * Check prompt status
    * Returns whether a prompt has been completed by the user. This request does not require authentication, and so can be used client-side without sharing API credentials.
    * <p><b>200</b> - OK
    * <p><b>404</b> - A prompt with this identifier could not be found
    * @param id The prompt identifier.
    * @param params Map of query params. A collection will be interpreted as passing in multiple instances of the same query param.
    * @return PromptStatus
    * @throws IOException if an error occurs while attempting to invoke the API
    **/
    public PromptStatus getPromptStatus(String id, Map<String, Object> params) throws IOException {
        HttpResponse response = getPromptStatusForHttpResponse(id, params);
        TypeReference typeRef = new TypeReference<PromptStatus>() {};
        return apiClient.getObjectMapper().readValue(response.getContent(), typeRef);
    }

    public HttpResponse getPromptStatusForHttpResponse(String id) throws IOException {
        // verify the required parameter 'id' is set
        if (id == null) {
            throw new IllegalArgumentException("Missing the required parameter 'id' when calling getPromptStatus");
        }
        // create a map of path variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("id", id);
        UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/prompt/{id}/status");

        String url = uriBuilder.buildFromMap(uriVariables).toString();
        GenericUrl genericUrl = new GenericUrl(url);

        HttpContent content = null;
        return apiClient.getHttpRequestFactory().buildRequest(HttpMethods.GET, genericUrl, content).execute();
    }

    public HttpResponse getPromptStatusForHttpResponse(String id, Map<String, Object> params) throws IOException {
        // verify the required parameter 'id' is set
        if (id == null) {
            throw new IllegalArgumentException("Missing the required parameter 'id' when calling getPromptStatus");
        }
        // create a map of path variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("id", id);
        UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/prompt/{id}/status");

        // Copy the params argument if present, to allow passing in immutable maps
        Map<String, Object> allParams = params == null ? new HashMap<String, Object>() : new HashMap<String, Object>(params);

        for (Map.Entry<String, Object> entry: allParams.entrySet()) {
            String key = entry.getKey();
            Object value = entry.getValue();

            if (key != null && value != null) {
                if (value instanceof Collection) {
                    uriBuilder = uriBuilder.queryParam(key, ((Collection) value).toArray());
                } else if (value instanceof Object[]) {
                    uriBuilder = uriBuilder.queryParam(key, (Object[]) value);
                } else {
                    uriBuilder = uriBuilder.queryParam(key, value);
                }
            }
        }

        String url = uriBuilder.buildFromMap(uriVariables).toString();
        GenericUrl genericUrl = new GenericUrl(url);

        HttpContent content = null;
        return apiClient.getHttpRequestFactory().buildRequest(HttpMethods.GET, genericUrl, content).execute();
    }


}
