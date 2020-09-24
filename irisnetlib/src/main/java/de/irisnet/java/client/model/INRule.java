/*
 * Irisnet API
 * Artificial Intelligence (AI) for image- and video-processing in realtime.
 *
 * The version of the OpenAPI document: v1
 * 
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */


package de.irisnet.java.client.model;

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
 * Describes the rules applied and the count of objects found for the given classification.
 */
@ApiModel(description = "Describes the rules applied and the count of objects found for the given classification.")
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2020-09-22T13:03:14.380+02:00[Europe/Berlin]")
public class INRule {
  public static final String SERIALIZED_NAME_IN_CLASS = "inClass";
  @SerializedName(SERIALIZED_NAME_IN_CLASS)
  private String inClass;

  public static final String SERIALIZED_NAME_FOUND = "found";
  @SerializedName(SERIALIZED_NAME_FOUND)
  private Integer found;

  public static final String SERIALIZED_NAME_MIN = "min";
  @SerializedName(SERIALIZED_NAME_MIN)
  private Integer min;

  public static final String SERIALIZED_NAME_MAX = "max";
  @SerializedName(SERIALIZED_NAME_MAX)
  private Integer max;


  public INRule inClass(String inClass) {
    
    this.inClass = inClass;
    return this;
  }

   /**
   * The classification of the recognized object.
   * @return inClass
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(example = "face", value = "The classification of the recognized object.")

  public String getInClass() {
    return inClass;
  }


  public void setInClass(String inClass) {
    this.inClass = inClass;
  }


  public INRule found(Integer found) {
    
    this.found = found;
    return this;
  }

   /**
   * The count of how many instances of the classification object were found.
   * @return found
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(example = "1", value = "The count of how many instances of the classification object were found.")

  public Integer getFound() {
    return found;
  }


  public void setFound(Integer found) {
    this.found = found;
  }


  public INRule min(Integer min) {
    
    this.min = min;
    return this;
  }

   /**
   * The minimum allowed instances of the classification object.
   * @return min
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(example = "1", value = "The minimum allowed instances of the classification object.")

  public Integer getMin() {
    return min;
  }


  public void setMin(Integer min) {
    this.min = min;
  }


  public INRule max(Integer max) {
    
    this.max = max;
    return this;
  }

   /**
   * The maximum allowed instances of the classification object.
   * @return max
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(example = "1", value = "The maximum allowed instances of the classification object.")

  public Integer getMax() {
    return max;
  }


  public void setMax(Integer max) {
    this.max = max;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    INRule inRule = (INRule) o;
    return Objects.equals(this.inClass, inRule.inClass) &&
        Objects.equals(this.found, inRule.found) &&
        Objects.equals(this.min, inRule.min) &&
        Objects.equals(this.max, inRule.max);
  }

  @Override
  public int hashCode() {
    return Objects.hash(inClass, found, min, max);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class INRule {\n");
    sb.append("    inClass: ").append(toIndentedString(inClass)).append("\n");
    sb.append("    found: ").append(toIndentedString(found)).append("\n");
    sb.append("    min: ").append(toIndentedString(min)).append("\n");
    sb.append("    max: ").append(toIndentedString(max)).append("\n");
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

