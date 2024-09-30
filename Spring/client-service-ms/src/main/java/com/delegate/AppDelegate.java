package com.delegate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class AppDelegate {
	
	@Autowired
	RestTemplate template;
	
	@Bean
	@LoadBalanced
	public RestTemplate template() {
		return new RestTemplate();
	}
	
	public String delegate(String input) {
		
		String response = template.exchange("http://student-service-ms/studentapp/loadstudent/{input}", HttpMethod.GET, 
				null, new ParameterizedTypeReference<String>() {
				}, input).getBody();
		return response;
		
	}
	

}
