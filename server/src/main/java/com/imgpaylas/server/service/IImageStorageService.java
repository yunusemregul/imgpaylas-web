package com.imgpaylas.server.service;

import com.imgpaylas.server.model.Image;
import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Path;


public interface IImageStorageService
{
	void init();

	void store(Image image, MultipartFile file);

	Path load(Long imageId);

	Resource loadAsResource(Long imageId);

	void delete(Long imageId);

	String getImageExtension(MultipartFile file);
}
