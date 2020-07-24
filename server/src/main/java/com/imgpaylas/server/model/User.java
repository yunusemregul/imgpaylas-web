package com.imgpaylas.server.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
public class User
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotNull
	private String password_hash;

	@NotNull
	private String name;

	@Column(unique = true)
	private String email;

	public Long getId()
	{
		return id;
	}

	public void setId(Long id)
	{
		this.id = id;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public String getEmail()
	{
		return email;
	}

	public void setEmail(String email)
	{
		this.email = email;
	}

	public String getPasswordHash()
	{
		return password_hash;
	}

	public void setPasswordHash(String passwordHash)
	{
		this.password_hash = passwordHash;
	}
}