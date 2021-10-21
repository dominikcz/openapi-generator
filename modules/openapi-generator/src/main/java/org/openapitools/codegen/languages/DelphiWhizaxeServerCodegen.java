package org.openapitools.codegen.languages;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.Operation;
import io.swagger.v3.oas.models.media.ArraySchema;
import io.swagger.v3.oas.models.media.Schema;
import io.swagger.v3.oas.models.responses.ApiResponse;
import io.swagger.v3.oas.models.servers.Server;
import org.apache.commons.lang3.StringUtils;
import org.openapitools.codegen.*;
import org.openapitools.codegen.meta.features.*;
import org.openapitools.codegen.utils.ModelUtils;
import io.swagger.models.properties.ArrayProperty;
import io.swagger.models.properties.MapProperty;
import io.swagger.models.properties.Property;
import io.swagger.models.parameters.Parameter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.util.*;

import static org.openapitools.codegen.utils.StringUtils.underscore;
import static org.openapitools.codegen.utils.StringUtils.camelize;

public class DelphiWhizaxeServerCodegen extends AbstractDelphiCodegen {
    protected String modelType = "properties"; // properties/files - must match template file name!
    protected String modelFilenamePrefix = "ApiModel.";
    public static final String PROJECT_NAME = "projectName";
    public static final String OPTION_MODEL_TYPE = "fields";
    public static final String OPTION_MODEL_TYPE_DESC = "type of model to use";
    public static final String OPTION_MODEL_FILENAME_PREFIX = "modelFilenamePrefix";
    public static final String OPTION_MODEL_FILENAME_PREFIX_DESC = "Prefix of model filename";

    static final Logger LOGGER = LoggerFactory.getLogger(DelphiWhizaxeServerCodegen.class);
    protected final String PREFIX = "";

    protected Set<String> usedModels = new HashSet<>();

    @Override
    public CodegenType getTag() {
        return CodegenType.SERVER;
    }

    @Override
    public String getName() {
        return "delphi-whizaxe";
    }

    @Override
    public String getHelp() {
        return "Generates a delphi-whizaxe server.";
    }

    public DelphiWhizaxeServerCodegen() {
        super();

        addOption(CodegenConstants.MODEL_NAME_PREFIX, CodegenConstants.MODEL_NAME_PREFIX_DESC, " ");

        outputFolder = "generated-code" + File.separator + "delphi-whizaxe";
        apiTemplateFiles.put("api-interface.mustache", ".pas");
        apiTemplateFiles.put("api-rest.mustache", ".pas");
        apiTemplateFiles.put("api-pas.mustache", ".pas");
        apiTemplateFiles.put("api-default.mustache", ".default");
        embeddedTemplateDir = templateDir = "delphi-whizaxe";
        apiPackage = "Apis";
        modelPackage = "Models";
        cliOptions.clear();
        addOption(OPTION_MODEL_TYPE, OPTION_MODEL_TYPE_DESC, this.modelType);
        addOption(VARIABLE_NAME_FIRST_CHARACTER_UPPERCASE_OPTION,
                VARIABLE_NAME_FIRST_CHARACTER_UPPERCASE_DESC,
                Boolean.toString(this.variableNameFirstCharacterUppercase));
        addOption(OPTION_MODEL_FILENAME_PREFIX, OPTION_MODEL_FILENAME_PREFIX_DESC, this.modelFilenamePrefix);
        typeMapping = new HashMap<String, String>();
        typeMapping.put("date", "TDateTime");
        typeMapping.put("DateTime", "TDateTime");
        typeMapping.put("long", "Cardinal");
        typeMapping.put("array", "TObjectList");
        typeMapping.put("map", "TDictionary");
        typeMapping.put("set", "TList");
        typeMapping.put("file", "TStream");
        typeMapping.put("object", "TExtInfo");
        typeMapping.put("binary", "TBytes");
        typeMapping.put("number", "Currency");
        typeMapping.put("UUID", "string");
        typeMapping.put("URI", "string");
        typeMapping.put("ByteArray", "TBytes");
        typeMapping.put("BigDecimal", "Currency");

        super.importMapping = new HashMap<String, String>();
        importMapping.put("TList", "Generics.Collections");
        importMapping.put("TObjectList", "Generics.Collections");
        importMapping.put("TDictionary", "Generics.Collections");
        importMapping.put("TObjectDictionary", "Generics.Collections");
        importMapping.put("TStream", "System.Classes");
	}
    
