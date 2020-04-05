package com.example.service;

import org.springframework.security.core.authority.AuthorityUtils;

import lombok.EqualsAndHashCode;
import lombok.Getter;

@Getter
@EqualsAndHashCode(callSuper=false)
public class LoginUserDetails extends org.springframework.security.core.userdetails.User {
	private static final long serialVersionUID = 1L;

	private final com.example.domain.model.user.User user;
	
	public LoginUserDetails(com.example.domain.model.user.User user) {
		super(user.getUsername(), user.getEncodedPassword(), AuthorityUtils.createAuthorityList("ROLE_USER"));
		this.user = user;
	}
}
