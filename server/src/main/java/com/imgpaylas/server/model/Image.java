package com.imgpaylas.server.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.imgpaylas.server.converter.ColorConverter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

// TODO: created_at gibi bir field

@Entity
@Table(name = "images")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"}) // TODO: understand what this is
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

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "image")
	@JsonIgnore
	private List<Like> likes = new ArrayList<Like>();

	@NotNull
	private String extension;

	@NotNull
	@JsonProperty("w")
	private int width;

	@NotNull
	@JsonProperty("h")
	private int height;

	@NotNull
	@Convert(converter = ColorConverter.class)
	@Column(name = "avg_color")
	@JsonIgnore
	private Color avgColor; // fotoğrafın ortalama rengi, kullanıcılar fotoğrafı indirmeyi beklerken en azından rengini göstermek için

	@JsonProperty("col")
	@JsonInclude
	public String getColorString()
	{
		return avgColor.getRed() + "," +
				avgColor.getGreen() +
				"," +
				avgColor.getBlue();
	}

	@JsonProperty("likes")
	@JsonInclude
	public int getLikesCount()
	{
		return likes.size();
	}

	@JsonIgnore
	public String getImagePath()
	{
		return String.format("%d/%d.%s", user.getId(), id, extension);
	}

	@JsonProperty("url")
	@JsonInclude
	public String getURL()
	{
		return String.format("/images/%d/%d", user.getId(), id);
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

	public int getWidth()
	{
		return width;
	}

	public void setWidth(int width)
	{
		this.width = width;
	}

	public int getHeight()
	{
		return height;
	}

	public void setHeight(int height)
	{
		this.height = height;
	}

	public Color getAvgColor()
	{
		return avgColor;
	}

	public void setAvgColor(Color avgColor)
	{
		this.avgColor = avgColor;
	}

	public List<Like> getLikes()
	{
		return likes;
	}

	public void setLikes(List<Like> likes)
	{
		this.likes = likes;
	}

}
