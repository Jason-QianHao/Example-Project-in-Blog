package com.jason.config;

import org.springdoc.core.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;

@Configuration
public class SpringDocConfig {
	
	/**
	 * 基本信息设置
	 * @return
	 */
	@Bean
	public OpenAPI mallTinyOpenAPI() {
		return new OpenAPI()
				.info(new Info().title("Test API").description("SpringDoc API 演示").version("v1.0.0")
						.license(new License().name("Apache 2.0").url("https://github.com/jason-qianhao")))
				.externalDocs(new ExternalDocumentation().description("Jason Blog")
						.url("http://jason-qianhao.github.io"));
	}

	/**
	 * 分组设置
	 * @return
	 */
	@Bean
	public GroupedOpenApi publicApi() {
		return GroupedOpenApi.builder().group("test").pathsToMatch("/test/**").build();
	}

	@Bean
	public GroupedOpenApi adminApi() {
		return GroupedOpenApi.builder().group("admin").pathsToMatch("/admin/**").build();
	}
}