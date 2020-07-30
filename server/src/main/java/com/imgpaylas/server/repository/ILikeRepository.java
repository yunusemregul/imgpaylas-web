package com.imgpaylas.server.repository;

import com.imgpaylas.server.model.Image;
import com.imgpaylas.server.model.Like;
import com.imgpaylas.server.model.User;
import org.springframework.data.repository.CrudRepository;

public interface ILikeRepository extends CrudRepository<Like, Integer>
{
	Like findByUserAndImage(User user, Image image);
	Long countByImage(Image image);
}
