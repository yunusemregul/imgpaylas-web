package com.imgpaylas.server.service;

import com.imgpaylas.server.model.Image;
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
public class ImageStorageService implements IImageStorageService
{
	private final Path root = Paths.get("images/users/");

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
	public void store(Image image, MultipartFile file)
	{
		String fileName = file.getOriginalFilename();
		String extension = fileName.substring(fileName.lastIndexOf(".") + 1);
		Path toSave = this.root.resolve(String.format("%d/%d.%s", image.getUser().getId(), image.getId(), extension));
		try (InputStream inputStream = file.getInputStream())
		{
			Files.createDirectories(toSave);
			Files.copy(inputStream, toSave,
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
