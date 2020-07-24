package com.imgpaylas.server.service;

import com.imgpaylas.server.model.User;
import com.imgpaylas.server.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.HashSet;

@Service
public class SqlUserDetailsService implements UserDetailsService
{
	@Autowired
	private IUserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException
	{
		User user = userRepository.findByEmail(email);

		if (user == null)
			throw new UsernameNotFoundException(email);

		return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPasswordHash(), new HashSet<>());
	}
}
