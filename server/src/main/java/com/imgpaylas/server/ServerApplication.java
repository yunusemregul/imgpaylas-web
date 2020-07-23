package com.imgpaylas.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan(basePackages = {"com.imgpaylas.server.model"})
public class ServerApplication
{

	public static void main(String[] args)
	{
		SpringApplication.run(ServerApplication.class, args);
	}
}
