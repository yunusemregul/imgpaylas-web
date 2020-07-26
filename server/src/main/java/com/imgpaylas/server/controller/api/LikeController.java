package com.imgpaylas.server.controller.api;

import com.imgpaylas.server.model.Like;
import com.imgpaylas.server.model.User;
import com.imgpaylas.server.repository.IImageRepository;
import com.imgpaylas.server.repository.ILikeRepository;
import com.imgpaylas.server.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

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

	@PostMapping(path = "/add")
	public @ResponseBody
	Like likeImage(@RequestParam Long image_id)
	{
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String email = auth.getName();

		Like newLike = new Like();
		newLike.setImage(imageRepository.findById(image_id));
		newLike.setUser(userRepository.findByEmail(email));

		return likeRepository.save(newLike);
	}


	@PostMapping(path = "/remove")
	public @ResponseBody
	void removeLike(@RequestParam Long image_id)
	{
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String email = auth.getName();

		Like like = likeRepository.findByUserAndImage(userRepository.findByEmail(email), imageRepository.findById(image_id));

		likeRepository.delete(like);
	}
}
