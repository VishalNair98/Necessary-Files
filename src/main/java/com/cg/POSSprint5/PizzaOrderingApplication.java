package com.cg.POSSprint5;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.cg")
public class PizzaOrderingApplication extends SpringBootServletInitializer{

	public static void main(String[] args) {
		SpringApplication.run(PizzaOrderingApplication.class, args);

	}

}
