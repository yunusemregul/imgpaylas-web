package com.imgpaylas.server.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "images")
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

	@JsonProperty("desc")
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
		String hostUrl = ServletUriComponentsBuilder.fromCurrentContextPath().build().toUriString();
		return String.format("%s/images/%d/%d", hostUrl, user.getId(), id);
	}

	@JsonProperty("uid")
	@JsonInclude
	public Long getUserId()
	{
		return user.getId();
	}

	@JsonProperty("uname")
	@JsonInclude
	public String getUserName()
	{
		return user.getName();
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
