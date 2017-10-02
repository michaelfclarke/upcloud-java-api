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
import com.upcloud.client.models.Zone;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * ZoneListResponseZones
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2017-10-02T11:57:08.985+03:00")
public class ZoneListResponseZones {
  @SerializedName("zone")
  private List<Zone> zone = null;

  public ZoneListResponseZones zone(List<Zone> zone) {
    this.zone = zone;
    return this;
  }

  public ZoneListResponseZones addZoneItem(Zone zoneItem) {
    if (this.zone == null) {
      this.zone = new ArrayList<Zone>();
    }
    this.zone.add(zoneItem);
    return this;
  }

   /**
   * Get zone
   * @return zone
  **/
  @ApiModelProperty(value = "")
  public List<Zone> getZone() {
    return zone;
  }

  public void setZone(List<Zone> zone) {
    this.zone = zone;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ZoneListResponseZones zoneListResponseZones = (ZoneListResponseZones) o;
    return Objects.equals(this.zone, zoneListResponseZones.zone);
  }

  @Override
  public int hashCode() {
    return Objects.hash(zone);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ZoneListResponseZones {\n");
    
    sb.append("    zone: ").append(toIndentedString(zone)).append("\n");
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
