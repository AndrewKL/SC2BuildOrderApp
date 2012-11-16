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
 *  on 2012-11-16 at 05:02:32 UTC 
 */

package com.appspot.api.services.onlinebuildorderendpoint;

import com.google.api.client.googleapis.GoogleUtils;
import com.google.api.client.googleapis.services.AbstractGoogleClientRequest;
import com.google.api.client.googleapis.services.GoogleClientRequestInitializer;
import com.google.api.client.googleapis.services.json.AbstractGoogleJsonClient;
import com.google.api.client.http.HttpRequestInitializer;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.JsonObjectParser;
import com.google.api.client.json.JsonString;
import com.google.common.base.Preconditions;

/**
 * Service definition for Onlinebuildorderendpoint (v1).
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
 * This service uses {@link OnlinebuildorderendpointRequestInitializer} to initialize global parameters via its
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
public class Onlinebuildorderendpoint extends AbstractGoogleJsonClient {

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
  public static final String DEFAULT_SERVICE_PATH = "onlinebuildorderendpoint/v1/";

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
  public Onlinebuildorderendpoint(HttpTransport transport, JsonFactory jsonFactory,
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
  Onlinebuildorderendpoint(HttpTransport transport,
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
   * Create a request for the method "insertOnlineBuildOrder".
   *
   * This request holds the parameters needed by the the onlinebuildorderendpoint server.  After
   * setting any optional parameters, call the {@link InsertOnlineBuildOrder#execute()} method to
   * invoke the remote operation.
   *
   * @param content the {@link com.appspot.api.services.onlinebuildorderendpoint.model.OnlineBuildOrder}
   * @return the request
   */
  public InsertOnlineBuildOrder insertOnlineBuildOrder(com.appspot.api.services.onlinebuildorderendpoint.model.OnlineBuildOrder content) throws java.io.IOException {
    InsertOnlineBuildOrder result = new InsertOnlineBuildOrder(content);
    initialize(result);
    return result;
  }

  public class InsertOnlineBuildOrder extends OnlinebuildorderendpointRequest<com.appspot.api.services.onlinebuildorderendpoint.model.OnlineBuildOrder> {

    private static final String REST_PATH = "onlinebuildorder";

    InsertOnlineBuildOrder(com.appspot.api.services.onlinebuildorderendpoint.model.OnlineBuildOrder content) {
      super(Onlinebuildorderendpoint.this, "POST", REST_PATH, content, com.appspot.api.services.onlinebuildorderendpoint.model.OnlineBuildOrder.class);
    }

    @Override
    public InsertOnlineBuildOrder setPrettyPrint(Boolean prettyPrint) {
      return (InsertOnlineBuildOrder) super.setPrettyPrint(prettyPrint);
    }

    @Override
    public InsertOnlineBuildOrder setFields(String fields) {
      return (InsertOnlineBuildOrder) super.setFields(fields);
    }

    @Override
    public InsertOnlineBuildOrder setQuotaUser(String quotaUser) {
      return (InsertOnlineBuildOrder) super.setQuotaUser(quotaUser);
    }

    @Override
    public InsertOnlineBuildOrder setOauthToken(String oauthToken) {
      return (InsertOnlineBuildOrder) super.setOauthToken(oauthToken);
    }

    @Override
    public InsertOnlineBuildOrder setKey(String key) {
      return (InsertOnlineBuildOrder) super.setKey(key);
    }

    @Override
    public InsertOnlineBuildOrder setUserIp(String userIp) {
      return (InsertOnlineBuildOrder) super.setUserIp(userIp);
    }

    @Override
    public InsertOnlineBuildOrder setAlt(String alt) {
      return (InsertOnlineBuildOrder) super.setAlt(alt);
    }

  }

  /**
   * Create a request for the method "updateOnlineBuildOrder".
   *
   * This request holds the parameters needed by the the onlinebuildorderendpoint server.  After
   * setting any optional parameters, call the {@link UpdateOnlineBuildOrder#execute()} method to
   * invoke the remote operation.
   *
   * @param content the {@link com.appspot.api.services.onlinebuildorderendpoint.model.OnlineBuildOrder}
   * @return the request
   */
  public UpdateOnlineBuildOrder updateOnlineBuildOrder(com.appspot.api.services.onlinebuildorderendpoint.model.OnlineBuildOrder content) throws java.io.IOException {
    UpdateOnlineBuildOrder result = new UpdateOnlineBuildOrder(content);
    initialize(result);
    return result;
  }

  public class UpdateOnlineBuildOrder extends OnlinebuildorderendpointRequest<com.appspot.api.services.onlinebuildorderendpoint.model.OnlineBuildOrder> {

    private static final String REST_PATH = "onlinebuildorder";

    UpdateOnlineBuildOrder(com.appspot.api.services.onlinebuildorderendpoint.model.OnlineBuildOrder content) {
      super(Onlinebuildorderendpoint.this, "PUT", REST_PATH, content, com.appspot.api.services.onlinebuildorderendpoint.model.OnlineBuildOrder.class);
    }

    @Override
    public UpdateOnlineBuildOrder setPrettyPrint(Boolean prettyPrint) {
      return (UpdateOnlineBuildOrder) super.setPrettyPrint(prettyPrint);
    }

    @Override
    public UpdateOnlineBuildOrder setFields(String fields) {
      return (UpdateOnlineBuildOrder) super.setFields(fields);
    }

    @Override
    public UpdateOnlineBuildOrder setQuotaUser(String quotaUser) {
      return (UpdateOnlineBuildOrder) super.setQuotaUser(quotaUser);
    }

    @Override
    public UpdateOnlineBuildOrder setOauthToken(String oauthToken) {
      return (UpdateOnlineBuildOrder) super.setOauthToken(oauthToken);
    }

    @Override
    public UpdateOnlineBuildOrder setKey(String key) {
      return (UpdateOnlineBuildOrder) super.setKey(key);
    }

    @Override
    public UpdateOnlineBuildOrder setUserIp(String userIp) {
      return (UpdateOnlineBuildOrder) super.setUserIp(userIp);
    }

    @Override
    public UpdateOnlineBuildOrder setAlt(String alt) {
      return (UpdateOnlineBuildOrder) super.setAlt(alt);
    }

  }

  /**
   * Create a request for the method "listOnlineBuildOrder".
   *
   * This request holds the parameters needed by the the onlinebuildorderendpoint server.  After
   * setting any optional parameters, call the {@link ListOnlineBuildOrder#execute()} method to invoke
   * the remote operation.
   *
   * @return the request
   */
  public ListOnlineBuildOrder listOnlineBuildOrder() throws java.io.IOException {
    ListOnlineBuildOrder result = new ListOnlineBuildOrder();
    initialize(result);
    return result;
  }

  public class ListOnlineBuildOrder extends OnlinebuildorderendpointRequest<com.appspot.api.services.onlinebuildorderendpoint.model.OnlineBuildOrderCollection> {

    private static final String REST_PATH = "onlinebuildorder";

    ListOnlineBuildOrder() {
      super(Onlinebuildorderendpoint.this, "GET", REST_PATH, null, com.appspot.api.services.onlinebuildorderendpoint.model.OnlineBuildOrderCollection.class);
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
    public ListOnlineBuildOrder setPrettyPrint(Boolean prettyPrint) {
      return (ListOnlineBuildOrder) super.setPrettyPrint(prettyPrint);
    }

    @Override
    public ListOnlineBuildOrder setFields(String fields) {
      return (ListOnlineBuildOrder) super.setFields(fields);
    }

    @Override
    public ListOnlineBuildOrder setQuotaUser(String quotaUser) {
      return (ListOnlineBuildOrder) super.setQuotaUser(quotaUser);
    }

    @Override
    public ListOnlineBuildOrder setOauthToken(String oauthToken) {
      return (ListOnlineBuildOrder) super.setOauthToken(oauthToken);
    }

    @Override
    public ListOnlineBuildOrder setKey(String key) {
      return (ListOnlineBuildOrder) super.setKey(key);
    }

    @Override
    public ListOnlineBuildOrder setUserIp(String userIp) {
      return (ListOnlineBuildOrder) super.setUserIp(userIp);
    }

    @Override
    public ListOnlineBuildOrder setAlt(String alt) {
      return (ListOnlineBuildOrder) super.setAlt(alt);
    }

  }

  /**
   * Create a request for the method "getOnlineBuildOrder".
   *
   * This request holds the parameters needed by the the onlinebuildorderendpoint server.  After
   * setting any optional parameters, call the {@link GetOnlineBuildOrder#execute()} method to invoke
   * the remote operation.
   *
   * @param id
   * @return the request
   */
  public GetOnlineBuildOrder getOnlineBuildOrder(Long id) throws java.io.IOException {
    GetOnlineBuildOrder result = new GetOnlineBuildOrder(id);
    initialize(result);
    return result;
  }

  public class GetOnlineBuildOrder extends OnlinebuildorderendpointRequest<com.appspot.api.services.onlinebuildorderendpoint.model.OnlineBuildOrder> {

    private static final String REST_PATH = "onlinebuildorder/{id}";

    GetOnlineBuildOrder(Long id) {
      super(Onlinebuildorderendpoint.this, "GET", REST_PATH, null, com.appspot.api.services.onlinebuildorderendpoint.model.OnlineBuildOrder.class);
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
    public GetOnlineBuildOrder setPrettyPrint(Boolean prettyPrint) {
      return (GetOnlineBuildOrder) super.setPrettyPrint(prettyPrint);
    }

    @Override
    public GetOnlineBuildOrder setFields(String fields) {
      return (GetOnlineBuildOrder) super.setFields(fields);
    }

    @Override
    public GetOnlineBuildOrder setQuotaUser(String quotaUser) {
      return (GetOnlineBuildOrder) super.setQuotaUser(quotaUser);
    }

    @Override
    public GetOnlineBuildOrder setOauthToken(String oauthToken) {
      return (GetOnlineBuildOrder) super.setOauthToken(oauthToken);
    }

    @Override
    public GetOnlineBuildOrder setKey(String key) {
      return (GetOnlineBuildOrder) super.setKey(key);
    }

    @Override
    public GetOnlineBuildOrder setUserIp(String userIp) {
      return (GetOnlineBuildOrder) super.setUserIp(userIp);
    }

    @Override
    public GetOnlineBuildOrder setAlt(String alt) {
      return (GetOnlineBuildOrder) super.setAlt(alt);
    }

    @com.google.api.client.util.Key
    private Long id;

    /**

     */
    public Long getId() {
      return id;
    }

    public GetOnlineBuildOrder setId(Long id) {
      this.id = id;
      return this;
    }

  }

  /**
   * Create a request for the method "removeOnlineBuildOrder".
   *
   * This request holds the parameters needed by the the onlinebuildorderendpoint server.  After
   * setting any optional parameters, call the {@link RemoveOnlineBuildOrder#execute()} method to
   * invoke the remote operation.
   *
   * @param id
   * @return the request
   */
  public RemoveOnlineBuildOrder removeOnlineBuildOrder(Long id) throws java.io.IOException {
    RemoveOnlineBuildOrder result = new RemoveOnlineBuildOrder(id);
    initialize(result);
    return result;
  }

  public class RemoveOnlineBuildOrder extends OnlinebuildorderendpointRequest<com.appspot.api.services.onlinebuildorderendpoint.model.OnlineBuildOrder> {

    private static final String REST_PATH = "onlinebuildorder/{id}";

    RemoveOnlineBuildOrder(Long id) {
      super(Onlinebuildorderendpoint.this, "DELETE", REST_PATH, null, com.appspot.api.services.onlinebuildorderendpoint.model.OnlineBuildOrder.class);
      this.id = Preconditions.checkNotNull(id, "Required parameter id must be specified.");
    }

    @Override
    public RemoveOnlineBuildOrder setPrettyPrint(Boolean prettyPrint) {
      return (RemoveOnlineBuildOrder) super.setPrettyPrint(prettyPrint);
    }

    @Override
    public RemoveOnlineBuildOrder setFields(String fields) {
      return (RemoveOnlineBuildOrder) super.setFields(fields);
    }

    @Override
    public RemoveOnlineBuildOrder setQuotaUser(String quotaUser) {
      return (RemoveOnlineBuildOrder) super.setQuotaUser(quotaUser);
    }

    @Override
    public RemoveOnlineBuildOrder setOauthToken(String oauthToken) {
      return (RemoveOnlineBuildOrder) super.setOauthToken(oauthToken);
    }

    @Override
    public RemoveOnlineBuildOrder setKey(String key) {
      return (RemoveOnlineBuildOrder) super.setKey(key);
    }

    @Override
    public RemoveOnlineBuildOrder setUserIp(String userIp) {
      return (RemoveOnlineBuildOrder) super.setUserIp(userIp);
    }

    @Override
    public RemoveOnlineBuildOrder setAlt(String alt) {
      return (RemoveOnlineBuildOrder) super.setAlt(alt);
    }

    @com.google.api.client.util.Key
    private Long id;

    /**

     */
    public Long getId() {
      return id;
    }

    public RemoveOnlineBuildOrder setId(Long id) {
      this.id = id;
      return this;
    }

  }

  /**
   * Builder for {@link Onlinebuildorderendpoint}.
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

    /** Builds a new instance of {@link Onlinebuildorderendpoint}. */
    @Override
    public Onlinebuildorderendpoint build() {
      return new Onlinebuildorderendpoint(getTransport(),
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
     * Set the {@link OnlinebuildorderendpointRequestInitializer}.
     *
     * @since 1.12
     */
    public Builder setOnlinebuildorderendpointRequestInitializer(
        OnlinebuildorderendpointRequestInitializer onlinebuildorderendpointRequestInitializer) {
      return (Builder) super.setGoogleClientRequestInitializer(onlinebuildorderendpointRequestInitializer);
    }

    @Override
    public Builder setGoogleClientRequestInitializer(
        GoogleClientRequestInitializer googleClientRequestInitializer) {
      return (Builder) super.setGoogleClientRequestInitializer(googleClientRequestInitializer);
    }
  }
}
