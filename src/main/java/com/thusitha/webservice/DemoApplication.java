package com.thusitha.webservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(DemoApplication.class, args);
		CarSQLRepository carSQLRepository = (CarSQLRepository) context.getBean("carSQLRepository");
		CarNoSQLRepository carNoSQLRepository = (CarNoSQLRepository) context.getBean("carNoSQLRepository");
		CarSQL carSQL = new CarSQL("AB-123-CD", "BMW", 1200);
		carSQLRepository.save(carSQL);
		CarNoSQL carNoSQL = new CarNoSQL("AB-123-CD", "BMW", 1200);
		carNoSQLRepository.save(carNoSQL);
		
	}

}
