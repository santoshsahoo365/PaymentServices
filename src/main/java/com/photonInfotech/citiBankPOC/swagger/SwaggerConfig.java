package com.photonInfotech.citiBankPOC.swagger;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.google.common.base.Predicates;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

@Configuration

@EnableSwagger2

public class SwaggerConfig {

    public static final Contact DEFAULT_CONTACT = new Contact(
            "Photon Infotech", "http://www.photon.in/", "manish.maganbhai@photoninfotech.net");

    public static final ApiInfo DEFAULT_API_INFO = new ApiInfo(
            "CitiBank API",
            "APIs to create, update, delete, and list accounts in Citi Bank Payment service",
            "1.0",
            "urn:tos", DEFAULT_CONTACT,
            "Photon Infotech", "http://www.photon.in/");

    private static final Set<String> DEFAULT_PRODUCES_AND_CONSUMES =
            new HashSet<String>(Arrays.asList("application/json"));

    @Bean

    public Docket demoApi() {
        return new Docket(DocumentationType.SWAGGER_2)// <3>
                .select()// <4>
                .apis(RequestHandlerSelectors.any())// <5>
                .paths(Predicates.not(PathSelectors.regex("/error.*")))// <6>, regex must be in double quotes.
                .build().apiInfo(DEFAULT_API_INFO).produces(DEFAULT_PRODUCES_AND_CONSUMES)
                .consumes(DEFAULT_PRODUCES_AND_CONSUMES);
    }

}
