package com.imgpaylas.server.model;

import javax.persistence.Entity;
import java.io.Serializable;
import java.util.Objects;

public class LikeId implements Serializable
{
	private long user;
	private long image;

	@Override
	public int hashCode()
	{
		return Objects.hash(user, image);
	}

	@Override
	public boolean equals(Object obj)
	{
		if (obj == null || getClass() != obj.getClass())
			return false;

		LikeId o = (LikeId) obj;
		return (user == o.getUser()) && (image == o.getImage());
	}

	public long getUser()
	{
		return user;
	}

	public void setUser(long user)
	{
		this.user = user;
	}

	public long getImage()
	{
		return image;
	}

	public void setImage(long image)
	{
		this.image = image;
	}
}
