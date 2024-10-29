/*
 * OpenAPI Petstore
 * This spec is mainly for testing Petstore server and contains fake endpoints, models. Please do not use this for any other purpose. Special characters: \" \\
 *
 * The version of the OpenAPI document: 1.0.0
 * 
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */


package org.openapitools.client.model;

import java.util.Objects;
import java.util.Arrays;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.fasterxml.jackson.annotation.JsonValue;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonTypeName;
import jakarta.validation.constraints.*;
import jakarta.validation.Valid;

/**
 * XmlItem
 */
@JsonPropertyOrder({
  XmlItem.JSON_PROPERTY_ATTRIBUTE_STRING,
  XmlItem.JSON_PROPERTY_ATTRIBUTE_NUMBER,
  XmlItem.JSON_PROPERTY_ATTRIBUTE_INTEGER,
  XmlItem.JSON_PROPERTY_ATTRIBUTE_BOOLEAN,
  XmlItem.JSON_PROPERTY_WRAPPED_ARRAY,
  XmlItem.JSON_PROPERTY_NAME_STRING,
  XmlItem.JSON_PROPERTY_NAME_NUMBER,
  XmlItem.JSON_PROPERTY_NAME_INTEGER,
  XmlItem.JSON_PROPERTY_NAME_BOOLEAN,
  XmlItem.JSON_PROPERTY_NAME_ARRAY,
  XmlItem.JSON_PROPERTY_NAME_WRAPPED_ARRAY,
  XmlItem.JSON_PROPERTY_PREFIX_STRING,
  XmlItem.JSON_PROPERTY_PREFIX_NUMBER,
  XmlItem.JSON_PROPERTY_PREFIX_INTEGER,
  XmlItem.JSON_PROPERTY_PREFIX_BOOLEAN,
  XmlItem.JSON_PROPERTY_PREFIX_ARRAY,
  XmlItem.JSON_PROPERTY_PREFIX_WRAPPED_ARRAY,
  XmlItem.JSON_PROPERTY_NAMESPACE_STRING,
  XmlItem.JSON_PROPERTY_NAMESPACE_NUMBER,
  XmlItem.JSON_PROPERTY_NAMESPACE_INTEGER,
  XmlItem.JSON_PROPERTY_NAMESPACE_BOOLEAN,
  XmlItem.JSON_PROPERTY_NAMESPACE_ARRAY,
  XmlItem.JSON_PROPERTY_NAMESPACE_WRAPPED_ARRAY,
  XmlItem.JSON_PROPERTY_PREFIX_NS_STRING,
  XmlItem.JSON_PROPERTY_PREFIX_NS_NUMBER,
  XmlItem.JSON_PROPERTY_PREFIX_NS_INTEGER,
  XmlItem.JSON_PROPERTY_PREFIX_NS_BOOLEAN,
  XmlItem.JSON_PROPERTY_PREFIX_NS_ARRAY,
  XmlItem.JSON_PROPERTY_PREFIX_NS_WRAPPED_ARRAY
})
@jakarta.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", comments = "Generator version: 7.10.0-SNAPSHOT")
public class XmlItem {
  public static final String JSON_PROPERTY_ATTRIBUTE_STRING = "attribute_string";
  @jakarta.annotation.Nullable
  private String attributeString;

  public static final String JSON_PROPERTY_ATTRIBUTE_NUMBER = "attribute_number";
  @jakarta.annotation.Nullable
  private BigDecimal attributeNumber;

  public static final String JSON_PROPERTY_ATTRIBUTE_INTEGER = "attribute_integer";
  @jakarta.annotation.Nullable
  private Integer attributeInteger;

  public static final String JSON_PROPERTY_ATTRIBUTE_BOOLEAN = "attribute_boolean";
  @jakarta.annotation.Nullable
  private Boolean attributeBoolean;

  public static final String JSON_PROPERTY_WRAPPED_ARRAY = "wrapped_array";
  @jakarta.annotation.Nullable
  private List<Integer> wrappedArray = new ArrayList<>();

  public static final String JSON_PROPERTY_NAME_STRING = "name_string";
  @jakarta.annotation.Nullable
  private String nameString;

  public static final String JSON_PROPERTY_NAME_NUMBER = "name_number";
  @jakarta.annotation.Nullable
  private BigDecimal nameNumber;

  public static final String JSON_PROPERTY_NAME_INTEGER = "name_integer";
  @jakarta.annotation.Nullable
  private Integer nameInteger;

  public static final String JSON_PROPERTY_NAME_BOOLEAN = "name_boolean";
  @jakarta.annotation.Nullable
  private Boolean nameBoolean;

