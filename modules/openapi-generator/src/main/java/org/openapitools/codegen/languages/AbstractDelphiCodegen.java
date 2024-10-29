/*
 * Copyright 2018 OpenAPI-Generator Contributors (https://openapi-generator.tech)
 * Copyright 2018 SmartBear Software
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.openapitools.codegen.languages;

import com.google.common.collect.ImmutableMap.Builder;
import com.samskivert.mustache.Mustache.Lambda;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.media.Schema;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.servers.Server;
import io.swagger.v3.oas.models.servers.ServerVariables;
import io.swagger.v3.oas.models.servers.ServerVariable;
import org.openapitools.codegen.*;
import org.openapitools.codegen.model.ModelsMap;

import org.openapitools.codegen.templating.mustache.IndentedLambda;
import org.openapitools.codegen.utils.URLPathUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;
import java.net.URL;

import static org.openapitools.codegen.utils.CamelizeOption.LOWERCASE_FIRST_CHAR;
import static org.openapitools.codegen.utils.CamelizeOption.UPPERCASE_FIRST_CHAR;
import static org.openapitools.codegen.utils.StringUtils.camelize;
import static org.openapitools.codegen.utils.StringUtils.underscore;
import org.openapitools.codegen.utils.CamelizeOption;

abstract public class AbstractDelphiCodegen extends DefaultCodegen implements CodegenConfig {
    protected Map<String, String> nullTypeMapping;
    private final Logger LOGGER = LoggerFactory.getLogger(AbstractDelphiCodegen.class);

    protected static final String RESERVED_WORD_PREFIX_OPTION = "reservedWordPrefix";
    protected static final String RESERVED_WORD_PREFIX_DESC = "Prefix to prepend to reserved words in order to avoid conflicts";
    protected String reservedWordPrefix = "&";
    protected String programName = "app";
    protected static final String VARIABLE_NAME_FIRST_CHARACTER_UPPERCASE_OPTION = "variableNameFirstCharacterUppercase";
    protected static final String VARIABLE_NAME_FIRST_CHARACTER_UPPERCASE_DESC = "Make first character of variable name uppercase (eg. value -> Value)";
    protected boolean variableNameFirstCharacterUppercase = false;
    protected String sanitizedParamPrefixToSkip = "";
    public static final String SANITIZED_PARAM_PREFIX_TO_SKIP_OPTION = "sanitizedParamPrefixToSkip";
    public static final String SANITIZED_PARAM_PREFIX_TO_SKIP_DESC = "sanitized param prefix to skip";
    public static final String VARIABLE_CONVERT_UNDERSCORE_TO_CAMEL_CASE_OPTION = "variableConvertUnderscoreToCamelCase";
    public static final String VARIABLE_CONVERT_UNDERSCORE_TO_CAMEL_CASE_DESC = "convert underscore to camel case";
    protected boolean variableConvertUnderscoreToCamelCase = false;

    protected Set<String> languageSpecificTypes = new HashSet<String>();

    public AbstractDelphiCodegen() {
        super();

        languageSpecificPrimitives = new HashSet<String>(
                Arrays.asList(
                        "AnsiChar",
                        "AnsiString",
                        "array",
                        "boolean",
                        "Byte",
                        "ByteBool",
                        "Cardinal",
                        "Char",
                        "Comp",
                        "Currency",
                        "Double",
                        "Extended",
                        "FixedInt",
                        "FixedUInt",
                        "Int64",
                        "Integer",
                        "LongBool",
                        "LongInt",
                        "LongWord",
                        "NativeInt",
                        "NativeUInt",
                        "object",
                        "Real",
                        "Real48",
                        "ShortInt",
                        "ShortString",
                        "string",
                        "Single",
                        "SmallInt",
                        "UCS2Char",
                        "UCS4Char",
                        "UInt64",
                        "UnicodeString",
                        "WideChar",
                        "WideString",
                        "Word",
                        "WordBool",
                        "TDateTime"));

        languageSpecificTypes = new HashSet<String>(Arrays.asList("TStream", "TExtInfo"));

        /*
         * Reserved words. Override this with reserved words specific to your language
         */
        setReservedWordsLowerCase(
                Arrays.asList(
                        "and",
                        "array",
                        "as",
                        "asm",
                        "begin",
                        "case",
                        "class",
                        "const",
                        "constructor",
                        "destructor",
                        "dispinterface",
                        "div",
                        "do",
                        "downto",
                        "else",
                        "end",
                        "except",
                        "exports",
                        "file",
                        "finalization",
                        "finally",
                        "for",
                        "function",
                        "goto",
                        "if",
                        "implementation",
                        "in",
                        "inherited",
                        "initialization",
                        "inline",
                        "interface",
                        "is",
                        "label",
                        "library3",
                        "mod",
                        "nil",
                        "not",
                        "object",
                        "of",
                        "or",
                        "packed",
                        "procedure",
                        "program",
                        "property",
                        "raise",
                        "record",
                        "repeat",
                        "resourcestring",
                        "set",
                        "shl",
                        "shr",
                        "string",
                        "then",
                        "threadvar",
                        "to",
                        "try",
                        "type",
                        "unit",
                        "until",
                        "uses",
                        "var",
                        "while",
                        "with",
                        "xor"));

        addOption(RESERVED_WORD_PREFIX_OPTION,
                RESERVED_WORD_PREFIX_DESC,
                this.reservedWordPrefix);
        addOption(VARIABLE_NAME_FIRST_CHARACTER_UPPERCASE_OPTION,
                VARIABLE_NAME_FIRST_CHARACTER_UPPERCASE_DESC,
                Boolean.toString(this.variableNameFirstCharacterUppercase));
        addOption(SANITIZED_PARAM_PREFIX_TO_SKIP_OPTION, SANITIZED_PARAM_PREFIX_TO_SKIP_DESC,
                String.valueOf(this.sanitizedParamPrefixToSkip));
        addOption(VARIABLE_CONVERT_UNDERSCORE_TO_CAMEL_CASE_OPTION,
                VARIABLE_CONVERT_UNDERSCORE_TO_CAMEL_CASE_DESC,
                Boolean.toString(this.variableConvertUnderscoreToCamelCase));
    }

    protected void MyProcessProperty(CodegenProperty property) {
        String camelName = camelize(property.baseName);

        Boolean isEnum = false;
        String nameInCamelCase = property.nameInCamelCase;
        if (isReservedWord(nameInCamelCase) || nameInCamelCase.matches("^\\d.*")) {
            nameInCamelCase = escapeReservedWord(nameInCamelCase);
        }
        String propName = property.name;
        if (isReservedWord(propName) || propName.matches("^\\d.*")) {
            propName = escapeReservedWord(propName);
        }

        if (this.variableConvertUnderscoreToCamelCase) {
            propName = camelize(propName, LOWERCASE_FIRST_CHAR);
        }

        if (this.variableNameFirstCharacterUppercase){
            propName = (Character.toUpperCase(propName.charAt(0)) + propName.substring(1));
        }
        property.nameInCamelCase = nameInCamelCase;
        property.name = propName;
        property.vendorExtensions.put("x-delphi-field-name", "F" + camelName);
        property.vendorExtensions.put("x-delphi-property-name", property.nameInCamelCase);
        property.vendorExtensions.put("x-delphi-getter-name", "get" + camelName);
        property.vendorExtensions.put("x-delphi-setter-name", "set" + camelName);
        property.vendorExtensions.put("x-delphi-camel-name",  camelName);
        isEnum = property.isEnum || (property.allowableValues != null && property.allowableValues.size() > 0);
        property.vendorExtensions.put("x-delphi-enum", isEnum);

        if (nullTypeMapping.containsKey(property.baseType)) {
            property.vendorExtensions.put("x-delphi-nullable-type", nullTypeMapping.get(property.baseType));
        } else if (isEnum) {
            property.vendorExtensions.put("x-delphi-nullable-type", property.dataType);
        }

        if (property.isArray && property.items != null && property.items.isModel) {
            property.dataType = "TObjectList<" + getTypeDeclaration(property.items.baseType) + ">";

        }

        if (!property.isPrimitiveType
                && !nullTypeMapping.values().contains(property.baseType)
                && !property.isModel
                && !(property.isEnum || (property.allowableValues != null && property.allowableValues.size() > 0))) {
            property.isModel = true;
        }

    }


    @Override
    public String escapeQuotationMark(String input) {
        // remove " to avoid code injection
        return input.replace("\"", "");
    }

    @Override
    public String escapeUnsafeCharacters(String input) {
        return input.replace("*/", "*_/").replace("/*", "/_*");
    }

    @Override
    public String toApiName(String type) {
        return sanitizeName(modelNamePrefix + super.toApiName(type));
    }

    protected String clearText(String words) {
        ArrayList<String> w = new ArrayList<>();
        for (String word : words.split(" ")) {
            w.add(word);
        }
        return String.join("", w);
    }

    @Override
    public String toModelName(String type) {
        String modelName = "";
        if (type == null) {
            LOGGER.warn("Model name can't be null. Default to 'UnknownModel'.");
            type = "UnknownModel";
        }

        if (typeMapping.keySet().contains(type)
                || typeMapping.values().contains(type)
                || importMapping.values().contains(type)
                || defaultIncludes.contains(type)
                || languageSpecificPrimitives.contains(type)
                || nullTypeMapping.values().contains(type)) {
            return type;
        } else {
            modelName = sanitizeName(modelNamePrefix + Character.toUpperCase(type.charAt(0)) + type.substring(1));
            if (this.variableConvertUnderscoreToCamelCase){
               return camelize(modelName);
            }
            else {
                return modelName;
            }
        }
    }

    @Override
    public String toVarName(String name) {
        if (typeMapping.keySet().contains(name) || typeMapping.values().contains(name)
                || importMapping.values().contains(name) || defaultIncludes.contains(name)
                || languageSpecificPrimitives.contains(name)) {
            return sanitizeName(name);
        }

        if (isReservedWord(name) || name.matches("^\\d.*")) {
            return escapeReservedWord(name);
        }

        if (variableNameFirstCharacterUppercase && name.length() > 1) {
            return sanitizeName(Character.toUpperCase(name.charAt(0)) + name.substring(1));
        }

        return sanitizeName(name);
    }

    /**
     * Escapes a reserved word as defined in the `reservedWords` array. Handle
     * escaping those terms here. This logic is only called if a variable
     * matches the reserved words
     *
     * @return the escaped term
     */
    @Override
    public String escapeReservedWord(String name) {
        if (this.reservedWordsMappings().containsKey(name)) {
            return this.reservedWordsMappings().get(name);
        }
        return reservedWordPrefix + sanitizeName(name);
    }

    @Override
    public String toOperationId(String operationId) {
        if (isReservedWord(operationId)) {
            LOGGER.warn("{} (reserved word) cannot be used as method name. Renamed to {}", operationId,
                    escapeReservedWord(operationId));
            return escapeReservedWord(operationId);
        }
        return sanitizeName(super.toOperationId(operationId));
    }

    @Override
    public String toParamName(String name) {
        String paramName = "";
        if (isReservedWord(name) || name.matches("^\\d.*")) {
            paramName = escapeReservedWord(name);
        }

        paramName = sanitizeName(super.toParamName(name));

        if (!sanitizedParamPrefixToSkip.isEmpty() && paramName.startsWith(sanitizedParamPrefixToSkip))
        {
            paramName = paramName.substring(sanitizedParamPrefixToSkip.length());
        }
        return lowerCamelCase(paramName);
    }

    @SuppressWarnings("rawtypes")
    @Override
    public CodegenProperty fromProperty(String name, Schema p) {
        CodegenProperty property = super.fromProperty(name, p);
        MyProcessProperty(property);
        return property;
    }

    /**
     * Output the Getter name for boolean property, e.g. isActive
     *
     * @param name the name of the property
     * @return getter name based on naming convention
     */
    @Override
    public String toBooleanGetter(String name) {
        return "is" + getterAndSetterCapitalize(name);
    }

    @Override
    public String getTypeDeclaration(String str) {
        return "std::shared_ptr<" + toModelName(str) + ">";
    }

    @Override
    public void processOpts() {
        super.processOpts();

        if (additionalProperties.containsKey(RESERVED_WORD_PREFIX_OPTION)) {
            reservedWordPrefix = (String) additionalProperties.get(RESERVED_WORD_PREFIX_OPTION);
        }
        additionalProperties.put(RESERVED_WORD_PREFIX_OPTION, reservedWordPrefix);

        if (additionalProperties.containsKey(VARIABLE_NAME_FIRST_CHARACTER_UPPERCASE_OPTION))
            variableNameFirstCharacterUppercase = convertPropertyToBooleanAndWriteBack(
                    VARIABLE_NAME_FIRST_CHARACTER_UPPERCASE_OPTION);
        additionalProperties.put(VARIABLE_NAME_FIRST_CHARACTER_UPPERCASE_OPTION, variableNameFirstCharacterUppercase);

        if (additionalProperties.containsKey(SANITIZED_PARAM_PREFIX_TO_SKIP_OPTION))
            sanitizedParamPrefixToSkip =  (String) additionalProperties.get(SANITIZED_PARAM_PREFIX_TO_SKIP_OPTION);
        additionalProperties.put(SANITIZED_PARAM_PREFIX_TO_SKIP_OPTION, sanitizedParamPrefixToSkip);

        if (additionalProperties.containsKey(VARIABLE_CONVERT_UNDERSCORE_TO_CAMEL_CASE_OPTION))
            variableConvertUnderscoreToCamelCase = convertPropertyToBooleanAndWriteBack(
                    VARIABLE_CONVERT_UNDERSCORE_TO_CAMEL_CASE_OPTION);
        additionalProperties.put(VARIABLE_CONVERT_UNDERSCORE_TO_CAMEL_CASE_OPTION, variableConvertUnderscoreToCamelCase);
    }

    @Override
    protected Builder<String, Lambda> addMustacheLambdas() {
        return super.addMustacheLambdas()
                .put("multiline_comment_4", new IndentedLambda(4, "///", true, false));
    }

    @Override
    public void preprocessOpenAPI(OpenAPI openAPI) {
        List<Server> serverList = openAPI.getServers();
        List<CodegenServer> CodegenServerList = new ArrayList<CodegenServer>();
        URL url = URLPathUtils.getServerURL(openAPI, serverVariableOverrides());
        String port = URLPathUtils.getPort(url, "");
        String host = url.getHost();
        String scheme = url.getProtocol();

        if (!port.isEmpty()) {
            this.additionalProperties.put("serverPort", port);
        }
        if (!host.isEmpty()) {
            this.additionalProperties.put("serverHost", host);
        }
        if (!scheme.isEmpty()) {
            this.additionalProperties.put("scheme", scheme);
        }
        if (!serverList.isEmpty()) {
            for (Server server : serverList) {
                CodegenServer s = new CodegenServer();
                s.description = server.getDescription();
                s.url = server.getUrl();
                s.variables = new ArrayList<CodegenServerVariable>();
                ServerVariables serverVars = server.getVariables();
                if (serverVars != null) {
                    serverVars.forEach((key, value) -> {
                        CodegenServerVariable codegenServerVar = new CodegenServerVariable();
                        ServerVariable ServerVar = value;
                        codegenServerVar.name = key;
                        codegenServerVar.description = ServerVar.getDescription();
                        codegenServerVar.defaultValue = ServerVar.getDefault();
                        codegenServerVar.enumValues = ServerVar.getEnum();
                        s.variables.add(codegenServerVar);
                    });
                }
                CodegenServerList.add(s);
            }
            this.vendorExtensions.put("x-delphi-global-server-list", CodegenServerList);
        }
        Info info = openAPI.getInfo();
        if (info.getTitle() != null) {
            // default to the appName (from title field)
            this.programName = clearText(escapeText(info.getTitle()));
        }
        additionalProperties.put("programName", this.programName);
    }

    @Override
    @SuppressWarnings("unchecked")
    public ModelsMap postProcessModels(ModelsMap objs) {
        List<Object> models = (List<Object>) objs.get("models");
        for (Object _mo : models) {
            Map<String, Object> mo = (Map<String, Object>) _mo;
            CodegenModel cm = (CodegenModel) mo.get("model");
            // cannot handle inheritance from maps and arrays in C++
            if ((cm.isArray || cm.isMap) && (cm.parentModel == null)) {
                cm.parent = null;
            }
            if (cm.isArray) {
                CodegenProperty items = cm.getItems();
                if (items != null) {
                    cm.dataType = (items.isModel ? "TObjectList" : "TList") + "<" + getTypeDeclaration(items.baseType)
                            + ">";

                }
                cm.setIsModel(false);
            }
        }
        return postProcessModelsEnum(objs);
    }

    @Override
    @SuppressWarnings("unused")
    public void postProcessModelProperty(CodegenModel model, CodegenProperty property) {
        super.postProcessModelProperty(model, property);

        MyProcessProperty(property);
    }

}
