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
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.openapitools.client.JSON;

/**
 * EnumArrays
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen")
public class EnumArrays {
  /**
   * Gets or Sets justSymbol
   */
  @JsonAdapter(JustSymbolEnum.Adapter.class)
  public enum JustSymbolEnum {
    GREATER_THAN_OR_EQUAL_TO(">="),
    
    DOLLAR("$");

    private String value;

    JustSymbolEnum(String value) {
      this.value = value;
    }

    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    public static JustSymbolEnum fromValue(String value) {
      for (JustSymbolEnum b : JustSymbolEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }

    public static class Adapter extends TypeAdapter<JustSymbolEnum> {
      @Override
      public void write(final JsonWriter jsonWriter, final JustSymbolEnum enumeration) throws IOException {
        jsonWriter.value(enumeration.getValue());
      }

      @Override
      public JustSymbolEnum read(final JsonReader jsonReader) throws IOException {
        String value =  jsonReader.nextString();
        return JustSymbolEnum.fromValue(value);
      }
    }
  }

  public static final String SERIALIZED_NAME_JUST_SYMBOL = "just_symbol";
  @SerializedName(SERIALIZED_NAME_JUST_SYMBOL)
  private JustSymbolEnum justSymbol;

  /**
   * Gets or Sets arrayEnum
   */
  @JsonAdapter(ArrayEnumEnum.Adapter.class)
  public enum ArrayEnumEnum {
    FISH("fish"),
    
    CRAB("crab");

    private String value;

    ArrayEnumEnum(String value) {
      this.value = value;
    }

    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    public static ArrayEnumEnum fromValue(String value) {
      for (ArrayEnumEnum b : ArrayEnumEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }

    public static class Adapter extends TypeAdapter<ArrayEnumEnum> {
      @Override
      public void write(final JsonWriter jsonWriter, final ArrayEnumEnum enumeration) throws IOException {
        jsonWriter.value(enumeration.getValue());
      }

      @Override
      public ArrayEnumEnum read(final JsonReader jsonReader) throws IOException {
        String value =  jsonReader.nextString();
        return ArrayEnumEnum.fromValue(value);
      }
    }
  }

  public static final String SERIALIZED_NAME_ARRAY_ENUM = "array_enum";
  @SerializedName(SERIALIZED_NAME_ARRAY_ENUM)
  private List<ArrayEnumEnum> arrayEnum;

  public EnumArrays() {
  }

  public EnumArrays justSymbol(JustSymbolEnum justSymbol) {
    
    this.justSymbol = justSymbol;
    return this;
  }

   /**
   * Get justSymbol
   * @return justSymbol
  **/
  @javax.annotation.Nullable

  public JustSymbolEnum getJustSymbol() {
    return justSymbol;
  }


  public void setJustSymbol(JustSymbolEnum justSymbol) {
    this.justSymbol = justSymbol;
  }


  public EnumArrays arrayEnum(List<ArrayEnumEnum> arrayEnum) {
    
    this.arrayEnum = arrayEnum;
    return this;
  }

  public EnumArrays addArrayEnumItem(ArrayEnumEnum arrayEnumItem) {
    if (this.arrayEnum == null) {
      this.arrayEnum = new ArrayList<>();
    }
    this.arrayEnum.add(arrayEnumItem);
    return this;
  }

   /**
   * Get arrayEnum
   * @return arrayEnum
  **/
  @javax.annotation.Nullable

  public List<ArrayEnumEnum> getArrayEnum() {
    return arrayEnum;
  }


  public void setArrayEnum(List<ArrayEnumEnum> arrayEnum) {
    this.arrayEnum = arrayEnum;
  }



  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    EnumArrays enumArrays = (EnumArrays) o;
    return Objects.equals(this.justSymbol, enumArrays.justSymbol) &&
        Objects.equals(this.arrayEnum, enumArrays.arrayEnum);
  }

  @Override
  public int hashCode() {
    return Objects.hash(justSymbol, arrayEnum);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class EnumArrays {\n");
    sb.append("    justSymbol: ").append(toIndentedString(justSymbol)).append("\n");
    sb.append("    arrayEnum: ").append(toIndentedString(arrayEnum)).append("\n");
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


  public static HashSet<String> openapiFields;
  public static HashSet<String> openapiRequiredFields;

  static {
    // a set of all properties/fields (JSON key names)
    openapiFields = new HashSet<String>();
    openapiFields.add("just_symbol");
    openapiFields.add("array_enum");

    // a set of required properties/fields (JSON key names)
    openapiRequiredFields = new HashSet<String>();
  }

 /**
  * Validates the JSON Object and throws an exception if issues found
  *
  * @param jsonObj JSON Object
  * @throws IOException if the JSON Object is invalid with respect to EnumArrays
  */
  public static void validateJsonObject(JsonObject jsonObj) throws IOException {
      if (jsonObj == null) {
        if (!EnumArrays.openapiRequiredFields.isEmpty()) { // has required fields but JSON object is null
          throw new IllegalArgumentException(String.format("The required field(s) %s in EnumArrays is not found in the empty JSON string", EnumArrays.openapiRequiredFields.toString()));
        }
      }

      Set<Entry<String, JsonElement>> entries = jsonObj.entrySet();
      // check to see if the JSON string contains additional fields
      for (Entry<String, JsonElement> entry : entries) {
        if (!EnumArrays.openapiFields.contains(entry.getKey())) {
          throw new IllegalArgumentException(String.format("The field `%s` in the JSON string is not defined in the `EnumArrays` properties. JSON: %s", entry.getKey(), jsonObj.toString()));
        }
      }
      if ((jsonObj.get("just_symbol") != null && !jsonObj.get("just_symbol").isJsonNull()) && !jsonObj.get("just_symbol").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `just_symbol` to be a primitive type in the JSON string but got `%s`", jsonObj.get("just_symbol").toString()));
      }
      // ensure the optional json data is an array if present
      if (jsonObj.get("array_enum") != null && !jsonObj.get("array_enum").isJsonArray()) {
        throw new IllegalArgumentException(String.format("Expected the field `array_enum` to be an array in the JSON string but got `%s`", jsonObj.get("array_enum").toString()));
      }
  }

  public static class CustomTypeAdapterFactory implements TypeAdapterFactory {
    @SuppressWarnings("unchecked")
    @Override
    public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> type) {
       if (!EnumArrays.class.isAssignableFrom(type.getRawType())) {
         return null; // this class only serializes 'EnumArrays' and its subtypes
       }
       final TypeAdapter<JsonElement> elementAdapter = gson.getAdapter(JsonElement.class);
       final TypeAdapter<EnumArrays> thisAdapter
                        = gson.getDelegateAdapter(this, TypeToken.get(EnumArrays.class));

       return (TypeAdapter<T>) new TypeAdapter<EnumArrays>() {
           @Override
           public void write(JsonWriter out, EnumArrays value) throws IOException {
             JsonObject obj = thisAdapter.toJsonTree(value).getAsJsonObject();
             elementAdapter.write(out, obj);
           }

           @Override
           public EnumArrays read(JsonReader in) throws IOException {
             JsonObject jsonObj = elementAdapter.read(in).getAsJsonObject();
             validateJsonObject(jsonObj);
             return thisAdapter.fromJsonTree(jsonObj);
           }

       }.nullSafe();
    }
  }

 /**
  * Create an instance of EnumArrays given an JSON string
  *
  * @param jsonString JSON string
  * @return An instance of EnumArrays
  * @throws IOException if the JSON string is invalid with respect to EnumArrays
  */
  public static EnumArrays fromJson(String jsonString) throws IOException {
    return JSON.getGson().fromJson(jsonString, EnumArrays.class);
  }

 /**
  * Convert an instance of EnumArrays to an JSON string
  *
  * @return JSON string
  */
  public String toJson() {
    return JSON.getGson().toJson(this);
  }
}

