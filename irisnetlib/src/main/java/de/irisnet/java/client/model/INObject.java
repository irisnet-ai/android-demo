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
 * Describes a rectangle that stretches around the recognized object. This is useful when redacting or blurring certain recognized objects. Each object contains the name of the classification and coordinates for a rectangle around the recognized object. The origin point (y &#x3D; 0.0, x &#x3D; 0.0) of the coordinate system is on the top left of the of the source material. The bottom right of the source is always y &#x3D; 1 and x &#x3D; 1.
 */
@ApiModel(description = "Describes a rectangle that stretches around the recognized object. This is useful when redacting or blurring certain recognized objects. Each object contains the name of the classification and coordinates for a rectangle around the recognized object. The origin point (y = 0.0, x = 0.0) of the coordinate system is on the top left of the of the source material. The bottom right of the source is always y = 1 and x = 1.")
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2020-09-22T13:03:14.380+02:00[Europe/Berlin]")
public class INObject {
  public static final String SERIALIZED_NAME_IN_CLASS = "inClass";
  @SerializedName(SERIALIZED_NAME_IN_CLASS)
  private String inClass;

  public static final String SERIALIZED_NAME_Y0 = "y0";
  @SerializedName(SERIALIZED_NAME_Y0)
  private Float y0;

  public static final String SERIALIZED_NAME_X0 = "x0";
  @SerializedName(SERIALIZED_NAME_X0)
  private Float x0;

  public static final String SERIALIZED_NAME_WIDTH = "width";
  @SerializedName(SERIALIZED_NAME_WIDTH)
  private Float width;

  public static final String SERIALIZED_NAME_HEIGHT = "height";
  @SerializedName(SERIALIZED_NAME_HEIGHT)
  private Float height;


  public INObject inClass(String inClass) {
    
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


  public INObject y0(Float y0) {
    
    this.y0 = y0;
    return this;
  }

   /**
   * The starting point of the rectangle in the horizontal (y) direction.
   * @return y0
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(example = "0.1", value = "The starting point of the rectangle in the horizontal (y) direction.")

  public Float getY0() {
    return y0;
  }


  public void setY0(Float y0) {
    this.y0 = y0;
  }


  public INObject x0(Float x0) {
    
    this.x0 = x0;
    return this;
  }

   /**
   * The starting point of the rectangle in the vertical (x) direction.
   * @return x0
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(example = "0.1", value = "The starting point of the rectangle in the vertical (x) direction.")

  public Float getX0() {
    return x0;
  }


  public void setX0(Float x0) {
    this.x0 = x0;
  }


  public INObject width(Float width) {
    
    this.width = width;
    return this;
  }

   /**
   * The distance from the starting point (y0) to end the rectangle in the horizontal direction.
   * @return width
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(example = "0.1", value = "The distance from the starting point (y0) to end the rectangle in the horizontal direction.")

  public Float getWidth() {
    return width;
  }


  public void setWidth(Float width) {
    this.width = width;
  }


  public INObject height(Float height) {
    
    this.height = height;
    return this;
  }

   /**
   * The distance from the starting point (x0) to end the rectangle in the vertical direction.
   * @return height
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(example = "0.1", value = "The distance from the starting point (x0) to end the rectangle in the vertical direction.")

  public Float getHeight() {
    return height;
  }


  public void setHeight(Float height) {
    this.height = height;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    INObject inObject = (INObject) o;
    return Objects.equals(this.inClass, inObject.inClass) &&
        Objects.equals(this.y0, inObject.y0) &&
        Objects.equals(this.x0, inObject.x0) &&
        Objects.equals(this.width, inObject.width) &&
        Objects.equals(this.height, inObject.height);
  }

  @Override
  public int hashCode() {
    return Objects.hash(inClass, y0, x0, width, height);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class INObject {\n");
    sb.append("    inClass: ").append(toIndentedString(inClass)).append("\n");
    sb.append("    y0: ").append(toIndentedString(y0)).append("\n");
    sb.append("    x0: ").append(toIndentedString(x0)).append("\n");
    sb.append("    width: ").append(toIndentedString(width)).append("\n");
    sb.append("    height: ").append(toIndentedString(height)).append("\n");
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

