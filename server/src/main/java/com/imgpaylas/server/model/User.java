package com.imgpaylas.server.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.stream.Collectors;

@Entity
@Table(name = "users")
public class User
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotNull
	@Column(name = "password_hash")
	private String passwordHash;

	@NotNull
	private String name;

	@Column(unique = true)
	private String email;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
	@JsonIgnore
	private List<Like> likes;

	public List<Long> getLikedImageIds()
	{
		return likes.stream().map(Like::getImageId).collect(Collectors.toList());
	}

	public List<Like> getLikes()
	{
		return likes;
	}

	public Long getId()
	{
		return id;
	}

	public void setId(Long id)
	{
		this.id = id;
	}

	@JsonIgnore
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