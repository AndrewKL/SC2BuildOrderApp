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
 * Warning! This file is generated. Modify at your own risk.
 */

package com.appspot.api.services.onlinebuildorderendpoint.model;

import com.google.api.client.json.GenericJson;
import com.google.api.client.json.JsonString;

/**
 * Model definition for OnlineBuildOrder.
 *
 * <p> This is the Java data model class that specifies how to parse/serialize into the JSON that is
 * transmitted over HTTP when working with the . For a detailed explanation see:
 * <a href="http://code.google.com/p/google-api-java-client/wiki/Json">http://code.google.com/p/google-api-java-client/wiki/Json</a>
 * </p>
 *
 * <p>
 * Upgrade warning: starting with version 1.12 {@code getResponseHeaders()} is removed, instead use
 * {@link com.google.api.client.http.json.JsonHttpRequest#getLastResponseHeaders()}
 * </p>
 *
 * @author Google, Inc.
 */
@SuppressWarnings("javadoc")
public final class OnlineBuildOrder extends GenericJson {

  /**
   * The value may be {@code null}.
   */
  @com.google.api.client.util.Key
  private String buildName;

  /**
   * The value may be {@code null}.
   */
  @com.google.api.client.util.Key
  private Float rating;

  /**
   * The value may be {@code null}.
   */
  @com.google.api.client.util.Key
  private String race;

  /**
   * The value may be {@code null}.
   */
  @com.google.api.client.util.Key
  private Text buildOrderInstructions;

  /**
   * The value may be {@code null}.
   */
  @com.google.api.client.util.Key @JsonString
  private Long id;

  /**

   * The value returned may be {@code null}.
   */
  public String getBuildName() {
    return buildName;
  }

  /**

   * The value set may be {@code null}.
   */
  public OnlineBuildOrder setBuildName(String buildName) {
    this.buildName = buildName;
    return this;
  }

  /**

   * The value returned may be {@code null}.
   */
  public Float getRating() {
    return rating;
  }

  /**

   * The value set may be {@code null}.
   */
  public OnlineBuildOrder setRating(Float rating) {
    this.rating = rating;
    return this;
  }

  /**

   * The value returned may be {@code null}.
   */
  public String getRace() {
    return race;
  }

  /**

   * The value set may be {@code null}.
   */
  public OnlineBuildOrder setRace(String race) {
    this.race = race;
    return this;
  }

  /**

   * The value returned may be {@code null}.
   */
  public Text getBuildOrderInstructions() {
    return buildOrderInstructions;
  }

  /**

   * The value set may be {@code null}.
   */
  public OnlineBuildOrder setBuildOrderInstructions(Text buildOrderInstructions) {
    this.buildOrderInstructions = buildOrderInstructions;
    return this;
  }

  /**

   * The value returned may be {@code null}.
   */
  public Long getId() {
    return id;
  }

  /**

   * The value set may be {@code null}.
   */
  public OnlineBuildOrder setId(Long id) {
    this.id = id;
    return this;
  }

	public void setBuildOrderInstructionsString(String buildOrderInstructions) {
		this.buildOrderInstructions = new Text();
		this.buildOrderInstructions.setValue(buildOrderInstructions);
		
	}

}
