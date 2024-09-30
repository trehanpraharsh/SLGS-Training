package com.example.spring_security;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class AppSecurity {
	
//	@Bean
//	protected InMemoryUserDetailsManager configAuth() {
//		
//		List<UserDetails> users = new ArrayList<UserDetails>();
//		
//		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
//		authorities.add(new SimpleGrantedAuthority("ADMIN"));
//		UserDetails admin = new User("admin", "{noop}admin123", authorities);
//		users.add(admin);
//		
//		List<GrantedAuthority> authorities2 = new ArrayList<GrantedAuthority>();
//		authorities2.add(new SimpleGrantedAuthority("MANAGER"));
//		UserDetails manager = new User("manager", "{noop}manager123", authorities2);
//		users.add(manager);
//		
//		return new InMemoryUserDetailsManager(users);
//		
//	}
	
	@Autowired
	private DataSource dataSource;
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	@Bean
	public UserDetailsManager authenticateUsers() {
//		UserDetails userDetails = User.withUsername("admin")
//				.password(PasswordEncoderFactories.createDelegatingPasswordEncoder()
//						.encode("admin123")).build();
		JdbcUserDetailsManager users = new JdbcUserDetailsManager(dataSource);
		users.setUsersByUsernameQuery("select username,password,enabled from users where username=?");
		users.setAuthoritiesByUsernameQuery("select username,roles, enabled from users where username=?");
//		users.createUser(userDetails);
		return users;
		
	}
	
	
	
	
	
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
		http.authorizeHttpRequests(auth -> auth
				.requestMatchers("/home").permitAll()
				.requestMatchers("/welcome").authenticated()
				.requestMatchers("/admin").hasAuthority("ADMIN")
				.requestMatchers("/emp").hasAuthority("EMP")
				.requestMatchers("/manager").hasAuthority("MANAGER")
				.requestMatchers("/qa").hasAuthority("QA")
				.requestMatchers("/common").hasAnyAuthority("EMP", "MANAGER", "QA")
				.anyRequest().authenticated())
		.formLogin(formLogin -> formLogin.defaultSuccessUrl("/welcome", true))
		.logout(logout -> logout.logoutUrl("/logout"))
		.exceptionHandling(eh -> eh.accessDeniedPage("/ad"));
		
		return http.build();
	}

}
