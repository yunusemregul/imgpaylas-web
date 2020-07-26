package com.imgpaylas.server;

import com.imgpaylas.server.service.IImageStorageService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan(basePackages = {"com.imgpaylas.server.model"})
@EnableJpaRepositories(basePackages = {"com.imgpaylas.server.repository"})
public class ServerApplication
{

	public static void main(String[] args)
	{
		SpringApplication.run(ServerApplication.class, args);
	}

	@Bean
	CommandLineRunner init(IImageStorageService storageService)
	{
		return (args) ->
		{
			storageService.init();
		};
	}
}
