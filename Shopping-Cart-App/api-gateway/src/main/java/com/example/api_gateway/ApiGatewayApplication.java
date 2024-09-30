package com.example.api_gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.CrossOrigin;

@SpringBootApplication
@EnableDiscoveryClient
public class ApiGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiGatewayApplication.class, args);
	}

	
//	@Bean
//	@CrossOrigin(origins = "*")
//	RouteLocator gatewayRoute(RouteLocatorBuilder builder) {
//		return builder.routes()
//				.route("ps", rs -> rs
//						.path("/productapp/**")
//						.uri("lb://product-service")
//					  ).build();
//	}
//	
//	
//	@Bean
//	RouteLocator gatewayRoute2(RouteLocatorBuilder builder) {
//		return builder.routes()
//				.route("ps", rs -> rs
//						.path("/shoppingcart/**")
//						.uri("lb://cart-service")
//					  ).build();
//	}
	
}
