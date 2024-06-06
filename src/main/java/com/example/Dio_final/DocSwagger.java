package com.example.Dio_final;



import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;

@Configuration
public class DocSwagger {

    @Bean
    public org.springdoc.core.models.GroupedOpenApi publicApi() {
        return org.springdoc.core.models.GroupedOpenApi.builder()
                .group("spring-public")
                .pathsToMatch("/**")
                .build();
    }

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                    .title("Title - Rest API")
                    .description("API exemplo de uso de Springboot REST API")
                    .version("1.0")
                    .termsOfService("Termo de uso: Open Source")
                    .license(new License().name("Licença - Sua Empresa").url("http://www.seusite.com.br"))
                    .contact(new Contact().name("Seu Nome").url("http://www.seusite.com.br").email("seuemail@dominio.com")));
    }
}


