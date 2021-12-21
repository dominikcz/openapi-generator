package org.openapitools.codegen.languages;

import com.google.common.util.concurrent.Callables;
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
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

import static org.openapitools.codegen.utils.StringUtils.underscore;
import static org.openapitools.codegen.utils.StringUtils.camelize;

public class DelphiWhizaxeServerCodegen extends AbstractDelphiCodegen {
    protected String modelType = "properties"; // properties/files - must match template file name!
    protected String modelFilenamePrefix = "ApiModel.";
    protected boolean useModelsFullNamespace = true;
    public static final String PROJECT_NAME = "projectName";
    public static final String OPTION_MODEL_TYPE = "modelType";
    public static final String OPTION_MODEL_TYPE_DESC = "type of model to use";
    public static final String OPTION_MODEL_FILENAME_PREFIX = "modelFilenamePrefix";
    public static final String OPTION_MODEL_FILENAME_PREFIX_DESC = "Prefix of model filename";
    public static final String OPTION_USE_MODELS_FULL_NAMESPACE = "useModelsFullNamespace";
    public static final String OPTION_USE_MODELS_FULL_NAMESPACE_DESC = "use full namespace for models dataType";


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
        addOption (OPTION_USE_MODELS_FULL_NAMESPACE, OPTION_USE_MODELS_FULL_NAMESPACE_DESC, String.valueOf(this.useModelsFullNamespace));
        typeMapping = new HashMap<String, String>();
        typeMapping.put("date", "TDateTime");
        typeMapping.put("DateTime", "TDateTime");
        typeMapping.put("long", "Cardinal");
        typeMapping.put("array", "TList");
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
        importMapping.put("TArray", "Generics.Collections");
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
        supportingFiles.add(new SupportingFile("server-class.mustache", "", this.programName + "Server.pas").doNotOverwrite());
        supportingFiles.add(new SupportingFile("Model.ExtInfo.pas", "models", "Model.ExtInfo.pas"));

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
            codegenModel.vendorExtensions.put("x-is-string-enum-container", true);
        }
        codegenModel.vendorExtensions.put("x-codegen-delphi-enum", codegenModel.isEnum || (codegenModel.allowableValues != null && codegenModel.allowableValues.size() > 0));

        if (!languageSpecificPrimitives.contains(codegenModel.dataType) && !languageSpecificTypes.contains(codegenModel.dataType)) {
            if (useModelsFullNamespace)
                codegenModel.dataType = toModelFilename(codegenModel.classname) + ".T" + toModelName(codegenModel.dataType);
        };

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
                    if(cm.isArray && cm.items != null && cm.items.isModel){
                        op.returnType = "TObjectList<" + getTypeDeclaration(op.returnBaseType) + ">";
                    }else
                        op.returnType = getTypeDeclaration(op.returnBaseType);
                }
            }
        }

//        String pathForPistache = path.replaceAll("\\{(.*?)}", ":$1");
//        op.vendorExtensions.put("x-codegen-pistache-path", pathForPistache);
        if (op.returnContainer != null){
            op.imports.add("Generics.Collections");
        }

        op.vendorExtensions.put("x-codegen-delphi-needs-var", op.returnType != null || op.hasParams);
        op.vendorExtensions.put("x-codegen-delphi-needs-free", (op.returnType != null && !op.returnTypeIsPrimitive) || op.bodyParams != null );
        op.vendorExtensions.put("x-codegen-delphi-returns-model", op.returnType != null && (!op.returnTypeIsPrimitive || op.isArray || op.isMap));

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
        operations.put("x-codegen-delphi-demo-code-api-uses", this.getApiUsesDemoSnippet(classname));

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

                if (op.bodyParam.isArray && op.bodyParam.items != null && op.bodyParam.items.isModel){
                        op.bodyParam.dataType = "TObjectList<" + getTypeDeclaration(op.bodyParam.baseType) + ">";
                    }
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


            }

            for (CodegenParameter param : op.pathParams) {
                if (param.isFormParam) isParsingSupported = false;
                if (param.isFile) isParsingSupported = false;
                if (param.isCookieParam) isParsingSupported = false;

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
            op.vendorExtensions.put("x-codegen-delphi-demo-code-api", this.getOperationDemoSnippet(op.operationId));
            op.vendorExtensions.put("x-codegen-delphi-demo-code-client", this.getClientOperationDemoSnippet(op.operationId));
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
            String schemaType = getSchemaType(p);
            return schemaType + "<" + getTypeDeclaration(inner) + ">";
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

    protected String doGetSnippet(String fileName) {
        String s = null;
        fileName = (templateDir + "/DemoSnippets/"+ fileName).replace("/", File.separator);
        Path p = Path.of(fileName);
        if (Files.exists(p)) {
            try {
                s = Files.readString(p);
            } catch (IOException e) {

            }
        }
        return s;
    }

    public String getOperationDemoSnippet(String operationId) {
        return doGetSnippet("operations/"+operationId+".pas");
    }

    public String getApiUsesDemoSnippet(String classname) {
        return doGetSnippet("operations/uses/"+classname+".pas");
    }

    public String getClientOperationDemoSnippet(String operationId) {
        return doGetSnippet("client/"+operationId+".pas");
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
        if (useModelsFullNamespace && ! languageSpecificPrimitives.contains(str) && !languageSpecificTypes.contains(str))
            return toModelFilename(str) + ".T" +  toModelName(str);
        else
            return toModelName(str);
    }

    @Override
    public String toEnumVarName(String value, String datatype) {
        if (value.length() == 0) {
            return "EMPTY";
        }

        String var = value.replaceAll("\\W+", "_");
        if (var.matches("\\d.*")) {
            return "_" + var;
        } else {
            return var;
        }
    }

    @Override
    public String toEnumValue(String value, String datatype) {
        if ("number".equalsIgnoreCase(datatype) || "boolean".equalsIgnoreCase(datatype)) {
            return value;
        } else {
            return  escapeText(value);
        }
    }


}
