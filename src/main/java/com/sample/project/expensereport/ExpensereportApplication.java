package com.sample.project.expensereport;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({ "com.sample.project.expensereport" })
public class ExpensereportApplication {

	public static void main(String[] args) {
		SpringApplication.run(ExpensereportApplication.class, args);
	}

}

