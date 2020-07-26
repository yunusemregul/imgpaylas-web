package com.imgpaylas.server.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
public class Image
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id")
	@JsonIgnore
	@NotNull
	private User user;

	private String description;

	@NotNull
	private String extension;

	@JsonIgnore
	public String getImagePath()
	{
		return String.format("%d/%d.%s", user.getId(), id, extension);
	}

	@JsonProperty("url")
	@JsonInclude
	public String getURL()
	{
		return String.format("images/%d/%d.%s", user.getId(), id, extension);
	}

	@JsonProperty("user_id")
	@JsonInclude
	public Long getUserId()
	{
		return user.getId();
	}

	public Long getId()
	{
		return id;
	}

	public void setId(Long id)
	{
		this.id = id;
	}

	public User getUser()
	{
		return user;
	}

	public void setUser(User user)
	{
		this.user = user;
	}

	public String getDescription()
	{
		return description;
	}

	public void setDescription(String description)
	{
		this.description = description;
	}

	@JsonIgnore
	public String getExtension()
	{
		return extension;
	}

	public void setExtension(String extension)
	{
		this.extension = extension;
	}
}
