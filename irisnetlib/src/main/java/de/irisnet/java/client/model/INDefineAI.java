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
import de.irisnet.java.client.model.INImage;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Can be used to set a multitude of pre-defined commonly used rules without the need of specifying each parameter set.
 */
@ApiModel(description = "Can be used to set a multitude of pre-defined commonly used rules without the need of specifying each parameter set.")
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2020-09-22T13:03:14.380+02:00[Europe/Berlin]")
public class INDefineAI {
  public static final String SERIALIZED_NAME_IN_IMAGE = "inImage";
  @SerializedName(SERIALIZED_NAME_IN_IMAGE)
  private List<INImage> inImage = null;


  public INDefineAI inImage(List<INImage> inImage) {
    
    this.inImage = inImage;
    return this;
  }

  public INDefineAI addInImageItem(INImage inImageItem) {
    if (this.inImage == null) {
      this.inImage = new ArrayList<INImage>();
    }
    this.inImage.add(inImageItem);
    return this;
  }

   /**
   * Configures your detection. As there are literally hundreds of parameters,  INDefine uses prototypes to get usefull behaviour. This includes a default setting for parameters and rules that should be applied to images. You can combine multiple detections by using more than 1 prototype
   * @return inImage
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "Configures your detection. As there are literally hundreds of parameters,  INDefine uses prototypes to get usefull behaviour. This includes a default setting for parameters and rules that should be applied to images. You can combine multiple detections by using more than 1 prototype")

  public List<INImage> getInImage() {
    return inImage;
  }


  public void setInImage(List<INImage> inImage) {
    this.inImage = inImage;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    INDefineAI inDefineAI = (INDefineAI) o;
    return Objects.equals(this.inImage, inDefineAI.inImage);
  }

  @Override
  public int hashCode() {
    return Objects.hash(inImage);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class INDefineAI {\n");
    sb.append("    inImage: ").append(toIndentedString(inImage)).append("\n");
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

