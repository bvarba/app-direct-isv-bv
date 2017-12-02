package com.bvarba.appdirect;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@ComponentScan
@Configuration
@SpringBootApplication 
public class AppDirectIntegrationApplication {

	public static void main(String[] args) {
		SpringApplication.run(AppDirectIntegrationApplication.class, args);
	}
}
