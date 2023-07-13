package com.knoldus.kotlinrestapi.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import springfox.documentation.builders.ApiInfoBuilder
import springfox.documentation.builders.RequestHandlerSelectors
import springfox.documentation.service.ApiInfo
import springfox.documentation.spi.DocumentationType
import springfox.documentation.spring.web.plugins.Docket
import java.util.function.Predicate

/**
 * Configuration class for SpringFox Swagger integration.
 *
 */
@Configuration
class SpringFoxConfiguration {

    /**
     * Creates a Docket bean for Swagger documentation generation.
     *
     * @return The Docket bean.
     */
    @Bean
    fun api(): Docket? {
        return Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(Predicate.not(RequestHandlerSelectors.basePackage("org.springframework.boot")))
                .build()
    }

    /**
     * Creates an ApiInfo object for Swagger API information.
     *
     * @return The ApiInfo object.
     */
    private fun apiInfo(): ApiInfo? {
        return ApiInfoBuilder()
                .title("BANK'S SWAGGER API")
                .description("My API Is Listed Here ::")
                .version("0.0.12")
                .build()
    }

}