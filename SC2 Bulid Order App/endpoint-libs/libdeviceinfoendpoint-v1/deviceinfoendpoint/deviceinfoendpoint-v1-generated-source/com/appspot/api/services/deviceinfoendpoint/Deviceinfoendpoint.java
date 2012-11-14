/*
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 */
/*
 * This file was generated.
 *  with google-apis-code-generator 1.2.0 (build: 2012-11-08 14:47:49 UTC)
 *  on 2012-11-14 at 03:42:27 UTC 
 */

package com.appspot.api.services.deviceinfoendpoint;

import com.google.api.client.googleapis.GoogleUtils;
import com.google.api.client.googleapis.services.AbstractGoogleClientRequest;
import com.google.api.client.googleapis.services.GoogleClientRequestInitializer;
import com.google.api.client.googleapis.services.json.AbstractGoogleJsonClient;
import com.google.api.client.http.HttpRequestInitializer;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.JsonObjectParser;
import com.google.common.base.Preconditions;

/**
 * Service definition for Deviceinfoendpoint (v1).
 *
 * <p>
 * This is an API
 * </p>
 *
 * <p>
 * For more information about this service, see the
 * <a href="" target="_blank">API Documentation</a>
 * </p>
 *
 * <p>
 * This service uses {@link DeviceinfoendpointRequestInitializer} to initialize global parameters via its
 * {@link Builder}.
 * </p>
 *
 * <p>
 * Upgrade warning: this class now extends {@link AbstractGoogleJsonClient}, whereas in prior
 * version 1.8 it extended {@link com.google.api.client.googleapis.services.GoogleClient}.
 * </p>
 *
 * @since 1.3
 * @author Google, Inc.
 */
@SuppressWarnings("javadoc")
public class Deviceinfoendpoint extends AbstractGoogleJsonClient {

  // Note: Leave this static initializer at the top of the file.
  static {
    Preconditions.checkState(GoogleUtils.VERSION.equals("1.12.0-beta"),
        "You are currently running with version %s of google-api-client. " +
        "You need version 1.12.0-beta of google-api-client to run version " +
        "1.12.0-beta of the  library.", GoogleUtils.VERSION);
  }

  /**
   * The default encoded root URL of the service. This is determined when the library is generated
   * and normally should not be changed.
   *
   * @since 1.7
   */
  public static final String DEFAULT_ROOT_URL = "https://myapp.appspot.com/_ah/api/";

  /**
   * The default encoded service path of the service. This is determined when the library is
   * generated and normally should not be changed.
   *
   * @since 1.7
   */
  public static final String DEFAULT_SERVICE_PATH = "deviceinfoendpoint/v1/";

  /**
   * The default encoded base URL of the service. This is determined when the library is generated
   * and normally should not be changed.
   * @deprecated (scheduled to be removed in 1.13)
   */
  @Deprecated
  public static final String DEFAULT_BASE_URL = DEFAULT_ROOT_URL + DEFAULT_SERVICE_PATH;

  /**
   * Constructor.
   *
   * <p>
   * Use {@link Builder} if you need to specify any of the optional parameters.
   * </p>
   *
   * @param transport HTTP transport
   * @param jsonFactory JSON factory
   * @param httpRequestInitializer HTTP request initializer or {@code null} for none
   * @since 1.7
   */
  public Deviceinfoendpoint(HttpTransport transport, JsonFactory jsonFactory,
      HttpRequestInitializer httpRequestInitializer) {
    super(transport,
        jsonFactory,
        DEFAULT_ROOT_URL,
        DEFAULT_SERVICE_PATH,
        httpRequestInitializer,
        false);
  }

  /**
   * @param transport HTTP transport
   * @param httpRequestInitializer HTTP request initializer or {@code null} for none
   * @param rootUrl root URL of the service
   * @param servicePath service path
   * @param jsonObjectParser JSON object parser
   * @param googleClientRequestInitializer Google request initializer or {@code null} for none
   * @param applicationName application name to be sent in the User-Agent header of requests or
   *        {@code null} for none
   * @param suppressPatternChecks whether discovery pattern checks should be suppressed on required
   *        parameters
   */
  Deviceinfoendpoint(HttpTransport transport,
      HttpRequestInitializer httpRequestInitializer,
      String rootUrl,
      String servicePath,
      JsonObjectParser jsonObjectParser,
      GoogleClientRequestInitializer googleClientRequestInitializer,
      String applicationName,
      boolean suppressPatternChecks) {
    super(transport,
        httpRequestInitializer,
        rootUrl,
        servicePath,
        jsonObjectParser,
        googleClientRequestInitializer,
        applicationName,
        suppressPatternChecks);
  }

  @Override
  protected void initialize(AbstractGoogleClientRequest<?> httpClientRequest) throws java.io.IOException {
    super.initialize(httpClientRequest);
  }

