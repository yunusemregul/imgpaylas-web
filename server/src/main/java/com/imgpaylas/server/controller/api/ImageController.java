package com.imgpaylas.server.controller.api;

import com.imgpaylas.server.model.Image;
import com.imgpaylas.server.repository.IImageRepository;
import com.imgpaylas.server.repository.IUserRepository;
import com.imgpaylas.server.service.IImageStorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
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

	@PutMapping(path = "/upload")
	@ResponseBody
	public ResponseEntity<Image> uploadImage(@RequestParam("image") MultipartFile file, @RequestParam("description") String description)
	{

		// https://stackoverflow.com/a/4169776/12734824
		// https://stackoverflow.com/a/4427443/12734824
		try (InputStream input = file.getInputStream())
		{
			BufferedImage image = ImageIO.read(input);
			if (image != null) // eğer yüklenen dosya bir fotoğrafsa
			{
				// fotoğrafı 1x1 boyuta küçültüp ortalama rengini bulmuş oluyoruz
				java.awt.Image scaled = image.getScaledInstance(1, 1, java.awt.Image.SCALE_AREA_AVERAGING);
				BufferedImage scaledImage = new BufferedImage(1, 1, BufferedImage.TYPE_INT_ARGB);
				scaledImage.getGraphics().drawImage(scaled, 0, 0, null);
				Color avgColor = new Color(scaledImage.getRGB(0, 0));

				Authentication auth = SecurityContextHolder.getContext().getAuthentication();
				String email = auth.getName();

				Image newImage = new Image();
				newImage.setUser(userRepository.findByEmail(email));
				newImage.setDescription(description);
				newImage.setExtension(storageService.getImageExtension(file));
				newImage.setWidth(image.getWidth());
				newImage.setHeight(image.getHeight());
				newImage.setAvgColor(avgColor);

				newImage = imageRepository.save(newImage);
				storageService.store(newImage, file);

				return ResponseEntity.ok().body(newImage);
			} else
			{
				// TODO: hata: sadece fotoğraf dosyaları yüklenebilir
				return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).build();
			}
		} catch (IOException e)
		{
			e.printStackTrace();
			return ResponseEntity.badRequest().build();
		}
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
