package com.imgpaylas.server.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/*
	TODO:
	  react routerle sayfa değişince client side değil servere istek gönderip refreshliyor incelenmesi gerek
 */

@Controller
public class IndexController
{
	@GetMapping({"/login", "/register", "/", "/home", "/likes", "/profile"}) // daha iyi bir yol bulunmalı
	public String index()
	{
		return "index.html";
	}
}
