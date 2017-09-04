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


import io.swagger.client.model.ConfigurationListResponse;
import io.swagger.client.model.Error;
import io.swagger.client.model.FirewallRule;
import io.swagger.client.model.FirewallRuleDetailsResponse;
import io.swagger.client.model.FirewallRuleListResponse;
import io.swagger.client.model.RestartServer;
import io.swagger.client.model.Server;
import io.swagger.client.model.ServerListResponse;
import io.swagger.client.model.StopServer;
import io.swagger.client.model.StorageDevice;
import io.swagger.client.model.StorageDevice1;
import java.util.UUID;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ServerApi {
    private ApiClient apiClient;

    public ServerApi() {
        this(Configuration.getDefaultApiClient());
    }

    public ServerApi(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    public ApiClient getApiClient() {
        return apiClient;
    }

    public void setApiClient(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    /**
     * Build call for assignTag
     * @param serverId Server id (required)
     * @param tagList List of tags (required)
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    public com.squareup.okhttp.Call assignTagCall(UUID serverId, String tagList, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;
        
        // create path and map variables
        String localVarPath = "/server/{serverId}/tag/{tagList}"
            .replaceAll("\\{" + "serverId" + "\\}", apiClient.escapeString(serverId.toString()))
            .replaceAll("\\{" + "tagList" + "\\}", apiClient.escapeString(tagList.toString()));

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
    private com.squareup.okhttp.Call assignTagValidateBeforeCall(UUID serverId, String tagList, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        
        // verify the required parameter 'serverId' is set
        if (serverId == null) {
            throw new ApiException("Missing the required parameter 'serverId' when calling assignTag(Async)");
        }
        
        // verify the required parameter 'tagList' is set
        if (tagList == null) {
            throw new ApiException("Missing the required parameter 'tagList' when calling assignTag(Async)");
        }
        
        
        com.squareup.okhttp.Call call = assignTagCall(serverId, tagList, progressListener, progressRequestListener);
        return call;

        
        
        
        
    }

    /**
     * Assign tag to a server
     * Servers can be tagged with one or more tags. The tags used must exist
     * @param serverId Server id (required)
     * @param tagList List of tags (required)
     * @return ServerListResponse
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ServerListResponse assignTag(UUID serverId, String tagList) throws ApiException {
        ApiResponse<ServerListResponse> resp = assignTagWithHttpInfo(serverId, tagList);
        return resp.getData();
    }

    /**
     * Assign tag to a server
     * Servers can be tagged with one or more tags. The tags used must exist
     * @param serverId Server id (required)
     * @param tagList List of tags (required)
     * @return ApiResponse&lt;ServerListResponse&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<ServerListResponse> assignTagWithHttpInfo(UUID serverId, String tagList) throws ApiException {
        com.squareup.okhttp.Call call = assignTagValidateBeforeCall(serverId, tagList, null, null);
        Type localVarReturnType = new TypeToken<ServerListResponse>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * Assign tag to a server (asynchronously)
     * Servers can be tagged with one or more tags. The tags used must exist
     * @param serverId Server id (required)
     * @param tagList List of tags (required)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call assignTagAsync(UUID serverId, String tagList, final ApiCallback<ServerListResponse> callback) throws ApiException {

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

        com.squareup.okhttp.Call call = assignTagValidateBeforeCall(serverId, tagList, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<ServerListResponse>(){}.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /**
     * Build call for attachStorage
     * @param serverId Server id (required)
     * @param storageDevice  (required)
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    public com.squareup.okhttp.Call attachStorageCall(UUID serverId, StorageDevice storageDevice, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = storageDevice;
        
        // create path and map variables
        String localVarPath = "/server/{serverId}/storage/attach"
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
    private com.squareup.okhttp.Call attachStorageValidateBeforeCall(UUID serverId, StorageDevice storageDevice, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        
        // verify the required parameter 'serverId' is set
        if (serverId == null) {
            throw new ApiException("Missing the required parameter 'serverId' when calling attachStorage(Async)");
        }
        
        // verify the required parameter 'storageDevice' is set
        if (storageDevice == null) {
            throw new ApiException("Missing the required parameter 'storageDevice' when calling attachStorage(Async)");
        }
        
        
        com.squareup.okhttp.Call call = attachStorageCall(serverId, storageDevice, progressListener, progressRequestListener);
        return call;

        
        
        
        
    }

    /**
     * Attach storage
     * Attaches a storage as a device to a server.
     * @param serverId Server id (required)
     * @param storageDevice  (required)
     * @return ServerListResponse
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ServerListResponse attachStorage(UUID serverId, StorageDevice storageDevice) throws ApiException {
        ApiResponse<ServerListResponse> resp = attachStorageWithHttpInfo(serverId, storageDevice);
        return resp.getData();
    }

    /**
     * Attach storage
     * Attaches a storage as a device to a server.
     * @param serverId Server id (required)
     * @param storageDevice  (required)
     * @return ApiResponse&lt;ServerListResponse&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<ServerListResponse> attachStorageWithHttpInfo(UUID serverId, StorageDevice storageDevice) throws ApiException {
        com.squareup.okhttp.Call call = attachStorageValidateBeforeCall(serverId, storageDevice, null, null);
        Type localVarReturnType = new TypeToken<ServerListResponse>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * Attach storage (asynchronously)
     * Attaches a storage as a device to a server.
     * @param serverId Server id (required)
     * @param storageDevice  (required)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call attachStorageAsync(UUID serverId, StorageDevice storageDevice, final ApiCallback<ServerListResponse> callback) throws ApiException {

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

        com.squareup.okhttp.Call call = attachStorageValidateBeforeCall(serverId, storageDevice, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<ServerListResponse>(){}.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
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
     * Build call for createServer
     * @param server  (optional)
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    public com.squareup.okhttp.Call createServerCall(Server server, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = server;
        
        // create path and map variables
        String localVarPath = "/server";

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();

        Map<String, String> localVarHeaderParams = new HashMap<String, String>();

        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        final String[] localVarAccepts = {
            "application/json"
        };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) localVarHeaderParams.put("Accept", localVarAccept);

        final String[] localVarContentTypes = {
            "application/json"
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
    private com.squareup.okhttp.Call createServerValidateBeforeCall(Server server, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        
        
        com.squareup.okhttp.Call call = createServerCall(server, progressListener, progressRequestListener);
        return call;

        
        
        
        
    }

    /**
     * Create server
     * Creates a new server instance.
     * @param server  (optional)
     * @return ServerListResponse
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ServerListResponse createServer(Server server) throws ApiException {
        ApiResponse<ServerListResponse> resp = createServerWithHttpInfo(server);
        return resp.getData();
    }

    /**
     * Create server
     * Creates a new server instance.
     * @param server  (optional)
     * @return ApiResponse&lt;ServerListResponse&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<ServerListResponse> createServerWithHttpInfo(Server server) throws ApiException {
        com.squareup.okhttp.Call call = createServerValidateBeforeCall(server, null, null);
        Type localVarReturnType = new TypeToken<ServerListResponse>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * Create server (asynchronously)
     * Creates a new server instance.
     * @param server  (optional)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call createServerAsync(Server server, final ApiCallback<ServerListResponse> callback) throws ApiException {

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

        com.squareup.okhttp.Call call = createServerValidateBeforeCall(server, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<ServerListResponse>(){}.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
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
     * Build call for deleteServer
     * @param serverId Id of server to delete (required)
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    public com.squareup.okhttp.Call deleteServerCall(UUID serverId, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;
        
        // create path and map variables
        String localVarPath = "/server/{serverId}"
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
        return apiClient.buildCall(localVarPath, "DELETE", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }
    
    @SuppressWarnings("rawtypes")
    private com.squareup.okhttp.Call deleteServerValidateBeforeCall(UUID serverId, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        
        // verify the required parameter 'serverId' is set
        if (serverId == null) {
            throw new ApiException("Missing the required parameter 'serverId' when calling deleteServer(Async)");
        }
        
        
        com.squareup.okhttp.Call call = deleteServerCall(serverId, progressListener, progressRequestListener);
        return call;

        
        
        
        
    }

    /**
     * Delete server
     * 
     * @param serverId Id of server to delete (required)
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public void deleteServer(UUID serverId) throws ApiException {
        deleteServerWithHttpInfo(serverId);
    }

    /**
     * Delete server
     * 
     * @param serverId Id of server to delete (required)
     * @return ApiResponse&lt;Void&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<Void> deleteServerWithHttpInfo(UUID serverId) throws ApiException {
        com.squareup.okhttp.Call call = deleteServerValidateBeforeCall(serverId, null, null);
        return apiClient.execute(call);
    }

    /**
     * Delete server (asynchronously)
     * 
     * @param serverId Id of server to delete (required)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call deleteServerAsync(UUID serverId, final ApiCallback<Void> callback) throws ApiException {

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

        com.squareup.okhttp.Call call = deleteServerValidateBeforeCall(serverId, progressListener, progressRequestListener);
        apiClient.executeAsync(call, callback);
        return call;
    }
    /**
     * Build call for detachStorage
     * @param serverId Server id (required)
     * @param storageDevice  (required)
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    public com.squareup.okhttp.Call detachStorageCall(UUID serverId, StorageDevice storageDevice, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = storageDevice;
        
        // create path and map variables
        String localVarPath = "/server/{serverId}/storage/detach"
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
    private com.squareup.okhttp.Call detachStorageValidateBeforeCall(UUID serverId, StorageDevice storageDevice, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        
        // verify the required parameter 'serverId' is set
        if (serverId == null) {
            throw new ApiException("Missing the required parameter 'serverId' when calling detachStorage(Async)");
        }
        
        // verify the required parameter 'storageDevice' is set
        if (storageDevice == null) {
            throw new ApiException("Missing the required parameter 'storageDevice' when calling detachStorage(Async)");
        }
        
        
        com.squareup.okhttp.Call call = detachStorageCall(serverId, storageDevice, progressListener, progressRequestListener);
        return call;

        
        
        
        
    }

    /**
     * Detach storage
     * Detaches a storage resource from a server.
     * @param serverId Server id (required)
     * @param storageDevice  (required)
     * @return ServerListResponse
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ServerListResponse detachStorage(UUID serverId, StorageDevice storageDevice) throws ApiException {
        ApiResponse<ServerListResponse> resp = detachStorageWithHttpInfo(serverId, storageDevice);
        return resp.getData();
    }

    /**
     * Detach storage
     * Detaches a storage resource from a server.
     * @param serverId Server id (required)
     * @param storageDevice  (required)
     * @return ApiResponse&lt;ServerListResponse&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<ServerListResponse> detachStorageWithHttpInfo(UUID serverId, StorageDevice storageDevice) throws ApiException {
        com.squareup.okhttp.Call call = detachStorageValidateBeforeCall(serverId, storageDevice, null, null);
        Type localVarReturnType = new TypeToken<ServerListResponse>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * Detach storage (asynchronously)
     * Detaches a storage resource from a server.
     * @param serverId Server id (required)
     * @param storageDevice  (required)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call detachStorageAsync(UUID serverId, StorageDevice storageDevice, final ApiCallback<ServerListResponse> callback) throws ApiException {

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

        com.squareup.okhttp.Call call = detachStorageValidateBeforeCall(serverId, storageDevice, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<ServerListResponse>(){}.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /**
     * Build call for ejectCdrom
     * @param serverId Server id (required)
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    public com.squareup.okhttp.Call ejectCdromCall(UUID serverId, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;
        
        // create path and map variables
        String localVarPath = "/server/{serverId}/storage/cdrom/eject"
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
    private com.squareup.okhttp.Call ejectCdromValidateBeforeCall(UUID serverId, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        
        // verify the required parameter 'serverId' is set
        if (serverId == null) {
            throw new ApiException("Missing the required parameter 'serverId' when calling ejectCdrom(Async)");
        }
        
        
        com.squareup.okhttp.Call call = ejectCdromCall(serverId, progressListener, progressRequestListener);
        return call;

        
        
        
        
    }

    /**
     * Eject CD-ROM
     * Ejects the storage from the CD-ROM device of a server.
     * @param serverId Server id (required)
     * @return ServerListResponse
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ServerListResponse ejectCdrom(UUID serverId) throws ApiException {
        ApiResponse<ServerListResponse> resp = ejectCdromWithHttpInfo(serverId);
        return resp.getData();
    }

    /**
     * Eject CD-ROM
     * Ejects the storage from the CD-ROM device of a server.
     * @param serverId Server id (required)
     * @return ApiResponse&lt;ServerListResponse&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<ServerListResponse> ejectCdromWithHttpInfo(UUID serverId) throws ApiException {
        com.squareup.okhttp.Call call = ejectCdromValidateBeforeCall(serverId, null, null);
        Type localVarReturnType = new TypeToken<ServerListResponse>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * Eject CD-ROM (asynchronously)
     * Ejects the storage from the CD-ROM device of a server.
     * @param serverId Server id (required)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call ejectCdromAsync(UUID serverId, final ApiCallback<ServerListResponse> callback) throws ApiException {

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

        com.squareup.okhttp.Call call = ejectCdromValidateBeforeCall(serverId, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<ServerListResponse>(){}.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
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
     * Build call for listServerConfigurations
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    public com.squareup.okhttp.Call listServerConfigurationsCall(final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;
        
        // create path and map variables
        String localVarPath = "/server_size";

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();

        Map<String, String> localVarHeaderParams = new HashMap<String, String>();

        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        final String[] localVarAccepts = {
            "application/json"
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
    private com.squareup.okhttp.Call listServerConfigurationsValidateBeforeCall(final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        
        
        com.squareup.okhttp.Call call = listServerConfigurationsCall(progressListener, progressRequestListener);
        return call;

        
        
        
        
    }

    /**
     * List server configurations
     * Returns a list of available server configurations. A server configuration consists of a combination of CPU core count and main memory amount. All servers are created using these configurations.
     * @return ConfigurationListResponse
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ConfigurationListResponse listServerConfigurations() throws ApiException {
        ApiResponse<ConfigurationListResponse> resp = listServerConfigurationsWithHttpInfo();
        return resp.getData();
    }

    /**
     * List server configurations
     * Returns a list of available server configurations. A server configuration consists of a combination of CPU core count and main memory amount. All servers are created using these configurations.
     * @return ApiResponse&lt;ConfigurationListResponse&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<ConfigurationListResponse> listServerConfigurationsWithHttpInfo() throws ApiException {
        com.squareup.okhttp.Call call = listServerConfigurationsValidateBeforeCall(null, null);
        Type localVarReturnType = new TypeToken<ConfigurationListResponse>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * List server configurations (asynchronously)
     * Returns a list of available server configurations. A server configuration consists of a combination of CPU core count and main memory amount. All servers are created using these configurations.
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call listServerConfigurationsAsync(final ApiCallback<ConfigurationListResponse> callback) throws ApiException {

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

        com.squareup.okhttp.Call call = listServerConfigurationsValidateBeforeCall(progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<ConfigurationListResponse>(){}.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /**
     * Build call for listServers
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    public com.squareup.okhttp.Call listServersCall(final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;
        
        // create path and map variables
        String localVarPath = "/server";

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();

        Map<String, String> localVarHeaderParams = new HashMap<String, String>();

        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        final String[] localVarAccepts = {
            "application/json"
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
    private com.squareup.okhttp.Call listServersValidateBeforeCall(final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        
        
        com.squareup.okhttp.Call call = listServersCall(progressListener, progressRequestListener);
        return call;

        
        
        
        
    }

    /**
     * List of servers
     * Returns a list of all servers associated with the current account.
     * @return ServerListResponse
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ServerListResponse listServers() throws ApiException {
        ApiResponse<ServerListResponse> resp = listServersWithHttpInfo();
        return resp.getData();
    }

    /**
     * List of servers
     * Returns a list of all servers associated with the current account.
     * @return ApiResponse&lt;ServerListResponse&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<ServerListResponse> listServersWithHttpInfo() throws ApiException {
        com.squareup.okhttp.Call call = listServersValidateBeforeCall(null, null);
        Type localVarReturnType = new TypeToken<ServerListResponse>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * List of servers (asynchronously)
     * Returns a list of all servers associated with the current account.
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call listServersAsync(final ApiCallback<ServerListResponse> callback) throws ApiException {

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

        com.squareup.okhttp.Call call = listServersValidateBeforeCall(progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<ServerListResponse>(){}.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /**
     * Build call for loadCdrom
     * @param serverId Server id (required)
     * @param storageDevice  (optional)
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    public com.squareup.okhttp.Call loadCdromCall(UUID serverId, StorageDevice1 storageDevice, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = storageDevice;
        
        // create path and map variables
        String localVarPath = "/server/{serverId}/storage/cdrom/load"
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
    private com.squareup.okhttp.Call loadCdromValidateBeforeCall(UUID serverId, StorageDevice1 storageDevice, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        
        // verify the required parameter 'serverId' is set
        if (serverId == null) {
            throw new ApiException("Missing the required parameter 'serverId' when calling loadCdrom(Async)");
        }
        
        
        com.squareup.okhttp.Call call = loadCdromCall(serverId, storageDevice, progressListener, progressRequestListener);
        return call;

        
        
        
        
    }

    /**
     * Load CD-ROM
     * Loads a storage as a CD-ROM in the CD-ROM device of a server.
     * @param serverId Server id (required)
     * @param storageDevice  (optional)
     * @return ServerListResponse
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ServerListResponse loadCdrom(UUID serverId, StorageDevice1 storageDevice) throws ApiException {
        ApiResponse<ServerListResponse> resp = loadCdromWithHttpInfo(serverId, storageDevice);
        return resp.getData();
    }

    /**
     * Load CD-ROM
     * Loads a storage as a CD-ROM in the CD-ROM device of a server.
     * @param serverId Server id (required)
     * @param storageDevice  (optional)
     * @return ApiResponse&lt;ServerListResponse&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<ServerListResponse> loadCdromWithHttpInfo(UUID serverId, StorageDevice1 storageDevice) throws ApiException {
        com.squareup.okhttp.Call call = loadCdromValidateBeforeCall(serverId, storageDevice, null, null);
        Type localVarReturnType = new TypeToken<ServerListResponse>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * Load CD-ROM (asynchronously)
     * Loads a storage as a CD-ROM in the CD-ROM device of a server.
     * @param serverId Server id (required)
     * @param storageDevice  (optional)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call loadCdromAsync(UUID serverId, StorageDevice1 storageDevice, final ApiCallback<ServerListResponse> callback) throws ApiException {

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

        com.squareup.okhttp.Call call = loadCdromValidateBeforeCall(serverId, storageDevice, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<ServerListResponse>(){}.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /**
     * Build call for modifyServer
     * @param serverId Id of server to modify (required)
     * @param server  (optional)
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    public com.squareup.okhttp.Call modifyServerCall(UUID serverId, Server server, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = server;
        
        // create path and map variables
        String localVarPath = "/server/{serverId}"
            .replaceAll("\\{" + "serverId" + "\\}", apiClient.escapeString(serverId.toString()));

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();

        Map<String, String> localVarHeaderParams = new HashMap<String, String>();

        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        final String[] localVarAccepts = {
            "application/json"
        };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) localVarHeaderParams.put("Accept", localVarAccept);

        final String[] localVarContentTypes = {
            "application/json"
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
        return apiClient.buildCall(localVarPath, "PUT", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }
    
    @SuppressWarnings("rawtypes")
    private com.squareup.okhttp.Call modifyServerValidateBeforeCall(UUID serverId, Server server, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        
        // verify the required parameter 'serverId' is set
        if (serverId == null) {
            throw new ApiException("Missing the required parameter 'serverId' when calling modifyServer(Async)");
        }
        
        
        com.squareup.okhttp.Call call = modifyServerCall(serverId, server, progressListener, progressRequestListener);
        return call;

        
        
        
        
    }

    /**
     * Modify server
     * 
     * @param serverId Id of server to modify (required)
     * @param server  (optional)
     * @return ServerListResponse
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ServerListResponse modifyServer(UUID serverId, Server server) throws ApiException {
        ApiResponse<ServerListResponse> resp = modifyServerWithHttpInfo(serverId, server);
        return resp.getData();
    }

    /**
     * Modify server
     * 
     * @param serverId Id of server to modify (required)
     * @param server  (optional)
     * @return ApiResponse&lt;ServerListResponse&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<ServerListResponse> modifyServerWithHttpInfo(UUID serverId, Server server) throws ApiException {
        com.squareup.okhttp.Call call = modifyServerValidateBeforeCall(serverId, server, null, null);
        Type localVarReturnType = new TypeToken<ServerListResponse>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * Modify server (asynchronously)
     * 
     * @param serverId Id of server to modify (required)
     * @param server  (optional)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call modifyServerAsync(UUID serverId, Server server, final ApiCallback<ServerListResponse> callback) throws ApiException {

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

        com.squareup.okhttp.Call call = modifyServerValidateBeforeCall(serverId, server, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<ServerListResponse>(){}.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /**
     * Build call for restartServer
     * @param serverId Id of server to restart (required)
     * @param restartServer  (required)
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    public com.squareup.okhttp.Call restartServerCall(UUID serverId, RestartServer restartServer, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = restartServer;
        
        // create path and map variables
        String localVarPath = "/server/{serverId}/restart"
            .replaceAll("\\{" + "serverId" + "\\}", apiClient.escapeString(serverId.toString()));

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();

        Map<String, String> localVarHeaderParams = new HashMap<String, String>();

        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        final String[] localVarAccepts = {
            "application/json"
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
    private com.squareup.okhttp.Call restartServerValidateBeforeCall(UUID serverId, RestartServer restartServer, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        
        // verify the required parameter 'serverId' is set
        if (serverId == null) {
            throw new ApiException("Missing the required parameter 'serverId' when calling restartServer(Async)");
        }
        
        // verify the required parameter 'restartServer' is set
        if (restartServer == null) {
            throw new ApiException("Missing the required parameter 'restartServer' when calling restartServer(Async)");
        }
        
        
        com.squareup.okhttp.Call call = restartServerCall(serverId, restartServer, progressListener, progressRequestListener);
        return call;

        
        
        
        
    }

    /**
     * Restart server
     * Stops and starts a server. The server state must be &#x60;started&#x60;.
     * @param serverId Id of server to restart (required)
     * @param restartServer  (required)
     * @return ServerListResponse
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ServerListResponse restartServer(UUID serverId, RestartServer restartServer) throws ApiException {
        ApiResponse<ServerListResponse> resp = restartServerWithHttpInfo(serverId, restartServer);
        return resp.getData();
    }

    /**
     * Restart server
     * Stops and starts a server. The server state must be &#x60;started&#x60;.
     * @param serverId Id of server to restart (required)
     * @param restartServer  (required)
     * @return ApiResponse&lt;ServerListResponse&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<ServerListResponse> restartServerWithHttpInfo(UUID serverId, RestartServer restartServer) throws ApiException {
        com.squareup.okhttp.Call call = restartServerValidateBeforeCall(serverId, restartServer, null, null);
        Type localVarReturnType = new TypeToken<ServerListResponse>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * Restart server (asynchronously)
     * Stops and starts a server. The server state must be &#x60;started&#x60;.
     * @param serverId Id of server to restart (required)
     * @param restartServer  (required)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call restartServerAsync(UUID serverId, RestartServer restartServer, final ApiCallback<ServerListResponse> callback) throws ApiException {

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

        com.squareup.okhttp.Call call = restartServerValidateBeforeCall(serverId, restartServer, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<ServerListResponse>(){}.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /**
     * Build call for serverDetails
     * @param serverId Id of server to return (required)
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    public com.squareup.okhttp.Call serverDetailsCall(UUID serverId, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;
        
        // create path and map variables
        String localVarPath = "/server/{serverId}"
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
    private com.squareup.okhttp.Call serverDetailsValidateBeforeCall(UUID serverId, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        
        // verify the required parameter 'serverId' is set
        if (serverId == null) {
            throw new ApiException("Missing the required parameter 'serverId' when calling serverDetails(Async)");
        }
        
        
        com.squareup.okhttp.Call call = serverDetailsCall(serverId, progressListener, progressRequestListener);
        return call;

        
        
        
        
    }

    /**
     * Get server details
     * Returns detailed information about a specific server.
     * @param serverId Id of server to return (required)
     * @return ServerListResponse
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ServerListResponse serverDetails(UUID serverId) throws ApiException {
        ApiResponse<ServerListResponse> resp = serverDetailsWithHttpInfo(serverId);
        return resp.getData();
    }

    /**
     * Get server details
     * Returns detailed information about a specific server.
     * @param serverId Id of server to return (required)
     * @return ApiResponse&lt;ServerListResponse&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<ServerListResponse> serverDetailsWithHttpInfo(UUID serverId) throws ApiException {
        com.squareup.okhttp.Call call = serverDetailsValidateBeforeCall(serverId, null, null);
        Type localVarReturnType = new TypeToken<ServerListResponse>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * Get server details (asynchronously)
     * Returns detailed information about a specific server.
     * @param serverId Id of server to return (required)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call serverDetailsAsync(UUID serverId, final ApiCallback<ServerListResponse> callback) throws ApiException {

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

        com.squareup.okhttp.Call call = serverDetailsValidateBeforeCall(serverId, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<ServerListResponse>(){}.getType();
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
    /**
     * Build call for startServer
     * @param serverId Id of server to start (required)
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    public com.squareup.okhttp.Call startServerCall(UUID serverId, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;
        
        // create path and map variables
        String localVarPath = "/server/{serverId}/start"
            .replaceAll("\\{" + "serverId" + "\\}", apiClient.escapeString(serverId.toString()));

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();

        Map<String, String> localVarHeaderParams = new HashMap<String, String>();

        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        final String[] localVarAccepts = {
            "application/json"
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
    private com.squareup.okhttp.Call startServerValidateBeforeCall(UUID serverId, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        
        // verify the required parameter 'serverId' is set
        if (serverId == null) {
            throw new ApiException("Missing the required parameter 'serverId' when calling startServer(Async)");
        }
        
        
        com.squareup.okhttp.Call call = startServerCall(serverId, progressListener, progressRequestListener);
        return call;

        
        
        
        
    }

    /**
     * Start server
     * Starts a stopped server. The server state must be &#x60;stopped&#x60;.
     * @param serverId Id of server to start (required)
     * @return ServerListResponse
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ServerListResponse startServer(UUID serverId) throws ApiException {
        ApiResponse<ServerListResponse> resp = startServerWithHttpInfo(serverId);
        return resp.getData();
    }

    /**
     * Start server
     * Starts a stopped server. The server state must be &#x60;stopped&#x60;.
     * @param serverId Id of server to start (required)
     * @return ApiResponse&lt;ServerListResponse&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<ServerListResponse> startServerWithHttpInfo(UUID serverId) throws ApiException {
        com.squareup.okhttp.Call call = startServerValidateBeforeCall(serverId, null, null);
        Type localVarReturnType = new TypeToken<ServerListResponse>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * Start server (asynchronously)
     * Starts a stopped server. The server state must be &#x60;stopped&#x60;.
     * @param serverId Id of server to start (required)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call startServerAsync(UUID serverId, final ApiCallback<ServerListResponse> callback) throws ApiException {

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

        com.squareup.okhttp.Call call = startServerValidateBeforeCall(serverId, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<ServerListResponse>(){}.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /**
     * Build call for stopServer
     * @param serverId Id of server to stop (required)
     * @param stopServer  (required)
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    public com.squareup.okhttp.Call stopServerCall(UUID serverId, StopServer stopServer, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = stopServer;
        
        // create path and map variables
        String localVarPath = "/server/{serverId}/stop"
            .replaceAll("\\{" + "serverId" + "\\}", apiClient.escapeString(serverId.toString()));

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();

        Map<String, String> localVarHeaderParams = new HashMap<String, String>();

        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        final String[] localVarAccepts = {
            "application/json"
        };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) localVarHeaderParams.put("Accept", localVarAccept);

        final String[] localVarContentTypes = {
            "application/json"
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
    private com.squareup.okhttp.Call stopServerValidateBeforeCall(UUID serverId, StopServer stopServer, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        
        // verify the required parameter 'serverId' is set
        if (serverId == null) {
            throw new ApiException("Missing the required parameter 'serverId' when calling stopServer(Async)");
        }
        
        // verify the required parameter 'stopServer' is set
        if (stopServer == null) {
            throw new ApiException("Missing the required parameter 'stopServer' when calling stopServer(Async)");
        }
        
        
        com.squareup.okhttp.Call call = stopServerCall(serverId, stopServer, progressListener, progressRequestListener);
        return call;

        
        
        
        
    }

    /**
     * Stop server
     * Stops a started server. The server state must be &#x60;started&#x60;.
     * @param serverId Id of server to stop (required)
     * @param stopServer  (required)
     * @return ServerListResponse
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ServerListResponse stopServer(UUID serverId, StopServer stopServer) throws ApiException {
        ApiResponse<ServerListResponse> resp = stopServerWithHttpInfo(serverId, stopServer);
        return resp.getData();
    }

    /**
     * Stop server
     * Stops a started server. The server state must be &#x60;started&#x60;.
     * @param serverId Id of server to stop (required)
     * @param stopServer  (required)
     * @return ApiResponse&lt;ServerListResponse&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<ServerListResponse> stopServerWithHttpInfo(UUID serverId, StopServer stopServer) throws ApiException {
        com.squareup.okhttp.Call call = stopServerValidateBeforeCall(serverId, stopServer, null, null);
        Type localVarReturnType = new TypeToken<ServerListResponse>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * Stop server (asynchronously)
     * Stops a started server. The server state must be &#x60;started&#x60;.
     * @param serverId Id of server to stop (required)
     * @param stopServer  (required)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call stopServerAsync(UUID serverId, StopServer stopServer, final ApiCallback<ServerListResponse> callback) throws ApiException {

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

        com.squareup.okhttp.Call call = stopServerValidateBeforeCall(serverId, stopServer, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<ServerListResponse>(){}.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /**
     * Build call for untag
     * @param serverId Server id (required)
     * @param tagName Tag name (required)
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    public com.squareup.okhttp.Call untagCall(UUID serverId, String tagName, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;
        
        // create path and map variables
        String localVarPath = "/server/{serverId}/untag/{tagName}"
            .replaceAll("\\{" + "serverId" + "\\}", apiClient.escapeString(serverId.toString()))
            .replaceAll("\\{" + "tagName" + "\\}", apiClient.escapeString(tagName.toString()));

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
    private com.squareup.okhttp.Call untagValidateBeforeCall(UUID serverId, String tagName, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        
        // verify the required parameter 'serverId' is set
        if (serverId == null) {
            throw new ApiException("Missing the required parameter 'serverId' when calling untag(Async)");
        }
        
        // verify the required parameter 'tagName' is set
        if (tagName == null) {
            throw new ApiException("Missing the required parameter 'tagName' when calling untag(Async)");
        }
        
        
        com.squareup.okhttp.Call call = untagCall(serverId, tagName, progressListener, progressRequestListener);
        return call;

        
        
        
        
    }

    /**
     * Remove tag from server
     * Untags tags from given server. The tag(s) must exist
     * @param serverId Server id (required)
     * @param tagName Tag name (required)
     * @return ServerListResponse
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ServerListResponse untag(UUID serverId, String tagName) throws ApiException {
        ApiResponse<ServerListResponse> resp = untagWithHttpInfo(serverId, tagName);
        return resp.getData();
    }

    /**
     * Remove tag from server
     * Untags tags from given server. The tag(s) must exist
     * @param serverId Server id (required)
     * @param tagName Tag name (required)
     * @return ApiResponse&lt;ServerListResponse&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<ServerListResponse> untagWithHttpInfo(UUID serverId, String tagName) throws ApiException {
        com.squareup.okhttp.Call call = untagValidateBeforeCall(serverId, tagName, null, null);
        Type localVarReturnType = new TypeToken<ServerListResponse>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * Remove tag from server (asynchronously)
     * Untags tags from given server. The tag(s) must exist
     * @param serverId Server id (required)
     * @param tagName Tag name (required)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call untagAsync(UUID serverId, String tagName, final ApiCallback<ServerListResponse> callback) throws ApiException {

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

        com.squareup.okhttp.Call call = untagValidateBeforeCall(serverId, tagName, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<ServerListResponse>(){}.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
}
