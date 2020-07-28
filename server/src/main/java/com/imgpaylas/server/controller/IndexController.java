package com.imgpaylas.server.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController
{
	@GetMapping({"/login", "/register", "/", "/home"})
	public String index()
	{
		return "index.html";
	}
}
