package com.jfv.test.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import springfox.documentation.builders.RequestHandlerSelectors
import springfox.documentation.service.ApiInfo
import springfox.documentation.service.Contact
import springfox.documentation.spi.DocumentationType
import springfox.documentation.spring.web.plugins.Docket
import springfox.documentation.swagger2.annotations.EnableSwagger2
import java.util.*


@Configuration
@EnableSwagger2
class SwaggerConfig {



    @Bean
    fun api(): Docket = Docket(DocumentationType.SWAGGER_2).select()
        .apis(RequestHandlerSelectors.basePackage("com.jfv.test.controller"))
        .build()
        .apiInfo(apiInfo());


    fun apiInfo(): ApiInfo? {
        return ApiInfo(
            "Test Backend TUL Kotlin",
            "Primera API creada en Kotlin.",
            "API TUL",
            "Test",
            Contact("Valdez,Jóse Francisco", "https://www.linkedin.com/in/jose-francisco-valdez-282a1b1a/", "valdez.jose,francisco@gmail.com"),
            "Demo cart Shopp", "URL", Collections.emptyList()
        )
    }

}
