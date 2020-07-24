package com.imgpaylas.server.service;

import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Path;


public interface StorageService
{
	void init();

	void store(MultipartFile file);

	Path load(String filename);

	void delete(String filename);
}
