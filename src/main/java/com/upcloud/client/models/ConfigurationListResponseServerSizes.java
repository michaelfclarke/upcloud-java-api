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
import com.upcloud.client.models.ServerSize;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * ConfigurationListResponseServerSizes
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2017-10-30T16:52:05.756+03:00")
public class ConfigurationListResponseServerSizes {
  @SerializedName("server_size")
  private List<ServerSize> serverSize = null;

  public ConfigurationListResponseServerSizes serverSize(List<ServerSize> serverSize) {
    this.serverSize = serverSize;
    return this;
  }

  public ConfigurationListResponseServerSizes addServerSizeItem(ServerSize serverSizeItem) {
    if (this.serverSize == null) {
      this.serverSize = new ArrayList<ServerSize>();
    }
    this.serverSize.add(serverSizeItem);
    return this;
  }

   /**
   * Get serverSize
   * @return serverSize
  **/
  @ApiModelProperty(value = "")
  public List<ServerSize> getServerSize() {
    return serverSize;
  }

  public void setServerSize(List<ServerSize> serverSize) {
    this.serverSize = serverSize;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ConfigurationListResponseServerSizes configurationListResponseServerSizes = (ConfigurationListResponseServerSizes) o;
    return Objects.equals(this.serverSize, configurationListResponseServerSizes.serverSize);
  }

  @Override
  public int hashCode() {
    return Objects.hash(serverSize);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ConfigurationListResponseServerSizes {\n");
    
    sb.append("    serverSize: ").append(toIndentedString(serverSize)).append("\n");
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

