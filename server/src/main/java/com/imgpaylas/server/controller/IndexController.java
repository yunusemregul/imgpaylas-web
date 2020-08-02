package com.imgpaylas.server.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController
{
	@GetMapping({"/login", "/register", "/", "/home", "/likes", "/profile"}) // TODO: daha iyi bir yol bulunmalı
	public String index()
	{
		return "index.html";
	}
}
