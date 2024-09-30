package com.advice;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Order(1)
public class LoggerApp2 {
	
	@Before("execution (* com.model.WelcomeDAOImpl.sayHello(..))")
	public void callBefore2() {
		System.out.println("Called before jointpoint again...");
	}

}
