/*
 * All Rights Reserved. Synerzip 2017
 */
package com.rezoomex.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
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
                        .apiInfo(metaData());

    }

    /**
     * Meta data.
     *
     * @return the api info
     */
    private ApiInfo metaData() {
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
}
