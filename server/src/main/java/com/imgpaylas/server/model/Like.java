package com.imgpaylas.server.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "likes")
@IdClass(LikeId.class)
public class Like
{
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id")
	@Id
	private User user;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "image_id")
	@Id
	private Image image;

	@JsonProperty("uid")
	@JsonInclude
	public Long getUserId()
	{
		return user.getId();
	}

	@JsonProperty("iid")
	@JsonInclude
	public Long getImageId()
	{
		return image.getId();
	}

	@JsonIgnore
	public User getUser()
	{
		return user;
	}

	public void setUser(User user)
	{
		this.user = user;
	}

	@JsonIgnore
	public Image getImage()
	{
		return image;
	}

	public void setImage(Image image)
	{
		this.image = image;
	}
}
