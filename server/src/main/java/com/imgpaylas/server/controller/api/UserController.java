package com.imgpaylas.server.controller.api;

import com.imgpaylas.server.model.User;
import com.imgpaylas.server.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/user")
public class UserController
{
	@Autowired
	private IUserRepository userRepository;

	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	@PostMapping(path = "/register")
	public @ResponseBody
	String register(@RequestParam String name, @RequestParam String email, @RequestParam String password)
	{
		User newUser = new User();
		newUser.setName(name);
		newUser.setEmail(email);
		newUser.setPasswordHash(bCryptPasswordEncoder.encode(password));

		userRepository.save(newUser);
		return "Saved";
	}

	@GetMapping(path = "/all")
	public @ResponseBody
	Iterable<User> getAllUsers()
	{
		return userRepository.findAll();
	}
}
