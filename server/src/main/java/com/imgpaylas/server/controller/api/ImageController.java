package com.imgpaylas.server.controller.api;

import com.imgpaylas.server.model.Image;
import com.imgpaylas.server.repository.IImageRepository;
import com.imgpaylas.server.repository.IUserRepository;
import com.imgpaylas.server.service.IImageStorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Controller
@RequestMapping("api/v1/image")
public class ImageController
{
	@Autowired
	private IImageRepository imageRepository;

	@Autowired
	private IUserRepository userRepository;

	@Autowired
	private IImageStorageService storageService;

	@GetMapping(value = "user/{user_id}/{image_id}")
	@ResponseBody
	public Image imageInfo(@PathVariable Long user_id, @PathVariable Long image_id)
	{
		return imageRepository.findById(image_id);
	}

	@GetMapping(value = "user/{user_id}/all")
	@ResponseBody
	public List<Image> userAllImages(@PathVariable Long user_id)
	{
		return imageRepository.findAllByUser(userRepository.findById(user_id));
	}

	@GetMapping(path = "/all")
	public @ResponseBody
	Iterable<Image> getAllImages()
	{
		return imageRepository.findAll();
	}

	@PostMapping(path = "/upload")
	@ResponseBody
	public Image uploadImage(@RequestParam("image") MultipartFile file, @RequestParam("description") String description)
	{
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String email = auth.getName();

		Image newImage = new Image();
		newImage.setUser(userRepository.findByEmail(email));
		newImage.setDescription(description);
		newImage.setExtension(storageService.getImageExtension(file));

		newImage = imageRepository.save(newImage);
		storageService.store(newImage, file);

		return newImage;
	}

	@PostMapping(path = "/delete")
	@ResponseBody
	public void deleteImage(@RequestParam Long image_id)
	{
		Image image = imageRepository.findById(image_id);
		storageService.delete(image_id);
		imageRepository.delete(image);
	}
}