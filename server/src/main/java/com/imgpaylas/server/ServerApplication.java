package com.imgpaylas.server;

import com.imgpaylas.server.service.StorageService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EntityScan(basePackages = {"com.imgpaylas.server.model"})
public class ServerApplication
{

	public static void main(String[] args)
	{
		SpringApplication.run(ServerApplication.class, args);
	}

	@Bean
	CommandLineRunner init(StorageService storageService)
	{
		return (args) ->
		{
			storageService.init();
		};
	}
}
