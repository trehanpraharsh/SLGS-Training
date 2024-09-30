package com.delegate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class AppDelegate2 {
	
	@Autowired
	RestTemplate template1;
	
	@Bean
	@LoadBalanced
	public RestTemplate template1() {
		return new RestTemplate();
	}
	
	public String delegate(Integer input) {
		
		String response = template1.exchange("http://spring-blog/mainapp/loadownerdetails/{input}", HttpMethod.GET, 
				null, new ParameterizedTypeReference<String>() {
				}, input).getBody();
		return response;
		
	}
	
	
	public String delegate2(Integer input) {
		
		String response = template1.exchange("http://spring-blog/mainapp/loadblogdetails/{input}", HttpMethod.GET, 
				null, new ParameterizedTypeReference<String>() {
				}, input).getBody();
		return response;
		
	}
	
	
	public String delegate3(Integer input) {
		
		String response = template1.exchange("http://spring-blog/mainapp/findcommentsbyowner/{input}", HttpMethod.GET, 
				null, new ParameterizedTypeReference<String>() {
				}, input).getBody();
		return response;
		
	}
	

}
