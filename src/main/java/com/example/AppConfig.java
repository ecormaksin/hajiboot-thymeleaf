package com.example;

import java.net.URI;
import java.net.URISyntaxException;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.sql.DataSource;

import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import lombok.RequiredArgsConstructor;
import net.sf.log4jdbc.sql.jdbcapi.DataSourceSpy;

@Profile("heroku")
@Configuration
@RequiredArgsConstructor
public class AppConfig {

	private final DataSourceProperties properties;
	
	@PersistenceContext
	private final EntityManager entityManager;
	
	DataSource dataSource;
	
	@RequiredArgsConstructor
	private class DBUserInfo {
		private final static int INDEX_USER_NAME = 0;
		private final static int INDEX_PASSWORD = 1;

		private final String userInfo;
		
		public String username() {
			return getProperty(INDEX_USER_NAME);
		}
		
		public String password() {
			return getProperty(INDEX_PASSWORD);
		}
		
		private String getProperty(int index) {
			return this.userInfo.split(":")[index];
		}
	}

	@Bean(destroyMethod = "close")
	DataSource realDataSource() throws URISyntaxException {
		
		String databaseUrl = System.getenv("DATABASE_URL");
		URI dbUri = new URI(databaseUrl);
		String url = "jdbc:log4jdbc:postgresql://" + dbUri.getHost() + dbUri.getPath() + ":" + dbUri.getPort() + dbUri.getPath();
		DBUserInfo dBUserInfo = new DBUserInfo(dbUri.getUserInfo());
		
		DataSourceBuilder<?> factory = DataSourceBuilder
				.create(this.properties.getClassLoader())
				.url(url)
				.username(dBUserInfo.username())
				.password(dBUserInfo.password());
		this.dataSource = factory.build();
		return this.dataSource;
	}
	
	@Bean
	DataSource dataSource() {
		return new DataSourceSpy(this.dataSource);
	}
	
	@Bean
	EntityManager entityManager() {
		return this.entityManager;
	}
}
