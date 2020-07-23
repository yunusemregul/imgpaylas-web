package com.imgpaylas.server.controller;

import com.imgpaylas.server.model.User;
import com.imgpaylas.server.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/users")
public class UserController
{
	@Autowired
	private UserRepository userRepository;

	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	@PostMapping(path = "/add")
	public @ResponseBody
	String addNewUser(@RequestParam String name, @RequestParam String email, @RequestParam String password)
	{
		User n = new User();
		n.setName(name);
		n.setEmail(email);
		n.setPasswordHash(bCryptPasswordEncoder.encode(password));

		userRepository.save(n);
		return "Saved";
	}

	@GetMapping(path = "/all")
	public @ResponseBody
	Iterable<User> getAllUsers()
	{
		return userRepository.findAll();
	}
}
