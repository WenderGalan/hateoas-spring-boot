package io.github.wendergalan.hateoasproject.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.hateoas.server.LinkRelationProvider;
import org.springframework.hateoas.server.core.DelegatingLinkRelationProvider;
import org.springframework.plugin.core.support.PluginRegistryFactoryBean;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import static springfox.documentation.builders.PathSelectors.regex;

@Configuration
@EnableSwagger2
public class SwaggerConfiguration {


    @Bean
    public Docket personApi1() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("person-api-1")
                .select()
                .apis(RequestHandlerSelectors.basePackage("io.github.wendergalan.hateoasproject.controllers"))
                .paths(regex("/pessoas_fisicas/v1.*"))
                .build()
                .apiInfo(new ApiInfoBuilder().version("1").title("Person API").description("Documentation Person API v1").build());
    }

    @Bean
    public Docket personApi2() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("person-api-2")
                .select()
                .apis(RequestHandlerSelectors.basePackage("io.github.wendergalan.hateoasproject.controllers"))
                .paths(regex("/pessoas_fisicas/v2.*"))
                .build()
                .apiInfo(new ApiInfoBuilder().version("2").title("Person API").description("Documentation Person API v2").build());
    }

    /**
     * Esse bean serve para poder corrigir o problema de incompatiblidade entre o Spring + HATEOAS
     * https://github.com/springfox/springfox/issues/2932#issuecomment-551929579
     */
    @Bean
    @Primary
    public PluginRegistryFactoryBean<LinkRelationProvider, LinkRelationProvider.LookupContext> myPluginRegistryProvider(){

        PluginRegistryFactoryBean<LinkRelationProvider, LinkRelationProvider.LookupContext> factory
                = new PluginRegistryFactoryBean<>();

        factory.setType(LinkRelationProvider.class);
        Class<?> classes[] = new Class<?>[1];
        classes[0] = DelegatingLinkRelationProvider.class;
        factory.setExclusions(classes);

        return factory;
    }
}
