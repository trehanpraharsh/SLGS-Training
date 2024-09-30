package com.example.product_service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.bind.annotation.CrossOrigin;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

///TRY REMOVING THE SPRING SECURITY OR PASS THE PASSWORD OR GIVE AUTHORITY
@SpringBootApplication
@ComponentScan("com")
@EnableJpaRepositories("com")
@EntityScan("com")
@EnableDiscoveryClient
@RefreshScope
@CrossOrigin
@OpenAPIDefinition(info = @Info(title = "Product Info API", version = "2.0", description = "Product CRUD"))
public class ProductServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProductServiceApplication.class, args);
	}

}
