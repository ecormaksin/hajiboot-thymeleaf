package com.example;

import org.apache.commons.lang3.StringUtils;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class App {

	@GetMapping("/home")
	String home() {
		StringBuffer sb = new StringBuffer();
		
		sb.append( getEnvVar("DATABASE_URL") );
		sb.append( getEnvVar("JDBC_DATABASE_URL") );
		sb.append( getEnvVar("JDBC_DATABASE_USERNAME") );
		sb.append( getEnvVar("JDBC_DATABASE_PASSWORD") );
		sb.append( getEnvVar("SPRING_DATASOURCE_URL") );
		sb.append( getEnvVar("SPRING_DATASOURCE_USERNAME") );
		sb.append( getEnvVar("SPRING_DATASOURCE_PASSWORD") );

		return "Test " + sb.toString();
	}
	
	public static void main(String[] args) {
		SpringApplication.run(App.class, args);
	}

	private static String getEnvVar(String key) {
		return key + ": " + StringUtils.defaultString(System.getenv(key), "unavailable") + "<br/>";
	}
}
