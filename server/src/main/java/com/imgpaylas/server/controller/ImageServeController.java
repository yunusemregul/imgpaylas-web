package com.imgpaylas.server.controller;

import com.imgpaylas.server.repository.IImageRepository;
import com.imgpaylas.server.service.IImageStorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("storage/images")
public class ImageServeController
{
	@Autowired
	private IImageStorageService storageService;

	@Autowired
	private IImageRepository imageRepository;

	@GetMapping(value = "/{image_id}")
	@ResponseBody
	public ResponseEntity<Resource> serveImage(@PathVariable Long image_id)
	{
		if (!imageRepository.existsById(image_id))
			return ResponseEntity.notFound().build();

		Resource file = storageService.loadAsResource(image_id);
		return ResponseEntity.ok().contentType(imageRepository.findById(image_id).getExtension().equals("png") ? MediaType.IMAGE_PNG : MediaType.IMAGE_JPEG).body(file);
	}
}