  public static final String JSON_PROPERTY_NAME_ARRAY = "name_array";
  @jakarta.annotation.Nullable
  private List<Integer> nameArray = new ArrayList<>();

  public static final String JSON_PROPERTY_NAME_WRAPPED_ARRAY = "name_wrapped_array";
  @jakarta.annotation.Nullable
  private List<Integer> nameWrappedArray = new ArrayList<>();

  public static final String JSON_PROPERTY_PREFIX_STRING = "prefix_string";
  @jakarta.annotation.Nullable
  private String prefixString;

  public static final String JSON_PROPERTY_PREFIX_NUMBER = "prefix_number";
  @jakarta.annotation.Nullable
  private BigDecimal prefixNumber;

  public static final String JSON_PROPERTY_PREFIX_INTEGER = "prefix_integer";
  @jakarta.annotation.Nullable
  private Integer prefixInteger;

  public static final String JSON_PROPERTY_PREFIX_BOOLEAN = "prefix_boolean";
  @jakarta.annotation.Nullable
  private Boolean prefixBoolean;

  public static final String JSON_PROPERTY_PREFIX_ARRAY = "prefix_array";
  @jakarta.annotation.Nullable
  private List<Integer> prefixArray = new ArrayList<>();

  public static final String JSON_PROPERTY_PREFIX_WRAPPED_ARRAY = "prefix_wrapped_array";
  @jakarta.annotation.Nullable
  private List<Integer> prefixWrappedArray = new ArrayList<>();

  public static final String JSON_PROPERTY_NAMESPACE_STRING = "namespace_string";
  @jakarta.annotation.Nullable
  private String namespaceString;

  public static final String JSON_PROPERTY_NAMESPACE_NUMBER = "namespace_number";
  @jakarta.annotation.Nullable
  private BigDecimal namespaceNumber;

  public static final String JSON_PROPERTY_NAMESPACE_INTEGER = "namespace_integer";
  @jakarta.annotation.Nullable
  private Integer namespaceInteger;

  public static final String JSON_PROPERTY_NAMESPACE_BOOLEAN = "namespace_boolean";
  @jakarta.annotation.Nullable
  private Boolean namespaceBoolean;

  public static final String JSON_PROPERTY_NAMESPACE_ARRAY = "namespace_array";
  @jakarta.annotation.Nullable
  private List<Integer> namespaceArray = new ArrayList<>();

  public static final String JSON_PROPERTY_NAMESPACE_WRAPPED_ARRAY = "namespace_wrapped_array";
  @jakarta.annotation.Nullable
  private List<Integer> namespaceWrappedArray = new ArrayList<>();

  public static final String JSON_PROPERTY_PREFIX_NS_STRING = "prefix_ns_string";
  @jakarta.annotation.Nullable
  private String prefixNsString;

  public static final String JSON_PROPERTY_PREFIX_NS_NUMBER = "prefix_ns_number";
  @jakarta.annotation.Nullable
  private BigDecimal prefixNsNumber;

  public static final String JSON_PROPERTY_PREFIX_NS_INTEGER = "prefix_ns_integer";
  @jakarta.annotation.Nullable
  private Integer prefixNsInteger;

  public static final String JSON_PROPERTY_PREFIX_NS_BOOLEAN = "prefix_ns_boolean";
  @jakarta.annotation.Nullable
  private Boolean prefixNsBoolean;

  public static final String JSON_PROPERTY_PREFIX_NS_ARRAY = "prefix_ns_array";
  @jakarta.annotation.Nullable
  private List<Integer> prefixNsArray = new ArrayList<>();

  public static final String JSON_PROPERTY_PREFIX_NS_WRAPPED_ARRAY = "prefix_ns_wrapped_array";
  @jakarta.annotation.Nullable
  private List<Integer> prefixNsWrappedArray = new ArrayList<>();

  public XmlItem() {
  }

  public XmlItem attributeString(@jakarta.annotation.Nullable String attributeString) {
    
    this.attributeString = attributeString;
    return this;
  }

  /**
   * Get attributeString
   * @return attributeString
   */
  @jakarta.annotation.Nullable

  @JsonProperty(JSON_PROPERTY_ATTRIBUTE_STRING)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getAttributeString() {
    return attributeString;
  }


  @JsonProperty(JSON_PROPERTY_ATTRIBUTE_STRING)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setAttributeString(@jakarta.annotation.Nullable String attributeString) {
    this.attributeString = attributeString;
  }

  public XmlItem attributeNumber(@jakarta.annotation.Nullable BigDecimal attributeNumber) {
    
    this.attributeNumber = attributeNumber;
    return this;
  }

  /**
   * Get attributeNumber
   * @return attributeNumber
   */
  @jakarta.annotation.Nullable
  @Valid

