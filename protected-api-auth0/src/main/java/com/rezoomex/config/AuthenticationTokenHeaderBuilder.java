/*
 * All Rights Reserved. Synerzip 2017
 */
package com.rezoomex.config;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.Parameter;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.OperationBuilderPlugin;
import springfox.documentation.spi.service.contexts.OperationContext;

//@Component
//@Order(SwaggerPluginSupport.SWAGGER_PLUGIN_ORDER)
public class AuthenticationTokenHeaderBuilder implements OperationBuilderPlugin {

    public static final String        API_LOGIN_ENDPOINT    = "/api/login";

    public static final String        HEADER_PARAMETER_TYPE = "header";

    public static final String        HEADER_DESCRIPTION    = "Authentication token (see " + API_LOGIN_ENDPOINT + ")";

    public static final String        STRING_TYPE           = "string";

    private static final List<String> PUBLIC_API_MAPPINGS   = Collections.singletonList(API_LOGIN_ENDPOINT);

    private ParameterBuilder          parameterBuilder      = new ParameterBuilder();

    @Override
    public boolean supports(final DocumentationType documentationType) {
        return DocumentationType.SWAGGER_2.equals(documentationType);
    }

    @Override
    public void apply(final OperationContext context) {
        final String mapping = context.requestMappingPattern();
        if (!PUBLIC_API_MAPPINGS.contains(mapping)) {
            final List<Parameter> parameters = new LinkedList<>();
            parameters.add(parameterBuilder
                            .parameterType(HEADER_PARAMETER_TYPE)
                            .name("Authorization")
                            .defaultValue("Bearer ")
                            .modelRef(new ModelRef(STRING_TYPE))
                            .description(HEADER_DESCRIPTION)
                            .allowMultiple(false)
                            .required(true)
                            .build());
            context.operationBuilder().parameters(parameters);
        }
    }

}