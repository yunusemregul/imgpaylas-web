package com.imgpaylas.server.model;

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
	private User user;

	@Column(unique = true)
	private String image_url;

	private String description;
}
