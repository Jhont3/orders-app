package com.test.orders_app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan("com.test.orders_app.models")
@EnableJpaRepositories
public class OrdersAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(OrdersAppApplication.class, args);
	}

}
