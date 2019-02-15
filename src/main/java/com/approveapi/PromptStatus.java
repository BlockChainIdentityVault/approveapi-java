/*
 * ApproveAPISwagger
 * The simple API to request a user's approval on anything via email + sms.
 *
 * OpenAPI spec version: 1.0.0
 * Contact: dev@approveapi.com
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */


package com.approveapi;

import java.util.Objects;
import java.util.Arrays;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.IOException;

/**
 * PromptStatus
 */

public class PromptStatus {
  public static final String SERIALIZED_NAME_IS_ANSWERED = "is_answered";
  @SerializedName(SERIALIZED_NAME_IS_ANSWERED)
  private Boolean isAnswered;

  public PromptStatus isAnswered(Boolean isAnswered) {
    this.isAnswered = isAnswered;
    return this;
  }

   /**
   * Whether the prompt has been answered or not.
   * @return isAnswered
  **/
  @ApiModelProperty(required = true, value = "Whether the prompt has been answered or not.")
  public Boolean getIsAnswered() {
    return isAnswered;
  }

  public void setIsAnswered(Boolean isAnswered) {
    this.isAnswered = isAnswered;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    PromptStatus promptStatus = (PromptStatus) o;
    return Objects.equals(this.isAnswered, promptStatus.isAnswered);
  }

  @Override
  public int hashCode() {
    return Objects.hash(isAnswered);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class PromptStatus {\n");
    sb.append("    isAnswered: ").append(toIndentedString(isAnswered)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }

}

