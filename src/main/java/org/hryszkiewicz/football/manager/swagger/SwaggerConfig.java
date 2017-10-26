package org.hryszkiewicz.football.manager.swagger;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.Tag;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger.web.UiConfiguration;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


@Configuration
@EnableSwagger2
public class SwaggerConfig {

    private static final String FOOTBALL_MANAGER = "Football manager API";

    @Bean
    public Docket fmSwaggerApi() {

        return new Docket(DocumentationType.SWAGGER_2).useDefaultResponseMessages(false).groupName(FOOTBALL_MANAGER)
                .apiInfo(new ApiInfoBuilder().title(FOOTBALL_MANAGER).description("Football Manager API").version("1").build()).select().apis(RequestHandlerSelectors.basePackage("org.hryszkiewicz.football.manager"))
                .paths(PathSelectors.any()).build().tags(
                        new Tag("player", "Players management."),
                        new Tag("trainer", "Trainers management."),
                        new Tag("goals", "Goals management."),
                        new Tag("assist", "Assists management."),
                        new Tag("club", "Clubs management."));

    }

    @Bean
    protected UiConfiguration uiConfig() {
        return new UiConfiguration(null);
    }
}
