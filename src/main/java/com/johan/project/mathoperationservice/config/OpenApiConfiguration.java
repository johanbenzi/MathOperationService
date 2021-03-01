package com.johan.project.mathoperationservice.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfiguration {

  @Bean
  public OpenAPI openAPI() {
    return new OpenAPI().info(new Info().title("MathOperationService - API").description(
      "An application that is responsible for performing math operations against existing numbers loaded from memory")
      .version("v1.0.0")
      .license(new License().name("MIT License").url("https://opensource.org/licenses/MIT")));
  }
}