    @Override
    public void processOpts() {
        super.processOpts();
        if (additionalProperties.containsKey(OPTION_MODEL_FILENAME_PREFIX)) {
            this.modelFilenamePrefix = (String) additionalProperties.get(OPTION_MODEL_FILENAME_PREFIX);
        }
        if (additionalProperties.containsKey("modelNamePrefix")) {
            additionalProperties().put("prefix", modelNamePrefix);
        }
        if (additionalProperties.containsKey(RESERVED_WORD_PREFIX_OPTION)) {
            reservedWordPrefix = (String) additionalProperties.get(RESERVED_WORD_PREFIX_OPTION);
        }

//        additionalProperties.put("modelNamespaceDeclarations", modelPackage.split("\\."));
//        additionalProperties.put("modelNamespace", modelPackage.replaceAll("\\.", "::"));
        additionalProperties.put("apiNamespaceDeclarations", apiPackage.split("\\."));
        additionalProperties.put("apiNamespace", apiPackage.replaceAll("\\.", "::"));
        additionalProperties.put(RESERVED_WORD_PREFIX_OPTION, reservedWordPrefix);

        setupModelTemplate();
    }

    @Override
    public void preprocessOpenAPI(OpenAPI openAPI) {
        super.preprocessOpenAPI(openAPI);
//        supportingFiles.clear();
        supportingFiles.add(new SupportingFile("README.mustache", "", "README.md"));
        supportingFiles.add(new SupportingFile("project_dpr_app.mustache", "", this.programName + "App.dpr"));
        supportingFiles.add(new SupportingFile("project_dpr_srv.mustache", "", this.programName + "Srv.dpr"));
        supportingFiles.add(new SupportingFile("FormMainPas.mustache", "", "FormMain.pas")/*.doNotOverwrite()*/);
        supportingFiles.add(new SupportingFile("FormMainDfm.mustache", "", "FormMain.dfm")/*.doNotOverwrite()*/);

        supportingFiles.add(new SupportingFile("client\\project_dpr_app.mustache", "", this.programName + "ClientApp.dpr"));
        supportingFiles.add(new SupportingFile("client\\api-client.mustache", "", this.programName +"Client.pas"));
        supportingFiles.add(new SupportingFile("client\\ClientMainFormPas.mustache", "", "ClientMainForm.pas").doNotOverwrite());
        supportingFiles.add(new SupportingFile("client\\ClientMainFormDfm.mustache", "", "ClientMainForm.dfm").doNotOverwrite());
        supportingFiles.add(new SupportingFile("client\\whizaxe.openapi.config.pas", "", "whizaxe.openapi.config.pas"));
        supportingFiles.add(new SupportingFile("server-class.mustache", "", this.programName + "Server.pas").doNotOverwrite());
        supportingFiles.add(new SupportingFile("Model.ExtInfo.pas", "models", "Model.ExtInfo.pas"));
        supportingFiles.add(new SupportingFile("Model.UNKNOWN_BASE_TYPE.pas", "models", "Model.UNKNOWN_BASE_TYPE.pas"));

    }

    private void setupModelTemplate() {
        if (additionalProperties.containsKey(OPTION_MODEL_TYPE))
            modelType = (String) additionalProperties.get(OPTION_MODEL_TYPE);

        LOGGER.info("Using [" + modelType + "] model template");
        modelTemplateFiles.put("model-"+ modelType+ "-pas.mustache", ".pas");
        modelTemplateFiles.put("model-"+ modelType+ "-default.mustache", ".default");
    }

    @Override
    public String toModelImport(String name) {
        if (languageSpecificPrimitives.contains(name)) {
          return null;
        }
        if (importMapping.containsKey(name)) {
            return importMapping.get(name);
        } else {
            if (typeMapping.keySet().contains(name) || typeMapping.values().contains(name)
                    || importMapping.values().contains(name) || defaultIncludes.contains(name)
                    || languageSpecificPrimitives.contains(name) || usedModels.contains(name)) {
                if (name == "TExtInfo"){
                    return "Model.ExtInfo";
                }else
                    return name;
            }else {
                return modelFilenamePrefix + name;
            }
        }
    }

    @Override
    public CodegenModel fromModel(String name, Schema model) {
        CodegenModel codegenModel = super.fromModel(name, model);

        Set<String> oldImports = codegenModel.imports;
        codegenModel.imports = new HashSet<>();
        for (String imp : oldImports) {
            String newImp = toModelImport(imp);
            if (!( newImp.isEmpty() )) {
                codegenModel.imports.add(newImp);
                usedModels.add(newImp);
            }
        }

        if(!codegenModel.isEnum
                && codegenModel.anyOf.size()>1
                && codegenModel.anyOf.contains("string")
                && !codegenModel.anyOf.contains("AnyType")
                && codegenModel.interfaces.size()==1
        ){
            codegenModel.vendorExtensions.put("x-is-string-enum-container",true);
        }
        return codegenModel;
    }

