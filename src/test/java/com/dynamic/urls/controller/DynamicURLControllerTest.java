package com.dynamic.urls.controller;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.dynamic.urls.controller.DynamicURLController;
import com.dynamic.urls.model.URLMapper;
import com.dynamic.urls.service.DynamicURLService;

@RunWith(SpringRunner.class)
@WebMvcTest(value = DynamicURLController.class, secure = false)
public class DynamicURLControllerTest {
	
	@InjectMocks
	DynamicURLController controller;
	
	@MockBean
	DynamicURLService service;

	private MockMvc mockMvc;
	
	@Autowired 
	private WebApplicationContext wac;
	
	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
		mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();  
	}
	
	@Test
	public void test() throws Exception {
		String expectedOutput = "/user/*user_name*";
		String inputJson = "{ \"urls\": [\"/user/Maria\", \"/user/Marlo\"] }";
		
		Mockito.when(service.findMaskedURL(Mockito.any(URLMapper.class))).thenReturn(expectedOutput);
		
		RequestBuilder rb = MockMvcRequestBuilders.post("/getmaskedurl").accept(MediaType.APPLICATION_JSON)
				.content(inputJson).contentType(MediaType.APPLICATION_JSON);
		MvcResult result = mockMvc.perform(rb).andReturn();
				
		assertTrue(result.getResponse().getStatus() == 200);
		assertTrue(result.getResponse().getContentAsString().equals(expectedOutput));	
	}

}
