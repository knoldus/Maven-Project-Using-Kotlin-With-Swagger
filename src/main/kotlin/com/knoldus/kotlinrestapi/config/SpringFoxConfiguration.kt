package com.knoldus.kotlinrestapi.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import springfox.documentation.builders.ApiInfoBuilder
import springfox.documentation.builders.RequestHandlerSelectors
import springfox.documentation.service.ApiInfo
import springfox.documentation.spi.DocumentationType
import springfox.documentation.spring.web.plugins.Docket
import java.util.function.Predicate

@Configuration
class SpringFoxConfiguration {

    @Bean
    fun api(): Docket? {
        return Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(Predicate.not(RequestHandlerSelectors.basePackage("org.springframework.boot")))
                .build()
    }

    private fun apiInfo(): ApiInfo? {
        return ApiInfoBuilder()
                .title("BANK'S SWAGGER API")
                .description("My API Is Listed Here ::")
                .version("0.0.12")
                .build()
    }

}