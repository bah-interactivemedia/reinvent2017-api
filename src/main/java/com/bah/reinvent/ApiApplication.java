package com.bah.reinvent;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import static com.google.common.base.Predicates.or;
import static springfox.documentation.builders.PathSelectors.regex;

@EnableSwagger2
@SpringBootApplication
public class ApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiApplication.class, args);
	}

	@Bean
	public Docket authApi() {
		return new Docket(DocumentationType.SWAGGER_2)
				.groupName("v1")
				.apiInfo(apiInfo())
				.select()
				.paths(or(regex("/tests.*"), regex("/students.*")))
				.build();
	}

	private ApiInfo apiInfo() {
		return new ApiInfoBuilder()
				.title("National Fitness Foundation Reporting")
				.description("A set of RESTful APIs to support the reporting of student fitness information")
				.version("1.0")
				.build();
	}
}
