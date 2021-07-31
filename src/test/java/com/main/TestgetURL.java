package com.main;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class TestgetURL {
	
	@Autowired
	private MockMvc mockMvc;

	@Test
	public void test() {
		try
		{
		RequestBuilder storerequest=MockMvcRequestBuilders.post("/storeurl?url=google.com");
		mockMvc.perform(storerequest);
		RequestBuilder request=MockMvcRequestBuilders.get("/get?url=google.com").accept(MediaType.APPLICATION_JSON);
		MvcResult result=mockMvc.perform(request).andReturn();
		assertNotEquals(null,result.getResponse().getContentAsString());
		RequestBuilder getrequest=MockMvcRequestBuilders.get("/count?url=google.com").accept(MediaType.APPLICATION_JSON);
		result=mockMvc.perform(getrequest).andReturn();
		assertEquals(1,result.getResponse().getContentAsString());
		
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

}
