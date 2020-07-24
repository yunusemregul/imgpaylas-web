package com.imgpaylas.server.controller;

import com.imgpaylas.server.service.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("api/v1/images")
public class ImageUploadController
{
	@Autowired
	private StorageService storageService;

	@PostMapping(path = "/upload")
	public @ResponseBody
	String uploadImage(@RequestParam("image") MultipartFile file)
	{
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String name = auth.getName();
		storageService.store(file);
		return "Success! " + name;
	}
}