  @JsonProperty(JSON_PROPERTY_ATTRIBUTE_NUMBER)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public BigDecimal getAttributeNumber() {
    return attributeNumber;
  }


  @JsonProperty(JSON_PROPERTY_ATTRIBUTE_NUMBER)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setAttributeNumber(@jakarta.annotation.Nullable BigDecimal attributeNumber) {
    this.attributeNumber = attributeNumber;
  }

  public XmlItem attributeInteger(@jakarta.annotation.Nullable Integer attributeInteger) {
    
    this.attributeInteger = attributeInteger;
    return this;
  }

  /**
   * Get attributeInteger
   * @return attributeInteger
   */
  @jakarta.annotation.Nullable

  @JsonProperty(JSON_PROPERTY_ATTRIBUTE_INTEGER)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public Integer getAttributeInteger() {
    return attributeInteger;
  }


  @JsonProperty(JSON_PROPERTY_ATTRIBUTE_INTEGER)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setAttributeInteger(@jakarta.annotation.Nullable Integer attributeInteger) {
    this.attributeInteger = attributeInteger;
  }

  public XmlItem attributeBoolean(@jakarta.annotation.Nullable Boolean attributeBoolean) {
    
    this.attributeBoolean = attributeBoolean;
    return this;
  }

  /**
   * Get attributeBoolean
   * @return attributeBoolean
   */
  @jakarta.annotation.Nullable

  @JsonProperty(JSON_PROPERTY_ATTRIBUTE_BOOLEAN)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public Boolean getAttributeBoolean() {
    return attributeBoolean;
  }


  @JsonProperty(JSON_PROPERTY_ATTRIBUTE_BOOLEAN)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setAttributeBoolean(@jakarta.annotation.Nullable Boolean attributeBoolean) {
    this.attributeBoolean = attributeBoolean;
  }

  public XmlItem wrappedArray(@jakarta.annotation.Nullable List<Integer> wrappedArray) {
    
    this.wrappedArray = wrappedArray;
    return this;
  }

  public XmlItem addWrappedArrayItem(Integer wrappedArrayItem) {
    if (this.wrappedArray == null) {
      this.wrappedArray = new ArrayList<>();
    }
    this.wrappedArray.add(wrappedArrayItem);
    return this;
  }

  /**
   * Get wrappedArray
   * @return wrappedArray
   */
  @jakarta.annotation.Nullable

  @JsonProperty(JSON_PROPERTY_WRAPPED_ARRAY)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public List<Integer> getWrappedArray() {
    return wrappedArray;
  }


  @JsonProperty(JSON_PROPERTY_WRAPPED_ARRAY)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setWrappedArray(@jakarta.annotation.Nullable List<Integer> wrappedArray) {
    this.wrappedArray = wrappedArray;
  }

  public XmlItem nameString(@jakarta.annotation.Nullable String nameString) {
    
    this.nameString = nameString;
    return this;
  }

  /**
   * Get nameString
   * @return nameString
   */
  @jakarta.annotation.Nullable

  @JsonProperty(JSON_PROPERTY_NAME_STRING)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getNameString() {
    return nameString;
  }


  @JsonProperty(JSON_PROPERTY_NAME_STRING)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setNameString(@jakarta.annotation.Nullable String nameString) {
    this.nameString = nameString;
  }

  public XmlItem nameNumber(@jakarta.annotation.Nullable BigDecimal nameNumber) {
    
    this.nameNumber = nameNumber;
    return this;
  }

  /**
   * Get nameNumber
   * @return nameNumber
   */
  @jakarta.annotation.Nullable
  @Valid

  @JsonProperty(JSON_PROPERTY_NAME_NUMBER)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public BigDecimal getNameNumber() {
    return nameNumber;
  }


  @JsonProperty(JSON_PROPERTY_NAME_NUMBER)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setNameNumber(@jakarta.annotation.Nullable BigDecimal nameNumber) {
    this.nameNumber = nameNumber;
  }

  public XmlItem nameInteger(@jakarta.annotation.Nullable Integer nameInteger) {
    
    this.nameInteger = nameInteger;
    return this;
  }

  /**
   * Get nameInteger
   * @return nameInteger
   */
  @jakarta.annotation.Nullable

  @JsonProperty(JSON_PROPERTY_NAME_INTEGER)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public Integer getNameInteger() {
    return nameInteger;
  }


  @JsonProperty(JSON_PROPERTY_NAME_INTEGER)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setNameInteger(@jakarta.annotation.Nullable Integer nameInteger) {
    this.nameInteger = nameInteger;
  }

