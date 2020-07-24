package com.imgpaylas.server.service;

import com.imgpaylas.server.model.Image;
import com.imgpaylas.server.repository.IImageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

@Service
public class ImageStorageService implements IImageStorageService
{
	@Autowired
	private IImageRepository imageRepository;

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
		Path toSave = this.root.resolve(getImagePath(image.getUser().getId(), image.getId(), getImageExtension(file)));
		try (InputStream inputStream = file.getInputStream())
		{
			Files.createDirectories(toSave);
			Files.copy(inputStream, toSave, StandardCopyOption.REPLACE_EXISTING);
		} catch (IOException e)
		{
			e.printStackTrace();
		}
	}

	@Override
	public Path load(Long imageId)
	{
		return root.resolve(getImagePath(imageId));
	}

	@Override
	public Resource loadAsResource(Long imageId)
	{
		try
		{
			Path file = load(imageId);
			Resource resource = new UrlResource(file.toUri());
			if (resource.exists() || resource.isReadable())
			{
				return resource;
			} else
			{
				// TODO
			}
		} catch (MalformedURLException e)
		{
			// TODO
			e.printStackTrace();
		}

		// TODO
		return null;
	}

	@Override
	public void delete(Long imageId)
	{

	}

	@Override
	public String getImagePath(Long imageId)
	{
		Image image = imageRepository.findById(imageId);

		return getImagePath(image.getUser().getId(), imageId, image.getExtension());
	}

	@Override
	public String getImagePath(Long userId, Long imageId, String extension)
	{
		return String.format("%d/%d.%s", userId, imageId, extension);
	}

	@Override
	public String getImageExtension(MultipartFile file)
	{
		String fileName = file.getOriginalFilename();
		return fileName.substring(fileName.lastIndexOf(".") + 1);
	}
}
