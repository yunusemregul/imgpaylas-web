package com.imgpaylas.server.controller;

import com.imgpaylas.server.model.Image;
import com.imgpaylas.server.service.IImageStorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("images")
public class ImageServeController
{
	@Autowired
	private IImageStorageService storageService;

	@GetMapping(value = "/{user_id}/{image_id}")
	@ResponseBody
	public ResponseEntity<Resource> serveImage(@PathVariable Long user_id, @PathVariable Long image_id)
	{

		Resource file = storageService.loadAsResource(image_id);
		return ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + file.getFilename() + "\"").body(file);
	}
}
