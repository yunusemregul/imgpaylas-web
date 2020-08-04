package com.imgpaylas.server;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.imgpaylas.server.model.Image;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Base64;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ImageAPITests
{
	@Autowired
	private WebApplicationContext webApplicationContext;

	@Autowired
	private ObjectMapper objectMapper;

	private MockMvc mockMvc;

	private static Long uploadedImageId;

	@Before()
	public void setup()
	{
		mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
	}

	@Test
	@WithMockUser(username = "test@imgpaylas.com")
	public void test1_uploadImage() throws Exception
	{
		String placeholder = "iVBORw0KGgoAAAANSUhEUgAAAAEAAAABCAYAAAAfFcSJAAAADUlEQVR42mP8/5+hHgAHggJ/PchI7wAAAABJRU5ErkJggg==";
		MockMultipartFile mockImage = new MockMultipartFile("image", "test.png", "image/png", Base64.getDecoder().decode(placeholder));

		MvcResult result = mockMvc.perform(
				MockMvcRequestBuilders
						.multipart("/api/v1/image/upload")
						.file(mockImage)
						.param("description", "Test description!")
		)
				.andExpect(status().isOk())
				.andReturn();

		String content = result.getResponse().getContentAsString();
		Image image = objectMapper.readValue(content, Image.class);
		uploadedImageId = image.getId();
	}

	@Test
	@WithMockUser(username = "test@imgpaylas.com")
	public void test4_deleteImage() throws Exception
	{
		mockMvc.perform(
				MockMvcRequestBuilders
						.delete("/api/v1/image/delete")
						.param("image_id", "" + uploadedImageId)
		)
				.andExpect(status().isOk());
	}

	@Test
	@WithMockUser(username = "test@imgpaylas.com")
	public void getAllImages() throws Exception
	{
		mockMvc.perform(
				MockMvcRequestBuilders
						.get("/api/v1/image/all")
		)
				.andExpect(status().isOk());
	}
}
