package com.imgpaylas.server.repository;

import com.imgpaylas.server.model.Image;
import org.springframework.data.repository.CrudRepository;

public interface ImageRepository extends CrudRepository<Image, Integer>
{
}
