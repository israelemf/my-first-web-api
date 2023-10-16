package curse.myfirstwebapi.doc;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public GroupedOpenApi detailsApi() {
        return GroupedOpenApi.builder()
                .group("springboot-rest-api")
                .packagesToScan("curse.myfirstwebapi.controller")
                .build();
    }

    // Informações da API
    @Bean
    public OpenAPI InformationApi() {
        return new OpenAPI()
                .info(new Info().title("Springboot Rest API")
                        .description("Exemplo de uma API Rest criada com o Springboot")
                        .version("v0.0.1")
                        .license(new License().name("Licença: israelemf").url("https://github.com/israelemf")));
    }
}
