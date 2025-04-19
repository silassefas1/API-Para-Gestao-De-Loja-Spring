package com.silassefas.apigestaodeloja.configuration;

import io.swagger.v3.oas.models.OpenAPI;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.servers.Server;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("API de Gestão de Loja")
                        .version("v1")
                        .description("Documentação da API para gerenciar os produtos de um e-commerce"))
                .addServersItem(new Server().url("http://localhost:8080"));
    }
}
