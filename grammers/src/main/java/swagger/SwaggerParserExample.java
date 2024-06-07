package swagger;

import io.swagger.v3.parser.OpenAPIV3Parser;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.PathItem;
import io.swagger.v3.oas.models.media.*;
import io.swagger.v3.oas.models.parameters.Parameter;
import io.swagger.v3.oas.models.parameters.RequestBody;
import io.swagger.v3.oas.models.responses.ApiResponse;

import java.util.List;
import java.util.Map;

public class SwaggerParserExample {

    public static void main(String[] args) {
        // 解析Swagger JSON文档
        OpenAPIV3Parser parser = new OpenAPIV3Parser();
        OpenAPI openAPI = parser.read("doc/default_OpenAPI.json");

        if (openAPI == null) {
            System.out.println("Failed to parse Swagger JSON");
            return;
        }

        // 遍历所有路径
        for (Map.Entry<String, PathItem> entry : openAPI.getPaths().entrySet()) {
            String url = entry.getKey();
            PathItem pathItem = entry.getValue();

            // 遍历每个HTTP方法
            pathItem.readOperationsMap().forEach((httpMethod, operation) -> {
                System.out.println("URL: " + url);
                System.out.println("Method: " + httpMethod);

                // 获取请求参数
                List<Parameter> parameters = operation.getParameters();
                if (parameters != null) {
                    for (Parameter parameter : parameters) {
                        System.out.println("Parameter: " + parameter.getName());
                        System.out.println("  In: " + parameter.getIn());
                        System.out.println("  Required: " + parameter.getRequired());
                        printDefaultValue(parameter.getSchema(), "  ");
                    }
                }

                // 获取请求体
                RequestBody requestBody = operation.getRequestBody();
                if (requestBody != null) {
                    Content content = requestBody.getContent();
                    if (content != null) {
                        for (Map.Entry<String, MediaType> contentEntry : content.entrySet()) {
                            MediaType mediaType = contentEntry.getValue();
                            Schema<?> schema = mediaType.getSchema();
                            if (schema != null) {
                                Schema<?> resolvedSchema = resolveSchema(schema, openAPI);
                                System.out.println("Request Body: " + schema.getName());
                                printSchemaDefaultValues(resolvedSchema, "  ");
                            }
                        }
                    }
                }

                // 获取响应
                Map<String, ApiResponse> responses = operation.getResponses();
                if (responses != null) {
                    responses.forEach((statusCode, apiResponse) -> {
                        System.out.println("Response: " + statusCode);
                        Content responseContent = apiResponse.getContent();
                        if (responseContent != null) {
                            for (Map.Entry<String, MediaType> contentEntry : responseContent.entrySet()) {
                                MediaType mediaType = contentEntry.getValue();
                                Schema<?> schema = mediaType.getSchema();
                                if (schema != null) {
                                    Schema<?> resolvedSchema = resolveSchema(schema, openAPI);
                                    System.out.println("Response Body: " + schema.getName());
                                    printSchemaDefaultValues(resolvedSchema, "  ");
                                }
                            }
                        }
                    });
                }
            });
        }
    }

    private static Schema<?> resolveSchema(Schema<?> schema, OpenAPI openAPI) {
        if (schema.get$ref() != null) {
            String ref = schema.get$ref();
            String refName = ref.substring(ref.lastIndexOf('/') + 1);
            return openAPI.getComponents().getSchemas().get(refName);
        }
        return schema;
    }

    private static void printDefaultValue(Schema<?> schema, String indent) {
        if (schema != null) {
            System.out.println(indent + "Default: " + schema.getDefault());
            if (schema.getDefault() == null) {
                switch (schema.getType()) {
                    case "string":
                        System.out.println(indent + "  Default (generated): " + "defaultString");
                        break;
                    case "integer":
                        System.out.println(indent + "  Default (generated): " + 0);
                        break;
                    case "boolean":
                        System.out.println(indent + "  Default (generated): " + false);
                        break;
                    // 添加其他类型的默认值处理
                    default:
                        System.out.println(indent + "  Default (generated): " + "default");
                        break;
                }
            }
        }
    }

    private static void printSchemaDefaultValues(Schema<?> schema, String indent) {
        if (schema.getProperties() != null) {
            for (Map.Entry<String, Schema> propertyEntry : schema.getProperties().entrySet()) {
                String propertyName = propertyEntry.getKey();
                Schema<?> propertySchema = propertyEntry.getValue();
                System.out.println(indent + "Field: " + propertyName);
                System.out.println(indent + "  Type: " + propertySchema.getType());
                printDefaultValue(propertySchema, indent + "  ");

                // 如果字段是一个对象，则递归打印
                if (propertySchema.getProperties() != null) {
                    printSchemaDefaultValues(propertySchema, indent + "  ");
                }
            }
        }
    }
}
