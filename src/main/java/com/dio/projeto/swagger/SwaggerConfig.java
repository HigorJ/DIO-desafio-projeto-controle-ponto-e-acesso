package com.dio.projeto.swagger;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.builders.RequestParameterBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.RequestParameter;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Collections;
import java.util.List;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.dio.projeto"))
                .paths(PathSelectors.ant("/**"))
                .build()
                .apiInfo(apiInfo())
                .globalRequestParameters(authParameter());
    }

    @Bean
    public ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("API_REST")
                .description("Api para gerenciamento de ponto e acesso")
                .version("1.0.0")
                .license("Apache License Version 2.0")
                .licenseUrl("https://www.apage.org/licenses/LICENSE-2.0")
                .contact(new Contact("DIO", "https://web.digitalinnovation.one", "contato@digitalinnovationone.com.br"))
                .build();
    }

    private List<RequestParameter> authParameter() {
        return Collections.singletonList(
                new RequestParameterBuilder()
                        .name("Authorization")
                        .description("access_token")
                        .in("header")
                        .required(false)
                        .accepts(Collections.singleton(MediaType.APPLICATION_JSON))
                        .build());
    }
}