  /**
   * Create a request for the method "listDeviceInfo".
   *
   * This request holds the parameters needed by the the deviceinfoendpoint server.  After setting any
   * optional parameters, call the {@link ListDeviceInfo#execute()} method to invoke the remote
   * operation.
   *
   * @return the request
   */
  public ListDeviceInfo listDeviceInfo() throws java.io.IOException {
    ListDeviceInfo result = new ListDeviceInfo();
    initialize(result);
    return result;
  }

  public class ListDeviceInfo extends DeviceinfoendpointRequest<com.appspot.api.services.deviceinfoendpoint.model.DeviceInfoCollection> {

    private static final String REST_PATH = "deviceinfo";

    ListDeviceInfo() {
      super(Deviceinfoendpoint.this, "GET", REST_PATH, null, com.appspot.api.services.deviceinfoendpoint.model.DeviceInfoCollection.class);
    }

    @Override
    public com.google.api.client.http.HttpResponse executeUsingHead() throws java.io.IOException {
      return super.executeUsingHead();
    }

    @Override
    public com.google.api.client.http.HttpRequest buildHttpRequestUsingHead() throws java.io.IOException {
      return super.buildHttpRequestUsingHead();
    }

    @Override
    public ListDeviceInfo setPrettyPrint(Boolean prettyPrint) {
      return (ListDeviceInfo) super.setPrettyPrint(prettyPrint);
    }

    @Override
    public ListDeviceInfo setFields(String fields) {
      return (ListDeviceInfo) super.setFields(fields);
    }

    @Override
    public ListDeviceInfo setQuotaUser(String quotaUser) {
      return (ListDeviceInfo) super.setQuotaUser(quotaUser);
    }

    @Override
    public ListDeviceInfo setOauthToken(String oauthToken) {
      return (ListDeviceInfo) super.setOauthToken(oauthToken);
    }

    @Override
    public ListDeviceInfo setKey(String key) {
      return (ListDeviceInfo) super.setKey(key);
    }

    @Override
    public ListDeviceInfo setUserIp(String userIp) {
      return (ListDeviceInfo) super.setUserIp(userIp);
    }

    @Override
    public ListDeviceInfo setAlt(String alt) {
      return (ListDeviceInfo) super.setAlt(alt);
    }

  }

  /**
   * Create a request for the method "updateDeviceInfo".
   *
   * This request holds the parameters needed by the the deviceinfoendpoint server.  After setting any
   * optional parameters, call the {@link UpdateDeviceInfo#execute()} method to invoke the remote
   * operation.
   *
   * @param content the {@link com.appspot.api.services.deviceinfoendpoint.model.DeviceInfo}
   * @return the request
   */
  public UpdateDeviceInfo updateDeviceInfo(com.appspot.api.services.deviceinfoendpoint.model.DeviceInfo content) throws java.io.IOException {
    UpdateDeviceInfo result = new UpdateDeviceInfo(content);
    initialize(result);
    return result;
  }

  public class UpdateDeviceInfo extends DeviceinfoendpointRequest<com.appspot.api.services.deviceinfoendpoint.model.DeviceInfo> {

    private static final String REST_PATH = "deviceinfo";

    UpdateDeviceInfo(com.appspot.api.services.deviceinfoendpoint.model.DeviceInfo content) {
      super(Deviceinfoendpoint.this, "PUT", REST_PATH, content, com.appspot.api.services.deviceinfoendpoint.model.DeviceInfo.class);
    }

    @Override
    public UpdateDeviceInfo setPrettyPrint(Boolean prettyPrint) {
      return (UpdateDeviceInfo) super.setPrettyPrint(prettyPrint);
    }

    @Override
    public UpdateDeviceInfo setFields(String fields) {
      return (UpdateDeviceInfo) super.setFields(fields);
    }

    @Override
    public UpdateDeviceInfo setQuotaUser(String quotaUser) {
      return (UpdateDeviceInfo) super.setQuotaUser(quotaUser);
    }

    @Override
    public UpdateDeviceInfo setOauthToken(String oauthToken) {
      return (UpdateDeviceInfo) super.setOauthToken(oauthToken);
    }

    @Override
    public UpdateDeviceInfo setKey(String key) {
      return (UpdateDeviceInfo) super.setKey(key);
    }

    @Override
    public UpdateDeviceInfo setUserIp(String userIp) {
      return (UpdateDeviceInfo) super.setUserIp(userIp);
    }

    @Override
    public UpdateDeviceInfo setAlt(String alt) {
      return (UpdateDeviceInfo) super.setAlt(alt);
    }

  }

