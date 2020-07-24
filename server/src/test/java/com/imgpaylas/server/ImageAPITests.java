package com.imgpaylas.server;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.security.test.context.support.WithUserDetails;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
public class ImageAPITests
{
	@Autowired
	private WebApplicationContext webApplicationContext;

	private MockMvc mockMvc;

	@Before()
	public void setup()
	{
		mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
	}

	@Test
	@WithMockUser(username = "testemail@go.com")
	public void uploadImage() throws Exception
	{
		MockMultipartFile mockImage = new MockMultipartFile("image", "test.png", "image/png", "data".getBytes());

		mockMvc.perform(
				MockMvcRequestBuilders
						.multipart("/api/v1/image/upload")
						.file(mockImage)
						.param("description", "Test description!")
		)
				.andExpect(status().isOk());
	}

	@Test
	@WithMockUser(username = "testemail@go.com")
	public void getAllImages() throws Exception
	{
		mockMvc.perform(
				MockMvcRequestBuilders
						.get("/api/v1/image/all")
		)
				.andExpect(status().isOk());
	}
}
