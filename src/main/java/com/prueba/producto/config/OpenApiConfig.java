package com.prueba.producto.config;

import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.OpenAPI;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI tiendaOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("API de Tienda")
                        .version("1.0")
                        .description("Documentación de la API para gestión de productos y órdenes"));
    }
}

