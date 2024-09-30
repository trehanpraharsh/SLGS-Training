package com.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.examples.account.repository.AccountRepository;
import com.examples.account.repository.InMemoryAccountRepository;
import com.examples.account.service.TransferServiceImpl;

@Configuration

public class AppConfig {
	
	//do we need to create one for accountrepo as well? bcs it needs account object
	
	@Bean
	public InMemoryAccountRepository accountRepository() {
		//not sure whether or not we need to pass account here?
		return new InMemoryAccountRepository();
	}
	
	
	@Bean
	public TransferServiceImpl transferService() {
		return new TransferServiceImpl(accountRepository());
	}
	

}
