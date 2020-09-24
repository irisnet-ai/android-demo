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
import de.irisnet.java.client.model.INObject;
import de.irisnet.java.client.model.INRule;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Contains information on the AI result from the source media check.
 */
@ApiModel(description = "Contains information on the AI result from the source media check.")
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2020-09-22T13:03:14.380+02:00[Europe/Berlin]")
public class IrisNet {
  public static final String SERIALIZED_NAME_RULES_BROKEN = "rulesBroken";
  @SerializedName(SERIALIZED_NAME_RULES_BROKEN)
  private Integer rulesBroken;

  public static final String SERIALIZED_NAME_HELP_SUGGESTED = "helpSuggested";
  @SerializedName(SERIALIZED_NAME_HELP_SUGGESTED)
  private Integer helpSuggested;

  public static final String SERIALIZED_NAME_GETN_OBJECTS = "getnObjects";
  @SerializedName(SERIALIZED_NAME_GETN_OBJECTS)
  private Integer getnObjects;

  public static final String SERIALIZED_NAME_GETN_CLASSES = "getnClasses";
  @SerializedName(SERIALIZED_NAME_GETN_CLASSES)
  private Integer getnClasses;

  public static final String SERIALIZED_NAME_IN_RULE = "inRule";
  @SerializedName(SERIALIZED_NAME_IN_RULE)
  private List<INRule> inRule = null;

  public static final String SERIALIZED_NAME_IN_OBJECT = "inObject";
  @SerializedName(SERIALIZED_NAME_IN_OBJECT)
  private List<INObject> inObject = null;


  public IrisNet rulesBroken(Integer rulesBroken) {
    
    this.rulesBroken = rulesBroken;
    return this;
  }

   /**
   * The amount of broken rules that are contained in the source media.
   * @return rulesBroken
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(example = "0", value = "The amount of broken rules that are contained in the source media.")

  public Integer getRulesBroken() {
    return rulesBroken;
  }


  public void setRulesBroken(Integer rulesBroken) {
    this.rulesBroken = rulesBroken;
  }


  public IrisNet helpSuggested(Integer helpSuggested) {
    
    this.helpSuggested = helpSuggested;
    return this;
  }

   /**
   * In cases where the AI is uncertain, this attribute is set (1), indication that it could be useful to double check the source media by a human.
   * @return helpSuggested
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(example = "0", value = "In cases where the AI is uncertain, this attribute is set (1), indication that it could be useful to double check the source media by a human.")

  public Integer getHelpSuggested() {
    return helpSuggested;
  }


  public void setHelpSuggested(Integer helpSuggested) {
    this.helpSuggested = helpSuggested;
  }


  public IrisNet getnObjects(Integer getnObjects) {
    
    this.getnObjects = getnObjects;
    return this;
  }

   /**
   * The amount of objects that were recognized on the source media.
   * @return getnObjects
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(example = "1", value = "The amount of objects that were recognized on the source media.")

  public Integer getGetnObjects() {
    return getnObjects;
  }


  public void setGetnObjects(Integer getnObjects) {
    this.getnObjects = getnObjects;
  }


  public IrisNet getnClasses(Integer getnClasses) {
    
    this.getnClasses = getnClasses;
    return this;
  }

   /**
   * The amount of classification objects that were checked against on the source media. This does not mean that all of the classifications were found.
   * @return getnClasses
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(example = "8", value = "The amount of classification objects that were checked against on the source media. This does not mean that all of the classifications were found.")

  public Integer getGetnClasses() {
    return getnClasses;
  }


  public void setGetnClasses(Integer getnClasses) {
    this.getnClasses = getnClasses;
  }


  public IrisNet inRule(List<INRule> inRule) {
    
    this.inRule = inRule;
    return this;
  }

  public IrisNet addInRuleItem(INRule inRuleItem) {
    if (this.inRule == null) {
      this.inRule = new ArrayList<INRule>();
    }
    this.inRule.add(inRuleItem);
    return this;
  }

   /**
   * This list contains one rule per classification. Rules for classification objects that were not found, are omitted.
   * @return inRule
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "This list contains one rule per classification. Rules for classification objects that were not found, are omitted.")

  public List<INRule> getInRule() {
    return inRule;
  }


  public void setInRule(List<INRule> inRule) {
    this.inRule = inRule;
  }


  public IrisNet inObject(List<INObject> inObject) {
    
    this.inObject = inObject;
    return this;
  }

  public IrisNet addInObjectItem(INObject inObjectItem) {
    if (this.inObject == null) {
      this.inObject = new ArrayList<INObject>();
    }
    this.inObject.add(inObjectItem);
    return this;
  }

   /**
   * A list of all instances of the classification objects found on the source media.
   * @return inObject
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "A list of all instances of the classification objects found on the source media.")

  public List<INObject> getInObject() {
    return inObject;
  }


  public void setInObject(List<INObject> inObject) {
    this.inObject = inObject;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    IrisNet irisNet = (IrisNet) o;
    return Objects.equals(this.rulesBroken, irisNet.rulesBroken) &&
        Objects.equals(this.helpSuggested, irisNet.helpSuggested) &&
        Objects.equals(this.getnObjects, irisNet.getnObjects) &&
        Objects.equals(this.getnClasses, irisNet.getnClasses) &&
        Objects.equals(this.inRule, irisNet.inRule) &&
        Objects.equals(this.inObject, irisNet.inObject);
  }

  @Override
  public int hashCode() {
    return Objects.hash(rulesBroken, helpSuggested, getnObjects, getnClasses, inRule, inObject);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class IrisNet {\n");
    sb.append("    rulesBroken: ").append(toIndentedString(rulesBroken)).append("\n");
    sb.append("    helpSuggested: ").append(toIndentedString(helpSuggested)).append("\n");
    sb.append("    getnObjects: ").append(toIndentedString(getnObjects)).append("\n");
    sb.append("    getnClasses: ").append(toIndentedString(getnClasses)).append("\n");
    sb.append("    inRule: ").append(toIndentedString(inRule)).append("\n");
    sb.append("    inObject: ").append(toIndentedString(inObject)).append("\n");
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
