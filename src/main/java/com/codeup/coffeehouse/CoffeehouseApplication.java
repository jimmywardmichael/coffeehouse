package com.codeup.coffeehouse;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.codeup.coffeehouse.models")
public class CoffeehouseApplication {

	public static void main(String[] args) {
		SpringApplication.run(CoffeehouseApplication.class, args);
	}

}
