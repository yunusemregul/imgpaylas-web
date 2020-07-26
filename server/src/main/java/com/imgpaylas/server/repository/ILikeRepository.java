package com.imgpaylas.server.repository;

import com.imgpaylas.server.model.Like;
import org.springframework.data.repository.CrudRepository;

public interface ILikeRepository extends CrudRepository<Like, Integer>
{
}
