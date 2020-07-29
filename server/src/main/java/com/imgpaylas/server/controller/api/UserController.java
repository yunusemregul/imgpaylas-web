package com.imgpaylas.server.controller.api;

import com.imgpaylas.server.model.User;
import com.imgpaylas.server.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/user")
public class UserController
{
	@Autowired
	private IUserRepository userRepository;

	@GetMapping(path = "/all")
	public @ResponseBody
	Iterable<User> getAllUsers()
	{
		return userRepository.findAll();
	}
}