  /**
   * Create a request for the method "insertDeviceInfo".
   *
   * This request holds the parameters needed by the the deviceinfoendpoint server.  After setting any
   * optional parameters, call the {@link InsertDeviceInfo#execute()} method to invoke the remote
   * operation.
   *
   * @param content the {@link com.appspot.api.services.deviceinfoendpoint.model.DeviceInfo}
   * @return the request
   */
  public InsertDeviceInfo insertDeviceInfo(com.appspot.api.services.deviceinfoendpoint.model.DeviceInfo content) throws java.io.IOException {
    InsertDeviceInfo result = new InsertDeviceInfo(content);
    initialize(result);
    return result;
  }

  public class InsertDeviceInfo extends DeviceinfoendpointRequest<com.appspot.api.services.deviceinfoendpoint.model.DeviceInfo> {

    private static final String REST_PATH = "deviceinfo";

    InsertDeviceInfo(com.appspot.api.services.deviceinfoendpoint.model.DeviceInfo content) {
      super(Deviceinfoendpoint.this, "POST", REST_PATH, content, com.appspot.api.services.deviceinfoendpoint.model.DeviceInfo.class);
    }

    @Override
    public InsertDeviceInfo setPrettyPrint(Boolean prettyPrint) {
      return (InsertDeviceInfo) super.setPrettyPrint(prettyPrint);
    }

    @Override
    public InsertDeviceInfo setFields(String fields) {
      return (InsertDeviceInfo) super.setFields(fields);
    }

    @Override
    public InsertDeviceInfo setQuotaUser(String quotaUser) {
      return (InsertDeviceInfo) super.setQuotaUser(quotaUser);
    }

    @Override
    public InsertDeviceInfo setOauthToken(String oauthToken) {
      return (InsertDeviceInfo) super.setOauthToken(oauthToken);
    }

    @Override
    public InsertDeviceInfo setKey(String key) {
      return (InsertDeviceInfo) super.setKey(key);
    }

    @Override
    public InsertDeviceInfo setUserIp(String userIp) {
      return (InsertDeviceInfo) super.setUserIp(userIp);
    }

    @Override
    public InsertDeviceInfo setAlt(String alt) {
      return (InsertDeviceInfo) super.setAlt(alt);
    }

  }

  /**
   * Create a request for the method "removeDeviceInfo".
   *
   * This request holds the parameters needed by the the deviceinfoendpoint server.  After setting any
   * optional parameters, call the {@link RemoveDeviceInfo#execute()} method to invoke the remote
   * operation.
   *
   * @param id
   * @return the request
   */
  public RemoveDeviceInfo removeDeviceInfo(String id) throws java.io.IOException {
    RemoveDeviceInfo result = new RemoveDeviceInfo(id);
    initialize(result);
    return result;
  }

  public class RemoveDeviceInfo extends DeviceinfoendpointRequest<com.appspot.api.services.deviceinfoendpoint.model.DeviceInfo> {

    private static final String REST_PATH = "deviceinfo/{id}";

    RemoveDeviceInfo(String id) {
      super(Deviceinfoendpoint.this, "DELETE", REST_PATH, null, com.appspot.api.services.deviceinfoendpoint.model.DeviceInfo.class);
      this.id = Preconditions.checkNotNull(id, "Required parameter id must be specified.");
    }

    @Override
    public RemoveDeviceInfo setPrettyPrint(Boolean prettyPrint) {
      return (RemoveDeviceInfo) super.setPrettyPrint(prettyPrint);
    }

    @Override
    public RemoveDeviceInfo setFields(String fields) {
      return (RemoveDeviceInfo) super.setFields(fields);
    }

    @Override
    public RemoveDeviceInfo setQuotaUser(String quotaUser) {
      return (RemoveDeviceInfo) super.setQuotaUser(quotaUser);
    }

    @Override
    public RemoveDeviceInfo setOauthToken(String oauthToken) {
      return (RemoveDeviceInfo) super.setOauthToken(oauthToken);
    }

    @Override
    public RemoveDeviceInfo setKey(String key) {
      return (RemoveDeviceInfo) super.setKey(key);
    }

    @Override
    public RemoveDeviceInfo setUserIp(String userIp) {
      return (RemoveDeviceInfo) super.setUserIp(userIp);
    }

    @Override
    public RemoveDeviceInfo setAlt(String alt) {
      return (RemoveDeviceInfo) super.setAlt(alt);
    }

    @com.google.api.client.util.Key
    private String id;

    /**

     */
    public String getId() {
      return id;
    }

    public RemoveDeviceInfo setId(String id) {
      this.id = id;
      return this;
    }

  }

  /**
   * Create a request for the method "getDeviceInfo".
   *
   * This request holds the parameters needed by the the deviceinfoendpoint server.  After setting any
   * optional parameters, call the {@link GetDeviceInfo#execute()} method to invoke the remote
   * operation.
   *
   * @param id
   * @return the request
   */
  public GetDeviceInfo getDeviceInfo(String id) throws java.io.IOException {
    GetDeviceInfo result = new GetDeviceInfo(id);
    initialize(result);
    return result;
  }