  public XmlItem nameBoolean(@jakarta.annotation.Nullable Boolean nameBoolean) {
    
    this.nameBoolean = nameBoolean;
    return this;
  }

  /**
   * Get nameBoolean
   * @return nameBoolean
   */
  @jakarta.annotation.Nullable

  @JsonProperty(JSON_PROPERTY_NAME_BOOLEAN)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public Boolean getNameBoolean() {
    return nameBoolean;
  }


  @JsonProperty(JSON_PROPERTY_NAME_BOOLEAN)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setNameBoolean(@jakarta.annotation.Nullable Boolean nameBoolean) {
    this.nameBoolean = nameBoolean;
  }

  public XmlItem nameArray(@jakarta.annotation.Nullable List<Integer> nameArray) {
    
    this.nameArray = nameArray;
    return this;
  }

  public XmlItem addNameArrayItem(Integer nameArrayItem) {
    if (this.nameArray == null) {
      this.nameArray = new ArrayList<>();
    }
    this.nameArray.add(nameArrayItem);
    return this;
  }

  /**
   * Get nameArray
   * @return nameArray
   */
  @jakarta.annotation.Nullable

  @JsonProperty(JSON_PROPERTY_NAME_ARRAY)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public List<Integer> getNameArray() {
    return nameArray;
  }


  @JsonProperty(JSON_PROPERTY_NAME_ARRAY)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setNameArray(@jakarta.annotation.Nullable List<Integer> nameArray) {
    this.nameArray = nameArray;
  }

  public XmlItem nameWrappedArray(@jakarta.annotation.Nullable List<Integer> nameWrappedArray) {
    
    this.nameWrappedArray = nameWrappedArray;
    return this;
  }

  public XmlItem addNameWrappedArrayItem(Integer nameWrappedArrayItem) {
    if (this.nameWrappedArray == null) {
      this.nameWrappedArray = new ArrayList<>();
    }
    this.nameWrappedArray.add(nameWrappedArrayItem);
    return this;
  }

  /**
   * Get nameWrappedArray
   * @return nameWrappedArray
   */
  @jakarta.annotation.Nullable

  @JsonProperty(JSON_PROPERTY_NAME_WRAPPED_ARRAY)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public List<Integer> getNameWrappedArray() {
    return nameWrappedArray;
  }


  @JsonProperty(JSON_PROPERTY_NAME_WRAPPED_ARRAY)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setNameWrappedArray(@jakarta.annotation.Nullable List<Integer> nameWrappedArray) {
    this.nameWrappedArray = nameWrappedArray;
  }

  public XmlItem prefixString(@jakarta.annotation.Nullable String prefixString) {
    
    this.prefixString = prefixString;
    return this;
  }

  /**
   * Get prefixString
   * @return prefixString
   */
  @jakarta.annotation.Nullable

  @JsonProperty(JSON_PROPERTY_PREFIX_STRING)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getPrefixString() {
    return prefixString;
  }


  @JsonProperty(JSON_PROPERTY_PREFIX_STRING)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setPrefixString(@jakarta.annotation.Nullable String prefixString) {
    this.prefixString = prefixString;
  }

  public XmlItem prefixNumber(@jakarta.annotation.Nullable BigDecimal prefixNumber) {
    
    this.prefixNumber = prefixNumber;
    return this;
  }

  /**
   * Get prefixNumber
   * @return prefixNumber
   */
  @jakarta.annotation.Nullable
  @Valid

  @JsonProperty(JSON_PROPERTY_PREFIX_NUMBER)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public BigDecimal getPrefixNumber() {
    return prefixNumber;
  }


  @JsonProperty(JSON_PROPERTY_PREFIX_NUMBER)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setPrefixNumber(@jakarta.annotation.Nullable BigDecimal prefixNumber) {
    this.prefixNumber = prefixNumber;
  }

  public XmlItem prefixInteger(@jakarta.annotation.Nullable Integer prefixInteger) {
    
    this.prefixInteger = prefixInteger;
    return this;
  }

  /**
   * Get prefixInteger
   * @return prefixInteger
   */
  @jakarta.annotation.Nullable

  @JsonProperty(JSON_PROPERTY_PREFIX_INTEGER)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public Integer getPrefixInteger() {
    return prefixInteger;
  }


  @JsonProperty(JSON_PROPERTY_PREFIX_INTEGER)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setPrefixInteger(@jakarta.annotation.Nullable Integer prefixInteger) {
    this.prefixInteger = prefixInteger;
  }

  public XmlItem prefixBoolean(@jakarta.annotation.Nullable Boolean prefixBoolean) {
    
    this.prefixBoolean = prefixBoolean;
    return this;
  }

  /**
   * Get prefixBoolean
   * @return prefixBoolean
   */
  @jakarta.annotation.Nullable

