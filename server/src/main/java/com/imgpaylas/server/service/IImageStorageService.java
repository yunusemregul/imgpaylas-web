package com.imgpaylas.server.service;

import com.imgpaylas.server.model.Image;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Path;


public interface IImageStorageService
{
	void init();

	void store(Image image, MultipartFile file);

	Path load(String filename);

	void delete(String filename);
}
