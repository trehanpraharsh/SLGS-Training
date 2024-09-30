package com.example.spring_security;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class AppSecurity {
	
	@Bean
	protected InMemoryUserDetailsManager configAuth() {
		
		List<UserDetails> users = new ArrayList<UserDetails>();
		
		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		authorities.add(new SimpleGrantedAuthority("ADMIN"));
		UserDetails admin = new User("admin", "{noop}admin123", authorities);
		users.add(admin);
		
		List<GrantedAuthority> authorities2 = new ArrayList<GrantedAuthority>();
		authorities2.add(new SimpleGrantedAuthority("MANAGER"));
		UserDetails manager = new User("manager", "{noop}manager123", authorities2);
		users.add(manager);
		
		return new InMemoryUserDetailsManager(users);
		
	}
	
	
	
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
		http.authorizeHttpRequests(auth -> auth
				.requestMatchers("/home").permitAll()
				.requestMatchers("/welcome").authenticated()
				.requestMatchers("/admin").hasAuthority("ADMIN")
				.requestMatchers("/emp").hasAuthority("EMP")
				.requestMatchers("/manager").hasAuthority("MANAGER")
				.requestMatchers("/common").hasAnyAuthority("EMP", "MANAGER")
				.anyRequest().authenticated())
		.formLogin(formLogin -> formLogin.defaultSuccessUrl("/welcome", true))
		.logout(logout -> logout.logoutUrl("/logout"))
		.exceptionHandling(eh -> eh.accessDeniedPage("/ad"));
		
		return http.build();
	}

}
