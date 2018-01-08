/*
 * All Rights Reserved. Synerzip 2017
 */
package com.rezoomex.config;

import static java.util.Arrays.asList;

import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.ApiKey;
import springfox.documentation.service.AuthorizationScope;
import springfox.documentation.service.Contact;
import springfox.documentation.service.SecurityReference;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger.web.ApiKeyVehicle;
import springfox.documentation.swagger.web.SecurityConfiguration;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

// TODO: Auto-generated Javadoc
/**
 * The Class SwaggerConfig.
 *
 * @author vivekanandt
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {

    /**
     * Api.
     *
     * @return the docket
     */
    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                        .select()
                        .apis(RequestHandlerSelectors.any())
                        .paths(PathSelectors.any())
                        .build()
                        .apiInfo(getApiInfo())
                        .securityContexts(asList(securityContext()))
                        .securitySchemes(asList(apiKey()))

        ;
    }

    /**
     * Meta data.
     *
     * @return the api info
     */
    private ApiInfo getApiInfo() {
        ApiInfo apiInfo = new ApiInfo(
                        "Spring Boot REST API",
                        "Spring Boot REST API for Online Store",
                        "1.0",
                        "Terms of service",
                        new Contact("Vivekanand Thite", "", "vivekthite@gmail.com"),
                        "Apache License Version 2.0",
                        "https://www.apache.org/licenses/LICENSE-2.0");
        return apiInfo;
    }

    private ApiKey apiKey() {
        return new ApiKey("AUTHORIZATION", "AUTHORIZATION", "header");
    }

    @Bean
    SecurityConfiguration security() {
        return new SecurityConfiguration(
                        null,
                        null,
                        null, // realm Needed for authenticate button to work
                        null, // appName Needed for authenticate button to work
                        null,// apiKeyValue
                        ApiKeyVehicle.HEADER,
                        "AUTHORIZATION", //apiKeyName
                        null);
    }

    private SecurityContext securityContext() {
        return SecurityContext.builder()
                        .securityReferences(defaultAuth())
                        .forPaths(PathSelectors.regex("/anyPath.*"))
                        .build();
    }

    List<SecurityReference> defaultAuth() {
        AuthorizationScope authorizationScope = new AuthorizationScope("global", "accessEverything");
        AuthorizationScope[] authorizationScopes = new AuthorizationScope[1];
        authorizationScopes[0] = authorizationScope;
        return asList(
                        new SecurityReference("AUTHORIZATION", authorizationScopes));
    }

}
