package com.careerit.iplstats.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("IPL Stats API")
                        .description("""
                                A comprehensive REST API for managing IPL (Indian Premier League) player statistics.
                                
                                ## Features
                                - **Player Management**: Full CRUD operations for IPL players
                                - **Search & Filter**: Advanced search capabilities across multiple fields
                                - **Team Analytics**: Get players by team, role, and country
                                - **Statistics**: Player count and unique value queries
                                
                                ## API Version
                                This is version 1.0 of the IPL Stats API.
                                
                                ## Authentication
                                Currently, this API does not require authentication. In production, consider implementing proper security measures.
                                
                                ## Rate Limiting
                                Please be mindful of API usage. Rate limiting may be implemented in future versions.
                                """)
                        .version("1.0.0")
                        .contact(new Contact()
                                .name("CareerIT Team")
                                .email("support@careerit.com")
                                .url("https://careerit.com"))
                        .license(new License()
                                .name("MIT License")
                                .url("https://opensource.org/licenses/MIT")))
                .servers(List.of(
                        new Server()
                                .url("http://localhost:8081")
                                .description("Development Server"),
                        new Server()
                                .url("https://api.iplstats.careerit.com")
                                .description("Production Server")
                ));
    }
}