  @JsonProperty(JSON_PROPERTY_PREFIX_BOOLEAN)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public Boolean getPrefixBoolean() {
    return prefixBoolean;
  }


  @JsonProperty(JSON_PROPERTY_PREFIX_BOOLEAN)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setPrefixBoolean(@jakarta.annotation.Nullable Boolean prefixBoolean) {
    this.prefixBoolean = prefixBoolean;
  }

  public XmlItem prefixArray(@jakarta.annotation.Nullable List<Integer> prefixArray) {
    
    this.prefixArray = prefixArray;
    return this;
  }

  public XmlItem addPrefixArrayItem(Integer prefixArrayItem) {
    if (this.prefixArray == null) {
      this.prefixArray = new ArrayList<>();
    }
    this.prefixArray.add(prefixArrayItem);
    return this;
  }

  /**
   * Get prefixArray
   * @return prefixArray
   */
  @jakarta.annotation.Nullable

  @JsonProperty(JSON_PROPERTY_PREFIX_ARRAY)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public List<Integer> getPrefixArray() {
    return prefixArray;
  }


  @JsonProperty(JSON_PROPERTY_PREFIX_ARRAY)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setPrefixArray(@jakarta.annotation.Nullable List<Integer> prefixArray) {
    this.prefixArray = prefixArray;
  }

  public XmlItem prefixWrappedArray(@jakarta.annotation.Nullable List<Integer> prefixWrappedArray) {
    
    this.prefixWrappedArray = prefixWrappedArray;
    return this;
  }

  public XmlItem addPrefixWrappedArrayItem(Integer prefixWrappedArrayItem) {
    if (this.prefixWrappedArray == null) {
      this.prefixWrappedArray = new ArrayList<>();
    }
    this.prefixWrappedArray.add(prefixWrappedArrayItem);
    return this;
  }

  /**
   * Get prefixWrappedArray
   * @return prefixWrappedArray
   */
  @jakarta.annotation.Nullable

  @JsonProperty(JSON_PROPERTY_PREFIX_WRAPPED_ARRAY)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public List<Integer> getPrefixWrappedArray() {
    return prefixWrappedArray;
  }


  @JsonProperty(JSON_PROPERTY_PREFIX_WRAPPED_ARRAY)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setPrefixWrappedArray(@jakarta.annotation.Nullable List<Integer> prefixWrappedArray) {
    this.prefixWrappedArray = prefixWrappedArray;
  }

  public XmlItem namespaceString(@jakarta.annotation.Nullable String namespaceString) {
    
    this.namespaceString = namespaceString;
    return this;
  }

  /**
   * Get namespaceString
   * @return namespaceString
   */
  @jakarta.annotation.Nullable

  @JsonProperty(JSON_PROPERTY_NAMESPACE_STRING)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getNamespaceString() {
    return namespaceString;
  }


  @JsonProperty(JSON_PROPERTY_NAMESPACE_STRING)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setNamespaceString(@jakarta.annotation.Nullable String namespaceString) {
    this.namespaceString = namespaceString;
  }

  public XmlItem namespaceNumber(@jakarta.annotation.Nullable BigDecimal namespaceNumber) {
    
    this.namespaceNumber = namespaceNumber;
    return this;
  }

  /**
   * Get namespaceNumber
   * @return namespaceNumber
   */
  @jakarta.annotation.Nullable
  @Valid

  @JsonProperty(JSON_PROPERTY_NAMESPACE_NUMBER)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public BigDecimal getNamespaceNumber() {
    return namespaceNumber;
  }


  @JsonProperty(JSON_PROPERTY_NAMESPACE_NUMBER)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setNamespaceNumber(@jakarta.annotation.Nullable BigDecimal namespaceNumber) {
    this.namespaceNumber = namespaceNumber;
  }

  public XmlItem namespaceInteger(@jakarta.annotation.Nullable Integer namespaceInteger) {
    
    this.namespaceInteger = namespaceInteger;
    return this;
  }

  /**
   * Get namespaceInteger
   * @return namespaceInteger
   */
  @jakarta.annotation.Nullable

  @JsonProperty(JSON_PROPERTY_NAMESPACE_INTEGER)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public Integer getNamespaceInteger() {
    return namespaceInteger;
  }


  @JsonProperty(JSON_PROPERTY_NAMESPACE_INTEGER)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setNamespaceInteger(@jakarta.annotation.Nullable Integer namespaceInteger) {
    this.namespaceInteger = namespaceInteger;
  }

  public XmlItem namespaceBoolean(@jakarta.annotation.Nullable Boolean namespaceBoolean) {
    
    this.namespaceBoolean = namespaceBoolean;
    return this;
  }

