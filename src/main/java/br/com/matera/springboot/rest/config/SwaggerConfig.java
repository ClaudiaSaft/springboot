package br.com.matera.springboot.rest.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
	
	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2)
						.groupName("public-api")
						.apiInfo(apiInfo())
						.select()
						.apis(RequestHandlerSelectors.basePackage("br.com.matera.springboot"))
						.paths(PathSelectors.any())
						.build();
	}
	
	private ApiInfo apiInfo() {
		return new ApiInfoBuilder()
						.title("Swagger API")
						.description("Documentação da API de acesso aos endpoints com Swagger")
						.version("1.0")
						.build();
	}

}
