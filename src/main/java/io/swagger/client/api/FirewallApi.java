/*
 * Upcloud api
 * The UpCloud API consists of operations used to control resources on UpCloud. The API is a web service interface. HTTPS is used to connect to the API. The API follows the principles of a RESTful web service wherever possible. The base URL for all API operations is  https://api.upcloud.com/. All API operations require authentication.
 *
 * OpenAPI spec version: 1.2.0
 * 
 */


package io.swagger.client.api;

import io.swagger.client.ApiCallback;
import io.swagger.client.ApiClient;
import io.swagger.client.ApiException;
import io.swagger.client.ApiResponse;
import io.swagger.client.Configuration;
import io.swagger.client.Pair;
import io.swagger.client.ProgressRequestBody;
import io.swagger.client.ProgressResponseBody;

import com.google.gson.reflect.TypeToken;

import java.io.IOException;


import io.swagger.client.model.Error;
import io.swagger.client.model.FirewallRule;
import io.swagger.client.model.FirewallRuleDetailsResponse;
import io.swagger.client.model.FirewallRuleListResponse;
import java.util.UUID;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FirewallApi {
    private ApiClient apiClient;

    public FirewallApi() {
        this(Configuration.getDefaultApiClient());
    }

    public FirewallApi(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    public ApiClient getApiClient() {
        return apiClient;
    }

    public void setApiClient(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    /**
     * Build call for createFirewallRule
     * @param serverId Server id (required)
     * @param firewallRule  (required)
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    public com.squareup.okhttp.Call createFirewallRuleCall(UUID serverId, FirewallRule firewallRule, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = firewallRule;
        
        // create path and map variables
        String localVarPath = "/server/{serverId}/firewall_rule"
            .replaceAll("\\{" + "serverId" + "\\}", apiClient.escapeString(serverId.toString()));

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();

        Map<String, String> localVarHeaderParams = new HashMap<String, String>();

        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        final String[] localVarAccepts = {
            
        };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) localVarHeaderParams.put("Accept", localVarAccept);

        final String[] localVarContentTypes = {
            
        };
        final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);
        localVarHeaderParams.put("Content-Type", localVarContentType);

        if(progressListener != null) {
            apiClient.getHttpClient().networkInterceptors().add(new com.squareup.okhttp.Interceptor() {
                @Override
                public com.squareup.okhttp.Response intercept(com.squareup.okhttp.Interceptor.Chain chain) throws IOException {
                    com.squareup.okhttp.Response originalResponse = chain.proceed(chain.request());
                    return originalResponse.newBuilder()
                    .body(new ProgressResponseBody(originalResponse.body(), progressListener))
                    .build();
                }
            });
        }

        String[] localVarAuthNames = new String[] {  };
        return apiClient.buildCall(localVarPath, "POST", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }
    
    @SuppressWarnings("rawtypes")
    private com.squareup.okhttp.Call createFirewallRuleValidateBeforeCall(UUID serverId, FirewallRule firewallRule, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        
        // verify the required parameter 'serverId' is set
        if (serverId == null) {
            throw new ApiException("Missing the required parameter 'serverId' when calling createFirewallRule(Async)");
        }
        
        // verify the required parameter 'firewallRule' is set
        if (firewallRule == null) {
            throw new ApiException("Missing the required parameter 'firewallRule' when calling createFirewallRule(Async)");
        }
        
        
        com.squareup.okhttp.Call call = createFirewallRuleCall(serverId, firewallRule, progressListener, progressRequestListener);
        return call;

        
        
        
        
    }

    /**
     * Create firewall rule
     * Creates a new firewall rule
     * @param serverId Server id (required)
     * @param firewallRule  (required)
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public void createFirewallRule(UUID serverId, FirewallRule firewallRule) throws ApiException {
        createFirewallRuleWithHttpInfo(serverId, firewallRule);
    }

    /**
     * Create firewall rule
     * Creates a new firewall rule
     * @param serverId Server id (required)
     * @param firewallRule  (required)
     * @return ApiResponse&lt;Void&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<Void> createFirewallRuleWithHttpInfo(UUID serverId, FirewallRule firewallRule) throws ApiException {
        com.squareup.okhttp.Call call = createFirewallRuleValidateBeforeCall(serverId, firewallRule, null, null);
        return apiClient.execute(call);
    }

    /**
     * Create firewall rule (asynchronously)
     * Creates a new firewall rule
     * @param serverId Server id (required)
     * @param firewallRule  (required)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call createFirewallRuleAsync(UUID serverId, FirewallRule firewallRule, final ApiCallback<Void> callback) throws ApiException {

        ProgressResponseBody.ProgressListener progressListener = null;
        ProgressRequestBody.ProgressRequestListener progressRequestListener = null;

        if (callback != null) {
            progressListener = new ProgressResponseBody.ProgressListener() {
                @Override
                public void update(long bytesRead, long contentLength, boolean done) {
                    callback.onDownloadProgress(bytesRead, contentLength, done);
                }
            };

            progressRequestListener = new ProgressRequestBody.ProgressRequestListener() {
                @Override
                public void onRequestProgress(long bytesWritten, long contentLength, boolean done) {
                    callback.onUploadProgress(bytesWritten, contentLength, done);
                }
            };
        }

        com.squareup.okhttp.Call call = createFirewallRuleValidateBeforeCall(serverId, firewallRule, progressListener, progressRequestListener);
        apiClient.executeAsync(call, callback);
        return call;
    }
    /**
     * Build call for deleteFirewallRule
     * @param serverId Server id (required)
     * @param firewallRuleNumber Denotes the index of the firewall rule in the server&#39;s firewall rule list (required)
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    public com.squareup.okhttp.Call deleteFirewallRuleCall(UUID serverId, UUID firewallRuleNumber, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;
        
        // create path and map variables
        String localVarPath = "/server/{serverId}/firewall_rule/{firewallRuleNumber}"
            .replaceAll("\\{" + "serverId" + "\\}", apiClient.escapeString(serverId.toString()))
            .replaceAll("\\{" + "firewallRuleNumber" + "\\}", apiClient.escapeString(firewallRuleNumber.toString()));

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();

        Map<String, String> localVarHeaderParams = new HashMap<String, String>();

        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        final String[] localVarAccepts = {
            
        };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) localVarHeaderParams.put("Accept", localVarAccept);

        final String[] localVarContentTypes = {
            
        };
        final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);
        localVarHeaderParams.put("Content-Type", localVarContentType);

        if(progressListener != null) {
            apiClient.getHttpClient().networkInterceptors().add(new com.squareup.okhttp.Interceptor() {
                @Override
                public com.squareup.okhttp.Response intercept(com.squareup.okhttp.Interceptor.Chain chain) throws IOException {
                    com.squareup.okhttp.Response originalResponse = chain.proceed(chain.request());
                    return originalResponse.newBuilder()
                    .body(new ProgressResponseBody(originalResponse.body(), progressListener))
                    .build();
                }
            });
        }

        String[] localVarAuthNames = new String[] {  };
        return apiClient.buildCall(localVarPath, "DELETE", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }
    
    @SuppressWarnings("rawtypes")
    private com.squareup.okhttp.Call deleteFirewallRuleValidateBeforeCall(UUID serverId, UUID firewallRuleNumber, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        
        // verify the required parameter 'serverId' is set
        if (serverId == null) {
            throw new ApiException("Missing the required parameter 'serverId' when calling deleteFirewallRule(Async)");
        }
        
        // verify the required parameter 'firewallRuleNumber' is set
        if (firewallRuleNumber == null) {
            throw new ApiException("Missing the required parameter 'firewallRuleNumber' when calling deleteFirewallRule(Async)");
        }
        
        
        com.squareup.okhttp.Call call = deleteFirewallRuleCall(serverId, firewallRuleNumber, progressListener, progressRequestListener);
        return call;

        
        
        
        
    }

    /**
     * Remove firewall rule
     * Removes a firewall rule from a server. Firewall rules must be removed individually. The positions of remaining firewall rules will be adjusted after a rule is removed.
     * @param serverId Server id (required)
     * @param firewallRuleNumber Denotes the index of the firewall rule in the server&#39;s firewall rule list (required)
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public void deleteFirewallRule(UUID serverId, UUID firewallRuleNumber) throws ApiException {
        deleteFirewallRuleWithHttpInfo(serverId, firewallRuleNumber);
    }

    /**
     * Remove firewall rule
     * Removes a firewall rule from a server. Firewall rules must be removed individually. The positions of remaining firewall rules will be adjusted after a rule is removed.
     * @param serverId Server id (required)
     * @param firewallRuleNumber Denotes the index of the firewall rule in the server&#39;s firewall rule list (required)
     * @return ApiResponse&lt;Void&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<Void> deleteFirewallRuleWithHttpInfo(UUID serverId, UUID firewallRuleNumber) throws ApiException {
        com.squareup.okhttp.Call call = deleteFirewallRuleValidateBeforeCall(serverId, firewallRuleNumber, null, null);
        return apiClient.execute(call);
    }

    /**
     * Remove firewall rule (asynchronously)
     * Removes a firewall rule from a server. Firewall rules must be removed individually. The positions of remaining firewall rules will be adjusted after a rule is removed.
     * @param serverId Server id (required)
     * @param firewallRuleNumber Denotes the index of the firewall rule in the server&#39;s firewall rule list (required)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call deleteFirewallRuleAsync(UUID serverId, UUID firewallRuleNumber, final ApiCallback<Void> callback) throws ApiException {

        ProgressResponseBody.ProgressListener progressListener = null;
        ProgressRequestBody.ProgressRequestListener progressRequestListener = null;

        if (callback != null) {
            progressListener = new ProgressResponseBody.ProgressListener() {
                @Override
                public void update(long bytesRead, long contentLength, boolean done) {
                    callback.onDownloadProgress(bytesRead, contentLength, done);
                }
            };

            progressRequestListener = new ProgressRequestBody.ProgressRequestListener() {
                @Override
                public void onRequestProgress(long bytesWritten, long contentLength, boolean done) {
                    callback.onUploadProgress(bytesWritten, contentLength, done);
                }
            };
        }

        com.squareup.okhttp.Call call = deleteFirewallRuleValidateBeforeCall(serverId, firewallRuleNumber, progressListener, progressRequestListener);
        apiClient.executeAsync(call, callback);
        return call;
    }
    /**
     * Build call for getFirewallRule
     * @param serverId Server id (required)
     * @param firewallRuleNumber Denotes the index of the firewall rule in the server&#39;s firewall rule list (required)
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    public com.squareup.okhttp.Call getFirewallRuleCall(UUID serverId, UUID firewallRuleNumber, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;
        
        // create path and map variables
        String localVarPath = "/server/{serverId}/firewall_rule/{firewallRuleNumber}"
            .replaceAll("\\{" + "serverId" + "\\}", apiClient.escapeString(serverId.toString()))
            .replaceAll("\\{" + "firewallRuleNumber" + "\\}", apiClient.escapeString(firewallRuleNumber.toString()));

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();

        Map<String, String> localVarHeaderParams = new HashMap<String, String>();

        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        final String[] localVarAccepts = {
            
        };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) localVarHeaderParams.put("Accept", localVarAccept);

        final String[] localVarContentTypes = {
            
        };
        final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);
        localVarHeaderParams.put("Content-Type", localVarContentType);

        if(progressListener != null) {
            apiClient.getHttpClient().networkInterceptors().add(new com.squareup.okhttp.Interceptor() {
                @Override
                public com.squareup.okhttp.Response intercept(com.squareup.okhttp.Interceptor.Chain chain) throws IOException {
                    com.squareup.okhttp.Response originalResponse = chain.proceed(chain.request());
                    return originalResponse.newBuilder()
                    .body(new ProgressResponseBody(originalResponse.body(), progressListener))
                    .build();
                }
            });
        }

        String[] localVarAuthNames = new String[] {  };
        return apiClient.buildCall(localVarPath, "GET", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }
    
    @SuppressWarnings("rawtypes")
    private com.squareup.okhttp.Call getFirewallRuleValidateBeforeCall(UUID serverId, UUID firewallRuleNumber, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        
        // verify the required parameter 'serverId' is set
        if (serverId == null) {
            throw new ApiException("Missing the required parameter 'serverId' when calling getFirewallRule(Async)");
        }
        
        // verify the required parameter 'firewallRuleNumber' is set
        if (firewallRuleNumber == null) {
            throw new ApiException("Missing the required parameter 'firewallRuleNumber' when calling getFirewallRule(Async)");
        }
        
        
        com.squareup.okhttp.Call call = getFirewallRuleCall(serverId, firewallRuleNumber, progressListener, progressRequestListener);
        return call;

        
        
        
        
    }

    /**
     * Get firewall rule details
     * Returns detailed information about a specific firewall rule
     * @param serverId Server id (required)
     * @param firewallRuleNumber Denotes the index of the firewall rule in the server&#39;s firewall rule list (required)
     * @return FirewallRuleDetailsResponse
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public FirewallRuleDetailsResponse getFirewallRule(UUID serverId, UUID firewallRuleNumber) throws ApiException {
        ApiResponse<FirewallRuleDetailsResponse> resp = getFirewallRuleWithHttpInfo(serverId, firewallRuleNumber);
        return resp.getData();
    }

    /**
     * Get firewall rule details
     * Returns detailed information about a specific firewall rule
     * @param serverId Server id (required)
     * @param firewallRuleNumber Denotes the index of the firewall rule in the server&#39;s firewall rule list (required)
     * @return ApiResponse&lt;FirewallRuleDetailsResponse&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<FirewallRuleDetailsResponse> getFirewallRuleWithHttpInfo(UUID serverId, UUID firewallRuleNumber) throws ApiException {
        com.squareup.okhttp.Call call = getFirewallRuleValidateBeforeCall(serverId, firewallRuleNumber, null, null);
        Type localVarReturnType = new TypeToken<FirewallRuleDetailsResponse>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * Get firewall rule details (asynchronously)
     * Returns detailed information about a specific firewall rule
     * @param serverId Server id (required)
     * @param firewallRuleNumber Denotes the index of the firewall rule in the server&#39;s firewall rule list (required)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call getFirewallRuleAsync(UUID serverId, UUID firewallRuleNumber, final ApiCallback<FirewallRuleDetailsResponse> callback) throws ApiException {

        ProgressResponseBody.ProgressListener progressListener = null;
        ProgressRequestBody.ProgressRequestListener progressRequestListener = null;

        if (callback != null) {
            progressListener = new ProgressResponseBody.ProgressListener() {
                @Override
                public void update(long bytesRead, long contentLength, boolean done) {
                    callback.onDownloadProgress(bytesRead, contentLength, done);
                }
            };

            progressRequestListener = new ProgressRequestBody.ProgressRequestListener() {
                @Override
                public void onRequestProgress(long bytesWritten, long contentLength, boolean done) {
                    callback.onUploadProgress(bytesWritten, contentLength, done);
                }
            };
        }

        com.squareup.okhttp.Call call = getFirewallRuleValidateBeforeCall(serverId, firewallRuleNumber, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<FirewallRuleDetailsResponse>(){}.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /**
     * Build call for serverServerIdFirewallRuleGet
     * @param serverId Server id (required)
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    public com.squareup.okhttp.Call serverServerIdFirewallRuleGetCall(UUID serverId, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;
        
        // create path and map variables
        String localVarPath = "/server/{serverId}/firewall_rule"
            .replaceAll("\\{" + "serverId" + "\\}", apiClient.escapeString(serverId.toString()));

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();

        Map<String, String> localVarHeaderParams = new HashMap<String, String>();

        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        final String[] localVarAccepts = {
            
        };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) localVarHeaderParams.put("Accept", localVarAccept);

        final String[] localVarContentTypes = {
            
        };
        final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);
        localVarHeaderParams.put("Content-Type", localVarContentType);

        if(progressListener != null) {
            apiClient.getHttpClient().networkInterceptors().add(new com.squareup.okhttp.Interceptor() {
                @Override
                public com.squareup.okhttp.Response intercept(com.squareup.okhttp.Interceptor.Chain chain) throws IOException {
                    com.squareup.okhttp.Response originalResponse = chain.proceed(chain.request());
                    return originalResponse.newBuilder()
                    .body(new ProgressResponseBody(originalResponse.body(), progressListener))
                    .build();
                }
            });
        }

        String[] localVarAuthNames = new String[] {  };
        return apiClient.buildCall(localVarPath, "GET", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }
    
    @SuppressWarnings("rawtypes")
    private com.squareup.okhttp.Call serverServerIdFirewallRuleGetValidateBeforeCall(UUID serverId, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        
        // verify the required parameter 'serverId' is set
        if (serverId == null) {
            throw new ApiException("Missing the required parameter 'serverId' when calling serverServerIdFirewallRuleGet(Async)");
        }
        
        
        com.squareup.okhttp.Call call = serverServerIdFirewallRuleGetCall(serverId, progressListener, progressRequestListener);
        return call;

        
        
        
        
    }

    /**
     * List firewall rules
     * Returns a list of firewall rules for a specific server.
     * @param serverId Server id (required)
     * @return FirewallRuleListResponse
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public FirewallRuleListResponse serverServerIdFirewallRuleGet(UUID serverId) throws ApiException {
        ApiResponse<FirewallRuleListResponse> resp = serverServerIdFirewallRuleGetWithHttpInfo(serverId);
        return resp.getData();
    }

    /**
     * List firewall rules
     * Returns a list of firewall rules for a specific server.
     * @param serverId Server id (required)
     * @return ApiResponse&lt;FirewallRuleListResponse&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<FirewallRuleListResponse> serverServerIdFirewallRuleGetWithHttpInfo(UUID serverId) throws ApiException {
        com.squareup.okhttp.Call call = serverServerIdFirewallRuleGetValidateBeforeCall(serverId, null, null);
        Type localVarReturnType = new TypeToken<FirewallRuleListResponse>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * List firewall rules (asynchronously)
     * Returns a list of firewall rules for a specific server.
     * @param serverId Server id (required)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call serverServerIdFirewallRuleGetAsync(UUID serverId, final ApiCallback<FirewallRuleListResponse> callback) throws ApiException {

        ProgressResponseBody.ProgressListener progressListener = null;
        ProgressRequestBody.ProgressRequestListener progressRequestListener = null;

        if (callback != null) {
            progressListener = new ProgressResponseBody.ProgressListener() {
                @Override
                public void update(long bytesRead, long contentLength, boolean done) {
                    callback.onDownloadProgress(bytesRead, contentLength, done);
                }
            };

            progressRequestListener = new ProgressRequestBody.ProgressRequestListener() {
                @Override
                public void onRequestProgress(long bytesWritten, long contentLength, boolean done) {
                    callback.onUploadProgress(bytesWritten, contentLength, done);
                }
            };
        }

        com.squareup.okhttp.Call call = serverServerIdFirewallRuleGetValidateBeforeCall(serverId, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<FirewallRuleListResponse>(){}.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
}
