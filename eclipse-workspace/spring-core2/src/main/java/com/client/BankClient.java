package com.client;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.service.CalculateService;

public class BankClient {
	
	public static void main(String[] args) {
		
		//initiate the container
		ConfigurableApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml");
		//load the service
		CalculateService cs = (CalculateService) ctx.getBean("service");
		CalculateService cs2 = (CalculateService) ctx.getBean("service");
		
		//follows eager-loading and by default all objects are singleton
		System.out.println(cs.hashCode());
		System.out.println(cs2.hashCode());
		
		System.out.println(cs.calculateROI(45768));
		ctx.close();
		
		
	}

}
