package com.cefet.projeto_academia.config;

import org.springframework.context.annotation.Configuration;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

@Configuration
@OpenAPIDefinition(
    info = @Info(
        title = "API - Projeto Academia",
        version = "1.0",
        description = "Documentação da API de gerenciamento da academia"
    )
)
public class SwaggerConfig {
    
}

