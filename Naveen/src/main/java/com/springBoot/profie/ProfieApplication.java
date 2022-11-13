package com.springBoot.profie;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;

@SpringBootApplication
public class ProfieApplication {

	public static void main(String[] args) {
		//SpringApplication.run(ProfieApplication.class, args);

		ApplicationContext applicationContext = SpringApplication.run(ProfieApplication.class, args);
		for(String name:applicationContext.getBeanDefinitionNames()){
			System.out.println(name);
		}
	}
	@Profile("dev")
	@Bean
	public String devBean(){
		return "DevBean";
	}

	@Profile("prod")
	@Bean
	public String prodBean(){
		return "ProdBean";
	}
	@Profile("test")
	@Bean
	public String testBean(){
		return "TestBean";
	}
}
