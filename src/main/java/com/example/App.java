package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class App {

	@GetMapping("/home")
	String home() {
		outputEnvVar("DATABASE_URL");
		outputEnvVar("JDBC_DATABASE_URL");
		outputEnvVar("JDBC_DATABASE_USERNAME");
		outputEnvVar("JDBC_DATABASE_PASSWORD");
		outputEnvVar("SPRING_DATASOURCE_URL");
		outputEnvVar("SPRING_DATASOURCE_USERNAME");
		outputEnvVar("SPRING_DATASOURCE_PASSWORD");

		return "Test";
	}
	
	public static void main(String[] args) {
		SpringApplication.run(App.class, args);
	}

	private static void outputEnvVar(String key) {
		if (null == System.getenv(key)) return;
		System.out.println(key + ": " + System.getenv(key));
	}
}
