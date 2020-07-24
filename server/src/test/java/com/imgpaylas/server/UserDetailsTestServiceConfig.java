package com.imgpaylas.server;

import com.imgpaylas.server.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

import java.util.Arrays;
import java.util.HashSet;

@TestConfiguration
public class UserDetailsTestServiceConfig
{
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	@Bean
	@Primary
	public UserDetailsService userDetailsService()
	{
		User user = new User();
		user.setEmail("test@imgpaylas.com");
		user.setPasswordHash(bCryptPasswordEncoder.encode("password"));

		return new InMemoryUserDetailsManager(Arrays.asList(new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPasswordHash(), new HashSet<>())));
	}
}
