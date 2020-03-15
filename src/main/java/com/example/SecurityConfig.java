package com.example;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.GlobalAuthenticationConfigurerAdapter;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import lombok.RequiredArgsConstructor;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	private static final String LOGIN_FORM_RELATIVE_PATH = "/loginForm";
	
	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring().antMatchers("/webjars/**", "/css/**");
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception{
		http
			.authorizeRequests()
			.antMatchers(LOGIN_FORM_RELATIVE_PATH).permitAll()
			.anyRequest().authenticated();
		http.formLogin()
			.loginProcessingUrl("/login")
			.loginPage(LOGIN_FORM_RELATIVE_PATH)
			.failureUrl(LOGIN_FORM_RELATIVE_PATH + "?error")
			.defaultSuccessUrl("/customers", true)
			.usernameParameter("username").passwordParameter("password")
			.and();
		http.logout()
			.logoutRequestMatcher(new AntPathRequestMatcher("/logout**"))
			.logoutSuccessUrl(LOGIN_FORM_RELATIVE_PATH);
	}
	
	@Configuration
	@RequiredArgsConstructor
	static class AuthenticationConfiguration extends GlobalAuthenticationConfigurerAdapter {
		
		private final UserDetailsService userDetailsService;
		
		@Bean
		PasswordEncoder passwordEncoder() {
			return new BCryptPasswordEncoder();
		}
		
		@Override
		public void init(AuthenticationManagerBuilder auth) throws Exception {
			auth.userDetailsService(userDetailsService)
					.passwordEncoder(passwordEncoder());
		}
	}
}