    @Override
    public CodegenOperation fromOperation(String path, String httpMethod, Operation operation, List<Server> servers) {
        CodegenOperation op = super.fromOperation(path, httpMethod, operation, servers);

        if (operation.getResponses() != null && !operation.getResponses().isEmpty()) {
            ApiResponse apiResponse = findMethodResponse(operation.getResponses());

            if (apiResponse != null) {
                Schema response = ModelUtils.getSchemaFromResponse(apiResponse);
                if (response != null) {
                    CodegenProperty cm = fromProperty("response", response);
                    op.vendorExtensions.put("x-codegen-response", cm);
                    if ("HttpContent".equals(cm.dataType)) {
                        op.vendorExtensions.put("x-codegen-response-ishttpcontent", true);
                    }
                }
            }
        }

//        String pathForPistache = path.replaceAll("\\{(.*?)}", ":$1");
//        op.vendorExtensions.put("x-codegen-pistache-path", pathForPistache);
        op.vendorExtensions.put("x-codegen-delphi-needs-var", op.returnType != null || op.hasParams);
        op.vendorExtensions.put("x-codegen-delphi-needs-free", (op.returnType != null && !op.returnTypeIsPrimitive) || op.bodyParams != null );

        return op;
    }

    @SuppressWarnings("unchecked")
    @Override
    public Map<String, Object> postProcessOperationsWithModels(Map<String, Object> objs, List<Object> allModels) {
        Map<String, Object> operations = (Map<String, Object>) objs.get("operations");
        String classname = (String) operations.get("classname");
        operations.put("classnameSnakeUpperCase", underscore(classname).toUpperCase(Locale.ROOT));
        operations.put("classnameSnakeLowerCase", underscore(classname).toLowerCase(Locale.ROOT));
        operations.put("x-codegen-delphi-api-guid", "{" + java.util.UUID.randomUUID().toString().toUpperCase(Locale.ROOT) + "}");

        List<CodegenOperation> operationList = (List<CodegenOperation>) operations.get("operation");
        for (CodegenOperation op : operationList) {
            boolean consumeJson = false;
            boolean isParsingSupported = true;
            if (op.bodyParam != null) {
                if (op.bodyParam.vendorExtensions == null) {
                    op.bodyParam.vendorExtensions = new HashMap<>();
                }

                boolean isStringOrDate = op.bodyParam.isString || op.bodyParam.isDate;
                op.bodyParam.vendorExtensions.put("x-codegen-delphi-whizaxe-is-string-or-date", isStringOrDate);
            }
            if (op.consumes != null) {
                for (Map<String, String> consume : op.consumes) {
                    if (consume.get("mediaType") != null && consume.get("mediaType").equals("application/json")) {
                        consumeJson = true;
                    }
                }
            }

            op.httpMethod = op.httpMethod.substring(0, 1).toUpperCase(Locale.ROOT) + op.httpMethod.substring(1).toLowerCase(Locale.ROOT);

            for (CodegenParameter param : op.allParams) {
                if (param.isFormParam) isParsingSupported = false;
                if (param.isFile) isParsingSupported = false;
                if (param.isCookieParam) isParsingSupported = false;

                if (param.isModel && !languageSpecificPrimitives.contains(param.dataType))
                {
                    param.dataType = 'T' + toModelName(param.dataType);
                };

                //DC: nadmiarowe usesy Generics.Collections dla api z parametrami
//                if (param.baseType != null){
//                    String newImp = toModelImport(param.baseType);
//                    if (!( newImp.isEmpty() )) {
//                        op.imports.add(newImp);
//                        usedModels.add(newImp);
//                    }
//                }

                //TODO: This changes the info about the real type but it is needed to parse the header params
//                if (param.isHeaderParam) {
//                    param.dataType = "Pistache::Optional<Pistache::Http::Header::Raw>";
//                    param.baseType = "Pistache::Optional<Pistache::Http::Header::Raw>";
//                } else if (param.isQueryParam) {
//                    if (param.isPrimitiveType) {
//                        param.dataType = "Pistache::Optional<" + param.dataType + ">";
//                    } else {
//                        param.dataType = "Pistache::Optional<" + param.dataType + ">";
//                        param.baseType = "Pistache::Optional<" + param.baseType + ">";
//                    }
//                }
            }

            for (CodegenParameter param : op.bodyParams) {
                if (param.isFormParam) isParsingSupported = false;
                if (param.isFile) isParsingSupported = false;
                if (param.isCookieParam) isParsingSupported = false;

                if (param.isModel && !languageSpecificPrimitives.contains(param.dataType)) {
                    param.dataType = 'T' + toModelName(param.dataType);
                }

            }

            for (CodegenParameter param : op.pathParams) {
                if (param.isFormParam) isParsingSupported = false;
                if (param.isFile) isParsingSupported = false;
                if (param.isCookieParam) isParsingSupported = false;

                if (param.isModel && !languageSpecificPrimitives.contains(param.dataType)) {
                    param.dataType = 'T' + toModelName(param.dataType);
                }
            }

//            if (op.returnBaseType != null) {
//                if (op.returnContainer == "array") {
//                    op.imports.add("TObjectList");
//                }
//                String newImp = toModelImport(op.returnBaseType);
//                if (!(newImp.isEmpty())) {
//                    op.imports.add(newImp);
//                    usedModels.add(newImp);
//                }
//            }

            if (op.vendorExtensions == null) {
                op.vendorExtensions = new HashMap<>();
            }
            op.vendorExtensions.put("x-codegen-consumes-json", consumeJson);
            op.vendorExtensions.put("x-codegen-is-parsing-supported", isParsingSupported);

            // Check if any one of the operations needs a model, then at API file level, at least one model has to be included.
            for (String hdr : op.imports) {
                if (importMapping.containsKey(hdr)) {
                    continue;
                }
                operations.put("hasModelImport", true);
            }
            if (op.operationId.equals("getFpList")) {
                op.vendorExtensions.put("x-codegen-delphi-demo-code-api", "begin\n" +
                        "  result := TFpList.Create;\n" +
                        "  result.AddRange([1, 3, 6]);\n" +
                        "end;");
                op.vendorExtensions.put("x-codegen-delphi-demo-code-client",
                        "var lClient: TvPOSAPIClient;\n" +
                                "FpList: TFpList;\n" +
                                "begin\n" +
                                "  lClient := getClient();\n" +
                                "  FpList := lClient.getFpList();\n" +
                                "  memo1.Lines.Add(FpList.AsJson);\n" +
                                "  lClient.Free;\n" +
                                "end;"
                        );
            }
            if (op.operationId.equals("addItemToBasket")) {
                op.vendorExtensions.put("x-codegen-delphi-demo-code-api",
                    "begin\n" +
                            "  if basketId <> '1' then\n" +
                            "    raise EWxRestBusinessLogicException.Create('Basket Id nie jest jeden', TErrorCodes.AsString(evCE_UNKNOWN_PLU) );\n" +
                            "end;");
                op.vendorExtensions.put("x-codegen-delphi-demo-code-client",
                   "var\n" +
                           "  lClient: TvPOSAPIClient;\n" +
                           "  item: TBasketItemRequest;\n" +
                           "  errorMsg: string;\n" +
                           "begin\n" +
                           "  lClient := getClient();\n" +
                           "  item := TBasketItemRequest.Create;\n" +
                           "  try\n" +
                           "    lClient.addItemToBasket('1234', item);\n" +
                           "  except\n" +
                           "    on E: Exception do\n" +
                           "    begin\n" +
                           "      errorMsg := E.Message;\n" +
                           "      memo1.Lines.Add(errorMsg);\n" +
                           "    end;\n" +
                           "\n" +
                           "  end;\n" +
                           "  lClient.Free;\n" +
                           "end;\n"
                        );
            }
        }

        return objs;
    }

