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
	
	private String url;
	
	@Bean
	@Profile("dev")
	public String testDevDB() {
		System.out.println(url);
		return "DEV DB Connected...!";
	}

}
