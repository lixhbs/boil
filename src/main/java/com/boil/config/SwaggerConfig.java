package com.boil.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author lix.
 * @title
 * @program boil
 * @description
 * @createtime 2020-11-18 10:23
 */
@Configuration
@EnableSwagger2
@ComponentScan("com.boil.web")
public class SwaggerConfig
{
    @Bean
    public Docket api()
    {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .enable(true)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.boil.web"))
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("XXX Rest Server")
                .description("XXXRest接口")
                .contact(new Contact("contract", "url", "email"))
                .version("1.0")
                .build();
    }
}
