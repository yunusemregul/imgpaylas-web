package com.imgpaylas.server.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.*;
import org.springframework.web.servlet.view.InternalResourceViewResolver;


@Configuration
public class MvcConfig implements WebMvcConfigurer
{

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry)
	{

		registry.addResourceHandler("/static/**")
				.addResourceLocations("/WEB-INF/view/frontend/build/static/");
		registry.addResourceHandler("/*.js")
				.addResourceLocations("/WEB-INF/view/frontend/build/");
		registry.addResourceHandler("/*.json")
				.addResourceLocations("/WEB-INF/view/frontend/build/");
		registry.addResourceHandler("/*.ico")
				.addResourceLocations("/WEB-INF/view/frontend/build/");
		registry.addResourceHandler("/index.html")
				.addResourceLocations("/WEB-INF/view/frontend/build/index.html");
	}
}