  /**
   * Get namespaceBoolean
   * @return namespaceBoolean
   */
  @jakarta.annotation.Nullable

  @JsonProperty(JSON_PROPERTY_NAMESPACE_BOOLEAN)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public Boolean getNamespaceBoolean() {
    return namespaceBoolean;
  }


  @JsonProperty(JSON_PROPERTY_NAMESPACE_BOOLEAN)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setNamespaceBoolean(@jakarta.annotation.Nullable Boolean namespaceBoolean) {
    this.namespaceBoolean = namespaceBoolean;
  }

  public XmlItem namespaceArray(@jakarta.annotation.Nullable List<Integer> namespaceArray) {
    
    this.namespaceArray = namespaceArray;
    return this;
  }

  public XmlItem addNamespaceArrayItem(Integer namespaceArrayItem) {
    if (this.namespaceArray == null) {
      this.namespaceArray = new ArrayList<>();
    }
    this.namespaceArray.add(namespaceArrayItem);
    return this;
  }

  /**
   * Get namespaceArray
   * @return namespaceArray
   */
  @jakarta.annotation.Nullable

  @JsonProperty(JSON_PROPERTY_NAMESPACE_ARRAY)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public List<Integer> getNamespaceArray() {
    return namespaceArray;
  }


  @JsonProperty(JSON_PROPERTY_NAMESPACE_ARRAY)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setNamespaceArray(@jakarta.annotation.Nullable List<Integer> namespaceArray) {
    this.namespaceArray = namespaceArray;
  }

  public XmlItem namespaceWrappedArray(@jakarta.annotation.Nullable List<Integer> namespaceWrappedArray) {
    
    this.namespaceWrappedArray = namespaceWrappedArray;
    return this;
  }

  public XmlItem addNamespaceWrappedArrayItem(Integer namespaceWrappedArrayItem) {
    if (this.namespaceWrappedArray == null) {
      this.namespaceWrappedArray = new ArrayList<>();
    }
    this.namespaceWrappedArray.add(namespaceWrappedArrayItem);
    return this;
  }

  /**
   * Get namespaceWrappedArray
   * @return namespaceWrappedArray
   */
  @jakarta.annotation.Nullable

  @JsonProperty(JSON_PROPERTY_NAMESPACE_WRAPPED_ARRAY)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public List<Integer> getNamespaceWrappedArray() {
    return namespaceWrappedArray;
  }


  @JsonProperty(JSON_PROPERTY_NAMESPACE_WRAPPED_ARRAY)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setNamespaceWrappedArray(@jakarta.annotation.Nullable List<Integer> namespaceWrappedArray) {
    this.namespaceWrappedArray = namespaceWrappedArray;
  }

  public XmlItem prefixNsString(@jakarta.annotation.Nullable String prefixNsString) {
    
    this.prefixNsString = prefixNsString;
    return this;
  }

  /**
   * Get prefixNsString
   * @return prefixNsString
   */
  @jakarta.annotation.Nullable

  @JsonProperty(JSON_PROPERTY_PREFIX_NS_STRING)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getPrefixNsString() {
    return prefixNsString;
  }


  @JsonProperty(JSON_PROPERTY_PREFIX_NS_STRING)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setPrefixNsString(@jakarta.annotation.Nullable String prefixNsString) {
    this.prefixNsString = prefixNsString;
  }

  public XmlItem prefixNsNumber(@jakarta.annotation.Nullable BigDecimal prefixNsNumber) {
    
    this.prefixNsNumber = prefixNsNumber;
    return this;
  }

  /**
   * Get prefixNsNumber
   * @return prefixNsNumber
   */
  @jakarta.annotation.Nullable
  @Valid

  @JsonProperty(JSON_PROPERTY_PREFIX_NS_NUMBER)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public BigDecimal getPrefixNsNumber() {
    return prefixNsNumber;
  }


  @JsonProperty(JSON_PROPERTY_PREFIX_NS_NUMBER)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setPrefixNsNumber(@jakarta.annotation.Nullable BigDecimal prefixNsNumber) {
    this.prefixNsNumber = prefixNsNumber;
  }

  public XmlItem prefixNsInteger(@jakarta.annotation.Nullable Integer prefixNsInteger) {
    
    this.prefixNsInteger = prefixNsInteger;
    return this;
  }

  /**
   * Get prefixNsInteger
   * @return prefixNsInteger
   */
  @jakarta.annotation.Nullable

  @JsonProperty(JSON_PROPERTY_PREFIX_NS_INTEGER)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public Integer getPrefixNsInteger() {
    return prefixNsInteger;
  }


