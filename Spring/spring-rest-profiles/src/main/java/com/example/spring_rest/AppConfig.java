package com.example.spring_rest;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import lombok.Data;

@Configuration
@ConfigurationProperties("spring.datasource")
@Data
public class AppConfig {
	
	private String driverClassName;
	private String url;
	private String username;
	private String password;
	
	@Bean
	@Profile("prod")
	public String testProdDb() {
		System.out.println(driverClassName);
		System.out.println(url);
		return "PROD DB Connected...!";
	}
	
	@Bean
	@Profile("dev")
	public String testDevDB() {
		System.out.println(driverClassName);
		System.out.println(url);
		return "DEV DB Connected...!";
	}
	
	@Bean
	@Profile("test")
	public String testTestDb() {
		System.out.println(driverClassName);
		System.out.println(url);
		return "TEST DB Connected...!";
	}

}