    @Override
    public String toModelFilename(String name) {
        return modelFilenamePrefix + toModelName(name);
    }

    @Override
    public String apiFilename(String templateName, String tag) {
        String result = super.apiFilename(templateName, tag);

        if (templateName.endsWith("rest.mustache")) {
            result = result.replace(".pas", ".Rest.pas");
        } else if (templateName.endsWith("interface.mustache")) {
            result = result.replace(".pas", "Interface.pas");
        } else if (templateName.endsWith("client.mustache")) {
            result = result.replace(".pas", "Client.pas");
        }
        return result;
    }

    @Override
    public String toApiFilename(String name) {
        return toApiName(name);
    }

    /**
     * Optional - type declaration. This is a String which is used by the
     * templates to instantiate your types. There is typically special handling
     * for different property types
     *
     * @return a string value used as the `dataType` field for model templates,
     * `returnType` for api templates
     */
    @Override
    public String getTypeDeclaration(Schema p) {
        String openAPIType = getSchemaType(p);

        if (ModelUtils.isArraySchema(p)) {
            ArraySchema ap = (ArraySchema) p;
            Schema inner = ap.getItems();
            return getSchemaType(p) + "<" + getTypeDeclaration(inner) + ">";
        }
        if (ModelUtils.isMapSchema(p)) {
            Schema inner = getAdditionalProperties(p);
            return getSchemaType(p) + "<string, " + getTypeDeclaration(inner) + ">";
        } else if (ModelUtils.isByteArraySchema(p)) {
            return "string";
        }
        if (ModelUtils.isStringSchema(p)
                || ModelUtils.isDateSchema(p)
                || ModelUtils.isDateTimeSchema(p) || ModelUtils.isFileSchema(p)
                || languageSpecificPrimitives.contains(openAPIType)) {
            return toModelName(openAPIType);
        }
          
        if (!languageSpecificPrimitives.contains(p.getType())){
            return 'T'+toModelName(openAPIType);
        }        

        return openAPIType;
    }

