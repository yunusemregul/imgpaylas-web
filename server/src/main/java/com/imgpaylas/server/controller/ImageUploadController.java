package com.imgpaylas.server.controller;

import com.imgpaylas.server.model.Image;
import com.imgpaylas.server.repository.IImageRepository;
import com.imgpaylas.server.repository.IUserRepository;
import com.imgpaylas.server.service.IImageStorageService;
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
	private IImageRepository imageRepository;

	@Autowired
	private IUserRepository userRepository;

	@Autowired
	private IImageStorageService storageService;

	@PostMapping(path = "/upload")
	public @ResponseBody
	String uploadImage(@RequestParam("image") MultipartFile file, @RequestParam("description") String description)
	{
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String email = auth.getName();

		Image newImage = new Image();
		newImage.setUser(userRepository.findByEmail(
				email
		));
		newImage.setDescription(description);

		newImage = imageRepository.save(newImage);
		storageService.store(newImage, file);

		return "Success! " + email;
	}
}