  @JsonProperty(JSON_PROPERTY_PREFIX_NS_INTEGER)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setPrefixNsInteger(@jakarta.annotation.Nullable Integer prefixNsInteger) {
    this.prefixNsInteger = prefixNsInteger;
  }

  public XmlItem prefixNsBoolean(@jakarta.annotation.Nullable Boolean prefixNsBoolean) {
    
    this.prefixNsBoolean = prefixNsBoolean;
    return this;
  }

  /**
   * Get prefixNsBoolean
   * @return prefixNsBoolean
   */
  @jakarta.annotation.Nullable

  @JsonProperty(JSON_PROPERTY_PREFIX_NS_BOOLEAN)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public Boolean getPrefixNsBoolean() {
    return prefixNsBoolean;
  }


  @JsonProperty(JSON_PROPERTY_PREFIX_NS_BOOLEAN)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setPrefixNsBoolean(@jakarta.annotation.Nullable Boolean prefixNsBoolean) {
    this.prefixNsBoolean = prefixNsBoolean;
  }

  public XmlItem prefixNsArray(@jakarta.annotation.Nullable List<Integer> prefixNsArray) {
    
    this.prefixNsArray = prefixNsArray;
    return this;
  }

  public XmlItem addPrefixNsArrayItem(Integer prefixNsArrayItem) {
    if (this.prefixNsArray == null) {
      this.prefixNsArray = new ArrayList<>();
    }
    this.prefixNsArray.add(prefixNsArrayItem);
    return this;
  }

  /**
   * Get prefixNsArray
   * @return prefixNsArray
   */
  @jakarta.annotation.Nullable

  @JsonProperty(JSON_PROPERTY_PREFIX_NS_ARRAY)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public List<Integer> getPrefixNsArray() {
    return prefixNsArray;
  }


  @JsonProperty(JSON_PROPERTY_PREFIX_NS_ARRAY)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setPrefixNsArray(@jakarta.annotation.Nullable List<Integer> prefixNsArray) {
    this.prefixNsArray = prefixNsArray;
  }

  public XmlItem prefixNsWrappedArray(@jakarta.annotation.Nullable List<Integer> prefixNsWrappedArray) {
    
    this.prefixNsWrappedArray = prefixNsWrappedArray;
    return this;
  }

  public XmlItem addPrefixNsWrappedArrayItem(Integer prefixNsWrappedArrayItem) {
    if (this.prefixNsWrappedArray == null) {
      this.prefixNsWrappedArray = new ArrayList<>();
    }
    this.prefixNsWrappedArray.add(prefixNsWrappedArrayItem);
    return this;
  }

  /**
   * Get prefixNsWrappedArray
   * @return prefixNsWrappedArray
   */
  @jakarta.annotation.Nullable

  @JsonProperty(JSON_PROPERTY_PREFIX_NS_WRAPPED_ARRAY)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public List<Integer> getPrefixNsWrappedArray() {
    return prefixNsWrappedArray;
  }


  @JsonProperty(JSON_PROPERTY_PREFIX_NS_WRAPPED_ARRAY)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setPrefixNsWrappedArray(@jakarta.annotation.Nullable List<Integer> prefixNsWrappedArray) {
    this.prefixNsWrappedArray = prefixNsWrappedArray;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    XmlItem xmlItem = (XmlItem) o;
    return Objects.equals(this.attributeString, xmlItem.attributeString) &&
        Objects.equals(this.attributeNumber, xmlItem.attributeNumber) &&
        Objects.equals(this.attributeInteger, xmlItem.attributeInteger) &&
        Objects.equals(this.attributeBoolean, xmlItem.attributeBoolean) &&
        Objects.equals(this.wrappedArray, xmlItem.wrappedArray) &&
        Objects.equals(this.nameString, xmlItem.nameString) &&
        Objects.equals(this.nameNumber, xmlItem.nameNumber) &&
        Objects.equals(this.nameInteger, xmlItem.nameInteger) &&
        Objects.equals(this.nameBoolean, xmlItem.nameBoolean) &&
        Objects.equals(this.nameArray, xmlItem.nameArray) &&
        Objects.equals(this.nameWrappedArray, xmlItem.nameWrappedArray) &&
        Objects.equals(this.prefixString, xmlItem.prefixString) &&
        Objects.equals(this.prefixNumber, xmlItem.prefixNumber) &&
        Objects.equals(this.prefixInteger, xmlItem.prefixInteger) &&
        Objects.equals(this.prefixBoolean, xmlItem.prefixBoolean) &&
        Objects.equals(this.prefixArray, xmlItem.prefixArray) &&
        Objects.equals(this.prefixWrappedArray, xmlItem.prefixWrappedArray) &&
        Objects.equals(this.namespaceString, xmlItem.namespaceString) &&
        Objects.equals(this.namespaceNumber, xmlItem.namespaceNumber) &&
        Objects.equals(this.namespaceInteger, xmlItem.namespaceInteger) &&
        Objects.equals(this.namespaceBoolean, xmlItem.namespaceBoolean) &&
        Objects.equals(this.namespaceArray, xmlItem.namespaceArray) &&
        Objects.equals(this.namespaceWrappedArray, xmlItem.namespaceWrappedArray) &&
        Objects.equals(this.prefixNsString, xmlItem.prefixNsString) &&
        Objects.equals(this.prefixNsNumber, xmlItem.prefixNsNumber) &&
        Objects.equals(this.prefixNsInteger, xmlItem.prefixNsInteger) &&
        Objects.equals(this.prefixNsBoolean, xmlItem.prefixNsBoolean) &&
        Objects.equals(this.prefixNsArray, xmlItem.prefixNsArray) &&
        Objects.equals(this.prefixNsWrappedArray, xmlItem.prefixNsWrappedArray);
  }