    @Override
    public String toDefaultValue(Schema p) {
        if (ModelUtils.isStringSchema(p)) {
            if (p.getDefault() != null) {
                return "\"" + p.getDefault().toString() + "\"";
            } else {
                return "\"\"";
            }
        } else if (ModelUtils.isBooleanSchema(p)) {
            if (p.getDefault() != null) {
                return p.getDefault().toString();
            } else {
                return "false";
            }
        } else if (ModelUtils.isDateSchema(p)) {
            if (p.getDefault() != null) {
                return "\"" + p.getDefault().toString() + "\"";
            } else {
                return "\"\"";
            }
        } else if (ModelUtils.isDateTimeSchema(p)) {
            if (p.getDefault() != null) {
                return "\"" + p.getDefault().toString() + "\"";
            } else {
                return "\"\"";
            }
        } else if (ModelUtils.isNumberSchema(p)) {
            if (ModelUtils.isFloatSchema(p)) { // float
                if (p.getDefault() != null) {
                    return p.getDefault().toString() + "f";
                } else {
                    return "0.0f";
                }
            } else { // double
                if (p.getDefault() != null) {
                    return p.getDefault().toString();
                } else {
                    return "0.0";
                }
            }
        } else if (ModelUtils.isIntegerSchema(p)) {
            if (ModelUtils.isLongSchema(p)) { // long
                if (p.getDefault() != null) {
                    return p.getDefault().toString() + "L";
                } else {
                    return "0L";
                }
            } else { // integer
                if (p.getDefault() != null) {
                    return p.getDefault().toString();
                } else {
                    return "0";
                }
            }
        } else if (ModelUtils.isByteArraySchema(p)) {
            if (p.getDefault() != null) {
                return "\"" + p.getDefault().toString() + "\"";
            } else {
                return "\"\"";
            }
        } else if (ModelUtils.isMapSchema(p)) {
            String inner = getSchemaType(getAdditionalProperties(p));
            return "std::map<std::string, " + inner + ">()";
        } else if (ModelUtils.isArraySchema(p)) {
            ArraySchema ap = (ArraySchema) p;
            String inner = getSchemaType(ap.getItems());
            if (!languageSpecificPrimitives.contains(inner)) {
                inner = "TArray<" + inner + ">";
            }
            return "TArray<" + inner + ">()";
        } else if (!StringUtils.isEmpty(p.get$ref())) {
            return "TTTTTT<" + toModelName(ModelUtils.getSimpleRef(p.get$ref())) + ">()";
        }

        return "nil";
    }

    /**
     * Location to write model files. You can use the modelPackage() as defined
     * when the class is instantiated
     */
    @Override
    public String modelFileFolder() {
        return (outputFolder + "/models").replace("/", File.separator);
    }

    /**
     * Location to write api files. You can use the apiPackage() as defined when
     * the class is instantiated
     */
    @Override
    public String apiFileFolder() {
        return (outputFolder + "/APIs").replace("/", File.separator);
    }

    /**
     * Optional - OpenAPI type conversion. This is used to map OpenAPI types in
     * a `Schema` into either language specific types via `typeMapping` or
     * into complex models if there is not a mapping.
     *
     * @return a string value of the type or complex model for this property
     */
    @Override
    public String getSchemaType(Schema p) {
        String openAPIType = super.getSchemaType(p);
        String type = null;
        LOGGER.info("### getSchemaType: type="+openAPIType+", model ="+toModelName(type)+", schema: "+ p);
        if (typeMapping.containsKey(openAPIType)) {
            type = typeMapping.get(openAPIType);
            if (languageSpecificPrimitives.contains(type))
                return toModelName(type);
        } else
            type = openAPIType;
        return toModelName(type);
    }

    @Override
    public String getTypeDeclaration(String str) {
        return toModelName(str);
    }

}
