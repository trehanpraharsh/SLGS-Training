package com.advice;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;


@Component
@Aspect
public class LoggerApp {
	
	
	@Before("execution (* com.model.WelcomeDAOImpl.sayHello(..))")
	public void callBefore() {
		System.out.println("Called before jointpoint...");
	}

	@After("execution (* com.model.WelcomeDAOImpl.sayWelcome(..))")
	public void callAfter() {
		System.out.println("Called after the jointpoint");
	}
	
	@Before("execution (* com.model.WelcomeDAOImpl.calculate(..))")
	public void callBeforeCalc() {
		System.out.println("Called before the jointpoint of calc");
	}

	@Around("execution (* com.model.WelcomeDAOImpl.testAround(..))")
	public void callAround(ProceedingJoinPoint jp) {
		try {
			//this will be called before the main method's execution
		System.out.println("called before the jointpoint of around");
		//here the main method will be called
		jp.proceed();
			//this will be called after the main method's execution
		System.out.println("called after the jointpoint of around");
		} catch(Throwable e) {
			
		}
	}
}
