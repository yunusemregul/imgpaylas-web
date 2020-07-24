package com.imgpaylas.server.model;

import com.fasterxml.jackson.annotation.JsonValue;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
public class User
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JsonValue // TODO: returns null
	private Long id;

	@NotNull
	@Column(name = "password_hash")
	private String passwordHash;

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

	public String getPasswordHash()
	{
		return passwordHash;
	}

	public void setPasswordHash(String passwordHash)
	{
		this.passwordHash = passwordHash;
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
}