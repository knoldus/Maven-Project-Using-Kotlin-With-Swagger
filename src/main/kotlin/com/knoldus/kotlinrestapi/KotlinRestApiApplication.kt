package com.knoldus.kotlinrestapi

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.boot.web.client.RestTemplateBuilder
import org.springframework.context.annotation.Bean
import org.springframework.web.client.RestTemplate
import springfox.documentation.swagger2.annotations.EnableSwagger2

@SpringBootApplication
@EnableSwagger2
class KotlinRestApiApplication


{

	@Bean
	fun restTemplate(builder: RestTemplateBuilder): RestTemplate =
			builder.build()
}
/**
 * The main class for running the REST API application.
 */
fun main(args: Array<String>) {
	runApplication<KotlinRestApiApplication>(*args)
}
