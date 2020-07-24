package com.imgpaylas.server.controller;

import com.imgpaylas.server.model.Image;
import com.imgpaylas.server.repository.ImageRepository;
import com.imgpaylas.server.repository.UserRepository;
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
	private ImageRepository imageRepository;

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private StorageService storageService;

	@PostMapping(path = "/upload")
	public @ResponseBody
	String uploadImage(@RequestParam("image") MultipartFile file, @RequestParam("description") String description)
	{
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String email = auth.getName();
		storageService.store(file);

		System.out.println(email);
		System.out.println(userRepository.findByEmail(email));

		Image newImage = new Image();
		newImage.setUser(userRepository.findByEmail(
				email
		));
		newImage.setDescription(description);

		imageRepository.save(newImage);

		return "Success! " + email;
	}
}
