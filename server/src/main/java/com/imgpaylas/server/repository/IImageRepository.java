package com.imgpaylas.server.repository;

import com.imgpaylas.server.model.Image;
import com.imgpaylas.server.model.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface IImageRepository extends CrudRepository<Image, Integer>
{
	Image findById(Long id);

	List<Image> findAllByUser(User user);

	boolean existsById(Long id);
}
