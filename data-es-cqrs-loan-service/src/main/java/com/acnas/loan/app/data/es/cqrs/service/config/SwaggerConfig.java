/*
 * 
 */
package com.acnas.loan.app.data.es.cqrs.service.config;

import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

// TODO: Auto-generated Javadoc
/**
 * The Class SwaggerConfig.
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {

	/**
	 * Api.
	 *
	 * @return the docket
	 */
	public Docket api() {
		return buildDocket();
	}

	/**
	 * Builds the docket.
	 *
	 * @return the docket
	 */
	private Docket buildDocket() {
		Docket returnValue = new Docket(DocumentationType.SWAGGER_2).select()
				.apis(RequestHandlerSelectors.basePackage("com.cts.data.es.cqrs.service")).paths(PathSelectors.any())
				.build().apiInfo(apiInfo());

		return returnValue;

	}

	/**
	 * Api info.
	 *
	 * @return the api info
	 */
	private ApiInfo apiInfo() {
		return new ApiInfoBuilder()
				.title("Cognizant ServiceLab POC - Microservice Event Sourcing using Axon and Spring Boot")
				.description("Trading service with event sourcing").termsOfServiceUrl("http://cognizant.com")
				.contact("Cognizant Service lab - serviceLab@cognizant,com")
				.license("Congnizant service lab License Version 1.0").licenseUrl("https://cognizant.com/LICENSE")
				.version("1.0").build();
	}

}