  public class GetDeviceInfo extends DeviceinfoendpointRequest<com.appspot.api.services.deviceinfoendpoint.model.DeviceInfo> {

    private static final String REST_PATH = "deviceinfo/{id}";

    GetDeviceInfo(String id) {
      super(Deviceinfoendpoint.this, "GET", REST_PATH, null, com.appspot.api.services.deviceinfoendpoint.model.DeviceInfo.class);
      this.id = Preconditions.checkNotNull(id, "Required parameter id must be specified.");
    }

    @Override
    public com.google.api.client.http.HttpResponse executeUsingHead() throws java.io.IOException {
      return super.executeUsingHead();
    }

    @Override
    public com.google.api.client.http.HttpRequest buildHttpRequestUsingHead() throws java.io.IOException {
      return super.buildHttpRequestUsingHead();
    }

    @Override
    public GetDeviceInfo setPrettyPrint(Boolean prettyPrint) {
      return (GetDeviceInfo) super.setPrettyPrint(prettyPrint);
    }

    @Override
    public GetDeviceInfo setFields(String fields) {
      return (GetDeviceInfo) super.setFields(fields);
    }

    @Override
    public GetDeviceInfo setQuotaUser(String quotaUser) {
      return (GetDeviceInfo) super.setQuotaUser(quotaUser);
    }

    @Override
    public GetDeviceInfo setOauthToken(String oauthToken) {
      return (GetDeviceInfo) super.setOauthToken(oauthToken);
    }

    @Override
    public GetDeviceInfo setKey(String key) {
      return (GetDeviceInfo) super.setKey(key);
    }

    @Override
    public GetDeviceInfo setUserIp(String userIp) {
      return (GetDeviceInfo) super.setUserIp(userIp);
    }

    @Override
    public GetDeviceInfo setAlt(String alt) {
      return (GetDeviceInfo) super.setAlt(alt);
    }

    @com.google.api.client.util.Key
    private String id;

    /**

     */
    public String getId() {
      return id;
    }

    public GetDeviceInfo setId(String id) {
      this.id = id;
      return this;
    }

  }

  /**
   * Builder for {@link Deviceinfoendpoint}.
   *
   * <p>
   * Implementation is not thread-safe.
   * </p>
   *
   * @since 1.3.0
   */
  public static final class Builder extends AbstractGoogleJsonClient.Builder {

    /**
     * Returns an instance of a new builder.
     *
     * @param transport HTTP transport
     * @param jsonFactory JSON factory
     * @param httpRequestInitializer HTTP request initializer or {@code null} for none
     * @since 1.7
     */
    public Builder(HttpTransport transport, JsonFactory jsonFactory,
        HttpRequestInitializer httpRequestInitializer) {
      super(
          transport,
          jsonFactory,
          DEFAULT_ROOT_URL,
          DEFAULT_SERVICE_PATH,
          httpRequestInitializer,
          false);
    }

    /** Builds a new instance of {@link Deviceinfoendpoint}. */
    @Override
    public Deviceinfoendpoint build() {
      return new Deviceinfoendpoint(getTransport(),
          getHttpRequestInitializer(),
          getRootUrl(),
          getServicePath(),
          getObjectParser(),
          getGoogleClientRequestInitializer(),
          getApplicationName(),
          getSuppressPatternChecks());
    }

    @Override
    public Builder setRootUrl(String rootUrl) {
      return (Builder) super.setRootUrl(rootUrl);
    }

    @Override
    public Builder setServicePath(String servicePath) {
      return (Builder) super.setServicePath(servicePath);
    }

    @Override
    public Builder setHttpRequestInitializer(HttpRequestInitializer httpRequestInitializer) {
      return (Builder) super.setHttpRequestInitializer(httpRequestInitializer);
    }

    @Override
    public Builder setApplicationName(String applicationName) {
      return (Builder) super.setApplicationName(applicationName);
    }

    @Override
    public Builder setSuppressPatternChecks(boolean suppressPatternChecks) {
      return (Builder) super.setSuppressPatternChecks(suppressPatternChecks);
    }

    /**
     * Set the {@link DeviceinfoendpointRequestInitializer}.
     *
     * @since 1.12
     */
    public Builder setDeviceinfoendpointRequestInitializer(
        DeviceinfoendpointRequestInitializer deviceinfoendpointRequestInitializer) {
      return (Builder) super.setGoogleClientRequestInitializer(deviceinfoendpointRequestInitializer);
    }

    @Override
    public Builder setGoogleClientRequestInitializer(
        GoogleClientRequestInitializer googleClientRequestInitializer) {
      return (Builder) super.setGoogleClientRequestInitializer(googleClientRequestInitializer);
    }
  }
}