package lk.ijse.userservice.config;

import io.swagger.v3.oas.models.*;
import io.swagger.v3.oas.models.info.*;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.*;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI usersOpenAPI() {
        return new OpenAPI()
                .info(new Info().title("User Service API")
                        .description("API for managing users")
                        .version("v1.0"));
    }

    @Bean
    public GroupedOpenApi userGroup() {
        return GroupedOpenApi.builder()
                .group("users")
                .pathsToMatch("/api/v1/user/**")
                .build();
    }

    //http://localhost:8081/swagger-ui.html

}
