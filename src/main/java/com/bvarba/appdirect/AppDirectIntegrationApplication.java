package com.bvarba.appdirect;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@ComponentScan
@Configuration
@EnableAutoConfiguration 
@SpringBootApplication 
public class AppDirectIntegrationApplication {

	public static void main(String[] args) {
		SpringApplication.run(AppDirectIntegrationApplication.class, args);
	}
	@Bean
	public EmbeddedServletContainerCustomizer containerCustomizer() {
	    return (container -> {
	        container.setContextPath("");
	        container.setPort(Integer.valueOf(System.getenv("PORT")));  
	    });
	}
}
