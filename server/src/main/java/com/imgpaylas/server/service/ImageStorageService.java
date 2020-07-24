package com.imgpaylas.server.service;

import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

@Service
public class ImageStorageService implements StorageService
{
	private final Path root = Paths.get("images");

	@Override
	public void init()
	{
		try
		{
			Files.createDirectories(root);
		} catch (IOException e)
		{
			// TODO
			e.printStackTrace();
		}
	}

	@Override
	public void store(MultipartFile file)
	{
		String filename = StringUtils.cleanPath(file.getOriginalFilename());
		try (InputStream inputStream = file.getInputStream())
		{
			Files.copy(inputStream, this.root.resolve(filename),
					StandardCopyOption.REPLACE_EXISTING);
		} catch (IOException e)
		{
			e.printStackTrace();
		}
	}

	@Override
	public Path load(String filename)
	{
		return null;
	}

	@Override
	public void delete(String filename)
	{

	}
}
