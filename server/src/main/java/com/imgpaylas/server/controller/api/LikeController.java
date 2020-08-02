package com.imgpaylas.server.controller.api;

import com.imgpaylas.server.model.Image;
import com.imgpaylas.server.model.Like;
import com.imgpaylas.server.model.User;
import com.imgpaylas.server.repository.IImageRepository;
import com.imgpaylas.server.repository.ILikeRepository;
import com.imgpaylas.server.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/like")
public class LikeController
{
	@Autowired
	private ILikeRepository likeRepository;

	@Autowired
	private IUserRepository userRepository;

	@Autowired
	private IImageRepository imageRepository;

	@GetMapping(path = "/image/{image_id}")
	@ResponseBody
	public Long imageLikes(@PathVariable Long image_id)
	{
		return likeRepository.countByImage(imageRepository.findById(image_id));
	}

	@GetMapping(path = "/my_likes")
	@ResponseBody
	public List<Long> userLikes()
	{
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String email = auth.getName();

		return userRepository.findByEmail(email).getLikes();
	}

	@GetMapping(path = "/my_likes/{image_id}")
	@ResponseBody
	public boolean userLikedImage(@PathVariable Long image_id)
	{
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String email = auth.getName();

		Like like = likeRepository.findByUserAndImage(userRepository.findByEmail(email), imageRepository.findById(image_id));

		return like != null;
	}

	@PutMapping(path = "/image/{image_id}")
	public @ResponseBody
	Like likeImage(@PathVariable Long image_id)
	{
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String email = auth.getName();

		Like newLike = new Like();
		newLike.setImage(imageRepository.findById(image_id));
		newLike.setUser(userRepository.findByEmail(email));

		return likeRepository.save(newLike);
	}


	@DeleteMapping(path = "/image/{image_id}")
	public @ResponseBody
	void removeLike(@PathVariable Long image_id)
	{
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String email = auth.getName();

		Like like = likeRepository.findByUserAndImage(userRepository.findByEmail(email), imageRepository.findById(image_id));

		likeRepository.delete(like);
	}
}
