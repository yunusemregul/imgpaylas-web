package com.imgpaylas.server.repository;

import com.imgpaylas.server.model.Image;
import com.imgpaylas.server.model.User;
import org.springframework.data.repository.CrudRepository;

public interface IUserRepository extends CrudRepository<User, Integer>
{
	User findById(Long id);
	User findByEmail(String email);
}