  @Override
  public int hashCode() {
    return Objects.hash(attributeString, attributeNumber, attributeInteger, attributeBoolean, wrappedArray, nameString, nameNumber, nameInteger, nameBoolean, nameArray, nameWrappedArray, prefixString, prefixNumber, prefixInteger, prefixBoolean, prefixArray, prefixWrappedArray, namespaceString, namespaceNumber, namespaceInteger, namespaceBoolean, namespaceArray, namespaceWrappedArray, prefixNsString, prefixNsNumber, prefixNsInteger, prefixNsBoolean, prefixNsArray, prefixNsWrappedArray);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class XmlItem {\n");
    sb.append("    attributeString: ").append(toIndentedString(attributeString)).append("\n");
    sb.append("    attributeNumber: ").append(toIndentedString(attributeNumber)).append("\n");
    sb.append("    attributeInteger: ").append(toIndentedString(attributeInteger)).append("\n");
    sb.append("    attributeBoolean: ").append(toIndentedString(attributeBoolean)).append("\n");
    sb.append("    wrappedArray: ").append(toIndentedString(wrappedArray)).append("\n");
    sb.append("    nameString: ").append(toIndentedString(nameString)).append("\n");
    sb.append("    nameNumber: ").append(toIndentedString(nameNumber)).append("\n");
    sb.append("    nameInteger: ").append(toIndentedString(nameInteger)).append("\n");
    sb.append("    nameBoolean: ").append(toIndentedString(nameBoolean)).append("\n");
    sb.append("    nameArray: ").append(toIndentedString(nameArray)).append("\n");
    sb.append("    nameWrappedArray: ").append(toIndentedString(nameWrappedArray)).append("\n");
    sb.append("    prefixString: ").append(toIndentedString(prefixString)).append("\n");
    sb.append("    prefixNumber: ").append(toIndentedString(prefixNumber)).append("\n");
    sb.append("    prefixInteger: ").append(toIndentedString(prefixInteger)).append("\n");
    sb.append("    prefixBoolean: ").append(toIndentedString(prefixBoolean)).append("\n");
    sb.append("    prefixArray: ").append(toIndentedString(prefixArray)).append("\n");
    sb.append("    prefixWrappedArray: ").append(toIndentedString(prefixWrappedArray)).append("\n");
    sb.append("    namespaceString: ").append(toIndentedString(namespaceString)).append("\n");
    sb.append("    namespaceNumber: ").append(toIndentedString(namespaceNumber)).append("\n");
    sb.append("    namespaceInteger: ").append(toIndentedString(namespaceInteger)).append("\n");
    sb.append("    namespaceBoolean: ").append(toIndentedString(namespaceBoolean)).append("\n");
    sb.append("    namespaceArray: ").append(toIndentedString(namespaceArray)).append("\n");
    sb.append("    namespaceWrappedArray: ").append(toIndentedString(namespaceWrappedArray)).append("\n");
    sb.append("    prefixNsString: ").append(toIndentedString(prefixNsString)).append("\n");
    sb.append("    prefixNsNumber: ").append(toIndentedString(prefixNsNumber)).append("\n");
    sb.append("    prefixNsInteger: ").append(toIndentedString(prefixNsInteger)).append("\n");
    sb.append("    prefixNsBoolean: ").append(toIndentedString(prefixNsBoolean)).append("\n");
    sb.append("    prefixNsArray: ").append(toIndentedString(prefixNsArray)).append("\n");
    sb.append("    prefixNsWrappedArray: ").append(toIndentedString(prefixNsWrappedArray)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }

}

