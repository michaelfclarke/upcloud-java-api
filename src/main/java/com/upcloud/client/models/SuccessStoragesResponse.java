/*
 * Upcloud api
 * The UpCloud API consists of operations used to control resources on UpCloud. The API is a web service interface. HTTPS is used to connect to the API. The API follows the principles of a RESTful web service wherever possible. The base URL for all API operations is  https://api.upcloud.com/. All API operations require authentication.
 *
 * OpenAPI spec version: 1.2.0
 * 
 */


package com.upcloud.client.models;

import java.util.Objects;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import com.upcloud.client.models.SuccessStoragesResponseStorages;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.IOException;

/**
 * SuccessStoragesResponse
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2017-10-09T11:42:48.898+03:00")
public class SuccessStoragesResponse {
  @SerializedName("storages")
  private SuccessStoragesResponseStorages storages = null;

  public SuccessStoragesResponse storages(SuccessStoragesResponseStorages storages) {
    this.storages = storages;
    return this;
  }

   /**
   * Get storages
   * @return storages
  **/
  @ApiModelProperty(value = "")
  public SuccessStoragesResponseStorages getStorages() {
    return storages;
  }

  public void setStorages(SuccessStoragesResponseStorages storages) {
    this.storages = storages;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    SuccessStoragesResponse successStoragesResponse = (SuccessStoragesResponse) o;
    return Objects.equals(this.storages, successStoragesResponse.storages);
  }

  @Override
  public int hashCode() {
    return Objects.hash(storages);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class SuccessStoragesResponse {\n");
    
    sb.append("    storages: ").append(toIndentedString(storages)).append("\n");
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

