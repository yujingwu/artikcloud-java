package cloud.artik.api;

import cloud.artik.client.ApiCallback;
import cloud.artik.client.ApiClient;
import cloud.artik.client.ApiException;
import cloud.artik.client.ApiResponse;
import cloud.artik.client.Configuration;
import cloud.artik.client.Pair;
import cloud.artik.client.ProgressRequestBody;
import cloud.artik.client.ProgressResponseBody;

import com.google.gson.reflect.TypeToken;

import com.squareup.okhttp.Call;
import com.squareup.okhttp.Interceptor;
import com.squareup.okhttp.Response;

import java.io.IOException;

import cloud.artik.model.DeviceRegConfirmUserRequest;
import cloud.artik.model.DeviceRegConfirmUserResponseEnvelope;
import cloud.artik.model.DeviceRegStatusResponseEnvelope;
import cloud.artik.model.UnregisterDeviceResponseEnvelope;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RegistrationsApi {
  private ApiClient apiClient;

  public RegistrationsApi() {
    this(Configuration.getDefaultApiClient());
  }

  public RegistrationsApi(ApiClient apiClient) {
    this.apiClient = apiClient;
  }

  public ApiClient getApiClient() {
    return apiClient;
  }

  public void setApiClient(ApiClient apiClient) {
    this.apiClient = apiClient;
  }

  
  /* Build call for confirmUser */
  private Call confirmUserCall(DeviceRegConfirmUserRequest registrationInfo, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
    Object localVarPostBody = registrationInfo;
    
    // verify the required parameter 'registrationInfo' is set
    if (registrationInfo == null) {
       throw new ApiException("Missing the required parameter 'registrationInfo' when calling confirmUser(Async)");
    }
    

    // create path and map variables
    String localVarPath = "/devices/registrations/pin".replaceAll("\\{format\\}","json");

    List<Pair> localVarQueryParams = new ArrayList<Pair>();

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
      apiClient.getHttpClient().networkInterceptors().add(new Interceptor() {
      @Override
      public Response intercept(Interceptor.Chain chain) throws IOException {
        Response originalResponse = chain.proceed(chain.request());
        return originalResponse.newBuilder()
                .body(new ProgressResponseBody(originalResponse.body(), progressListener))
                .build();
        }
      });
    }

    String[] localVarAuthNames = new String[] { "artikcloud_oauth" };
    return apiClient.buildCall(localVarPath, "PUT", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
  }

  /**
   * Confirm User
   * This call updates the registration request issued earlier by associating it with an authenticated user and captures all additional information required to add a new device.
   * @param registrationInfo Device Registration information.
   * @return DeviceRegConfirmUserResponseEnvelope
   * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
   */
  public DeviceRegConfirmUserResponseEnvelope confirmUser(DeviceRegConfirmUserRequest registrationInfo) throws ApiException {
    ApiResponse<DeviceRegConfirmUserResponseEnvelope> resp = confirmUserWithHttpInfo(registrationInfo);
    return resp.getData();
  }

  /**
   * Confirm User
   * This call updates the registration request issued earlier by associating it with an authenticated user and captures all additional information required to add a new device.
   * @param registrationInfo Device Registration information.
   * @return ApiResponse<DeviceRegConfirmUserResponseEnvelope>
   * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
   */
  public ApiResponse<DeviceRegConfirmUserResponseEnvelope> confirmUserWithHttpInfo(DeviceRegConfirmUserRequest registrationInfo) throws ApiException {
    Call call = confirmUserCall(registrationInfo, null, null);
    Type localVarReturnType = new TypeToken<DeviceRegConfirmUserResponseEnvelope>(){}.getType();
    return apiClient.execute(call, localVarReturnType);
  }

  /**
   * Confirm User (asynchronously)
   * This call updates the registration request issued earlier by associating it with an authenticated user and captures all additional information required to add a new device.
   * @param registrationInfo Device Registration information.
   * @param callback The callback to be executed when the API call finishes
   * @return The request call
   * @throws ApiException If fail to process the API call, e.g. serializing the request body object
   */
  public Call confirmUserAsync(DeviceRegConfirmUserRequest registrationInfo, final ApiCallback<DeviceRegConfirmUserResponseEnvelope> callback) throws ApiException {

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

    Call call = confirmUserCall(registrationInfo, progressListener, progressRequestListener);
    Type localVarReturnType = new TypeToken<DeviceRegConfirmUserResponseEnvelope>(){}.getType();
    apiClient.executeAsync(call, localVarReturnType, callback);
    return call;
  }
  
  /* Build call for getRequestStatusForUser */
  private Call getRequestStatusForUserCall(String requestId, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
    Object localVarPostBody = null;
    
    // verify the required parameter 'requestId' is set
    if (requestId == null) {
       throw new ApiException("Missing the required parameter 'requestId' when calling getRequestStatusForUser(Async)");
    }
    

    // create path and map variables
    String localVarPath = "/devices/registrations/{requestId}/status".replaceAll("\\{format\\}","json")
      .replaceAll("\\{" + "requestId" + "\\}", apiClient.escapeString(requestId.toString()));

    List<Pair> localVarQueryParams = new ArrayList<Pair>();

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
      apiClient.getHttpClient().networkInterceptors().add(new Interceptor() {
      @Override
      public Response intercept(Interceptor.Chain chain) throws IOException {
        Response originalResponse = chain.proceed(chain.request());
        return originalResponse.newBuilder()
                .body(new ProgressResponseBody(originalResponse.body(), progressListener))
                .build();
        }
      });
    }

    String[] localVarAuthNames = new String[] { "artikcloud_oauth" };
    return apiClient.buildCall(localVarPath, "GET", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
  }

  /**
   * Get Request Status For User
   * This call checks the status of the request so users can poll and know when registration is complete.
   * @param requestId Request ID.
   * @return DeviceRegStatusResponseEnvelope
   * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
   */
  public DeviceRegStatusResponseEnvelope getRequestStatusForUser(String requestId) throws ApiException {
    ApiResponse<DeviceRegStatusResponseEnvelope> resp = getRequestStatusForUserWithHttpInfo(requestId);
    return resp.getData();
  }

  /**
   * Get Request Status For User
   * This call checks the status of the request so users can poll and know when registration is complete.
   * @param requestId Request ID.
   * @return ApiResponse<DeviceRegStatusResponseEnvelope>
   * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
   */
  public ApiResponse<DeviceRegStatusResponseEnvelope> getRequestStatusForUserWithHttpInfo(String requestId) throws ApiException {
    Call call = getRequestStatusForUserCall(requestId, null, null);
    Type localVarReturnType = new TypeToken<DeviceRegStatusResponseEnvelope>(){}.getType();
    return apiClient.execute(call, localVarReturnType);
  }

  /**
   * Get Request Status For User (asynchronously)
   * This call checks the status of the request so users can poll and know when registration is complete.
   * @param requestId Request ID.
   * @param callback The callback to be executed when the API call finishes
   * @return The request call
   * @throws ApiException If fail to process the API call, e.g. serializing the request body object
   */
  public Call getRequestStatusForUserAsync(String requestId, final ApiCallback<DeviceRegStatusResponseEnvelope> callback) throws ApiException {

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

    Call call = getRequestStatusForUserCall(requestId, progressListener, progressRequestListener);
    Type localVarReturnType = new TypeToken<DeviceRegStatusResponseEnvelope>(){}.getType();
    apiClient.executeAsync(call, localVarReturnType, callback);
    return call;
  }
  
  /* Build call for unregisterDevice */
  private Call unregisterDeviceCall(String deviceId, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
    Object localVarPostBody = null;
    
    // verify the required parameter 'deviceId' is set
    if (deviceId == null) {
       throw new ApiException("Missing the required parameter 'deviceId' when calling unregisterDevice(Async)");
    }
    

    // create path and map variables
    String localVarPath = "/devices/{deviceId}/registrations".replaceAll("\\{format\\}","json")
      .replaceAll("\\{" + "deviceId" + "\\}", apiClient.escapeString(deviceId.toString()));

    List<Pair> localVarQueryParams = new ArrayList<Pair>();

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
      apiClient.getHttpClient().networkInterceptors().add(new Interceptor() {
      @Override
      public Response intercept(Interceptor.Chain chain) throws IOException {
        Response originalResponse = chain.proceed(chain.request());
        return originalResponse.newBuilder()
                .body(new ProgressResponseBody(originalResponse.body(), progressListener))
                .build();
        }
      });
    }

    String[] localVarAuthNames = new String[] { "artikcloud_oauth" };
    return apiClient.buildCall(localVarPath, "DELETE", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
  }

  /**
   * Unregister Device
   * This call clears any associations from the secure device registration.
   * @param deviceId Device ID.
   * @return UnregisterDeviceResponseEnvelope
   * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
   */
  public UnregisterDeviceResponseEnvelope unregisterDevice(String deviceId) throws ApiException {
    ApiResponse<UnregisterDeviceResponseEnvelope> resp = unregisterDeviceWithHttpInfo(deviceId);
    return resp.getData();
  }

  /**
   * Unregister Device
   * This call clears any associations from the secure device registration.
   * @param deviceId Device ID.
   * @return ApiResponse<UnregisterDeviceResponseEnvelope>
   * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
   */
  public ApiResponse<UnregisterDeviceResponseEnvelope> unregisterDeviceWithHttpInfo(String deviceId) throws ApiException {
    Call call = unregisterDeviceCall(deviceId, null, null);
    Type localVarReturnType = new TypeToken<UnregisterDeviceResponseEnvelope>(){}.getType();
    return apiClient.execute(call, localVarReturnType);
  }

  /**
   * Unregister Device (asynchronously)
   * This call clears any associations from the secure device registration.
   * @param deviceId Device ID.
   * @param callback The callback to be executed when the API call finishes
   * @return The request call
   * @throws ApiException If fail to process the API call, e.g. serializing the request body object
   */
  public Call unregisterDeviceAsync(String deviceId, final ApiCallback<UnregisterDeviceResponseEnvelope> callback) throws ApiException {

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

    Call call = unregisterDeviceCall(deviceId, progressListener, progressRequestListener);
    Type localVarReturnType = new TypeToken<UnregisterDeviceResponseEnvelope>(){}.getType();
    apiClient.executeAsync(call, localVarReturnType, callback);
    return call;
  }
  
}