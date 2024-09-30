package com.example.spring_security;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class EncodeTest {
	
	public static void main(String[] args) {
		
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		System.out.println(encoder.encode("qa123"));
		
	}

}
