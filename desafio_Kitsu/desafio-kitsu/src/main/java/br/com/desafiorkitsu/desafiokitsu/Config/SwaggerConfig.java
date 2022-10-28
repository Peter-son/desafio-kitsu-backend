package br.com.desafiorkitsu.desafiokitsu.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2 // Anotação para ativar o Swagger
public class SwaggerConfig {
    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2) // Define as configurações dos endpoints
                  .select()
          .apis(RequestHandlerSelectors.any()) // Define que qualquer caminho da api estará disponível
          .paths(PathSelectors.any()) // Define que qualquer caminho da api estará disponível
          .build();
    }  
}
