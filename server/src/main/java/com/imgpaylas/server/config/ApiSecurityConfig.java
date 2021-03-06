package com.imgpaylas.server.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class ApiSecurityConfig extends WebSecurityConfigurerAdapter
{
	@Override
	protected void configure(HttpSecurity http) throws Exception
	{
		http
				/*.csrf().disable()
				.authorizeRequests()
				.anyRequest()
				.permitAll();*/
				.csrf().disable()
				.authorizeRequests()
				.antMatchers("/api/**/user/register", "/register", "/api/**/auth/**")
				.permitAll()
				.antMatchers(
						HttpMethod.GET,
						"/index*", "/static/**", "/*.js", "/*.json", "/*.ico")
				.permitAll()
				.anyRequest().authenticated()
				.and()
				.formLogin()
				.loginPage("/login")
				.permitAll()
				.usernameParameter("email")
				.loginProcessingUrl("/login")
				.defaultSuccessUrl("/home", true)
				.failureUrl("/login?error=true");
	}

	@Bean
	public AuthenticationManager authenticationManagerBean() throws Exception
	{
		return super.authenticationManagerBean();
	}

	@Bean
	public BCryptPasswordEncoder bCryptPasswordEncoder()
	{
		return new BCryptPasswordEncoder();
	}
}
