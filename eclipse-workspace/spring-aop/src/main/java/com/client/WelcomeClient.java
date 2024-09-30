package com.client;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.config.AppConfig;
import com.model.WelcomeDAO;


public class WelcomeClient {
	
	public static void main(String[] args) {
		ConfigurableApplicationContext wcs = new AnnotationConfigApplicationContext(AppConfig.class);
		
		WelcomeDAO impl = (WelcomeDAO) wcs.getBean("welcome");
		System.out.println(impl.sayHello("Sunlife BLR"));
		
		impl.sayWelcome();
		System.out.println(impl.calculate(2, 3));
		impl.testAround();
		
		
		
	}
	
	

}
