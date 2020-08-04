package com.imgpaylas.server;

import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class LikeAPITests
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
	@WithMockUser(username = "test@imgpaylas.com")
	public void test1_likeImage() throws Exception
	{
		mockMvc.perform(
				MockMvcRequestBuilders
						.post("/api/v1/like/image/1")
		)
				.andExpect(status().isOk());
	}

	@Test
	@WithMockUser(username = "test@imgpaylas.com")
	public void test2_removeLikeFromImage() throws Exception
	{
		mockMvc.perform(
				MockMvcRequestBuilders
						.delete("/api/v1/like/image/1")
		)
				.andExpect(status().isOk());
	}
}
