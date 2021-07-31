package com.main;

import static org.junit.Assert.assertNotEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
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
class TestlistURL {

	@Autowired
	private MockMvc mockMvc;
	
	@Test
	void test() {
		try
		{
		RequestBuilder request1=MockMvcRequestBuilders.post("/storeurl?url=google.com");
		MvcResult mvcresult1=mockMvc.perform(request1).andReturn();	
		RequestBuilder request2=MockMvcRequestBuilders.get("/list").accept(MediaType.APPLICATION_JSON);
		MvcResult mvcresult2=mockMvc.perform(request2).andReturn();
		assertNotEquals(1,mvcresult2.getResponse().getContentLength());
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}

}
