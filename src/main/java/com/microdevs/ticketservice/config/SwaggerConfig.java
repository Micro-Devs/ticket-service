package com.microdevs.ticketservice.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springdoc.core.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {
    @Bean
    public GroupedOpenApi groupedOpenApi() {
        return GroupedOpenApi.builder()
                .group("MicroDevs")
                .displayName("Micro Devs")
                .pathsToMatch("/**")
                .build();
    }

    @Bean
    public OpenAPI openAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Ticket Service Application API")
                        .contact(new Contact()
                                .email("mertkaya2455@gmail.com")
                                .url("https://github.com/Micro-Devs/ticket-service")
                                .name("Ticket Service Developer"))
                        .description("Ticket Service Application Open Api Documentation")
                        .license(new License()
                                .name("Apache License Version 2.0")
                                .url("https://www.apache.org/licenses/LICENSE-2.0"))
                        .version("0.0.1-SNAPSHOT"));

    }
}
