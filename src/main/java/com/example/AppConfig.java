package com.example;

import java.net.URI;
import java.net.URISyntaxException;

import javax.sql.DataSource;

import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;

import lombok.RequiredArgsConstructor;
import net.sf.log4jdbc.sql.jdbcapi.DataSourceSpy;

//@Profile("heroku")
//@Configuration
@RequiredArgsConstructor
public class AppConfig {

	private final DataSourceProperties properties;

	DataSource dataSource;
	
	@Bean(destroyMethod = "close")
	DataSource realDataSource() throws URISyntaxException {
		
		URI dbUri = new URI(System.getenv("DATABASE_URL"));

		String[] userInfo = dbUri.getUserInfo().split(":");
		String username = userInfo[0];
		String password = userInfo[1];
		String dbUrl = "jdbc:log4jdbc:postgresql://" + dbUri.getHost() + ':' + dbUri.getPort() + dbUri.getPath() + "?sslmode=require";

		DataSourceBuilder<?> factory = DataSourceBuilder
				.create(this.properties.getClassLoader())
				.url(dbUrl)
				.username(username)
				.password(password);
		this.dataSource = factory.build();

		return this.dataSource;
	}

	@Bean
	DataSource dataSource() {
		return new DataSourceSpy(this.dataSource);
	}
	
	@Bean
	LocalContainerEntityManagerFactoryBean entityManagerFactory(EntityManagerFactoryBuilder builder) throws URISyntaxException {
		return builder
					.dataSource(dataSource())
					.build();
	}
}
