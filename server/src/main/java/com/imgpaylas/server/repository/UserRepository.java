package com.imgpaylas.server.repository;

import com.imgpaylas.server.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Integer>
{
	User findByEmail(String email);
}