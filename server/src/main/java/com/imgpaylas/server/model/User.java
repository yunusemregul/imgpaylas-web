package com.imgpaylas.server.model;

import javax.persistence.*;

@Entity // This tells Hibernate to make a table out of this class
public class User
{
	@Id
	@GeneratedValue
	private long id;

	private String name;

	@Column(unique = true)
	private String email;

	public long getId()
	{
		return id;
	}

	public void setId(Integer id)
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
}