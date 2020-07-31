package com.imgpaylas.server.controller.api;

import com.imgpaylas.server.model.User;
import com.imgpaylas.server.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("api/v1/auth")
public class UserAuthController
{
	@Autowired
	private IUserRepository userRepository;

	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	@Autowired
	private AuthenticationManager authenticationManager;

	// TODO: hatalı giriş sayısını limitlemek

	@PostMapping(path = "/login")
	public @ResponseBody
	ResponseEntity<String> login(@RequestParam String email, @RequestParam String password)
	{
		try
		{
			final Authentication authentication = authenticationManager.authenticate(
					new UsernamePasswordAuthenticationToken(
							email,
							password
					)
			);

			SecurityContextHolder.getContext().setAuthentication(authentication);
			return ResponseEntity.ok().build();
		} catch (Exception e)
		{
			return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body(e.getMessage());
		}
	}

	@PostMapping(path = "/register")
	public @ResponseBody
	Object register(@RequestParam String name, @RequestParam String email, @RequestParam String password)
	{
		User newUser = new User();
		newUser.setName(name);
		newUser.setEmail(email);
		newUser.setPasswordHash(bCryptPasswordEncoder.encode(password));

		try
		{
			return userRepository.save(newUser);
		} catch (DataIntegrityViolationException e)
		{
			return ResponseEntity.badRequest().body(e.getMostSpecificCause().getMessage());
		}
	}
}
