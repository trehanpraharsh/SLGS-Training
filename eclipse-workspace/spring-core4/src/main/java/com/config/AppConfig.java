package com.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;

import com.model.FixedAccount;
import com.model.LoanAccount;
import com.model.SalaryAccount;
import com.model.SavingAccount;
import com.service.CalculateService;

@Configuration

public class AppConfig {
	
	@Bean
	@Lazy
	public SavingAccount sa() {
		return new SavingAccount(5.5, 4);
	}
	@Bean
	@Lazy
	public FixedAccount fda() {
		return new FixedAccount(4.5, 7);
	}
	@Bean
	@Lazy
	public LoanAccount la() {
		return new LoanAccount(7.1, 4);
	}
	
	@Bean
	@Lazy
	public SalaryAccount sla() {
		return new SalaryAccount(8.5, 4);
	}
	
	@Bean
	@Lazy
	public CalculateService service() {
		return new CalculateService(fda());
	}
	

}
