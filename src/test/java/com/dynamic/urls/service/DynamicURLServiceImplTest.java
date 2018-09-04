package com.dynamic.urls.service;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.dynamic.urls.dao.DynamicURLDao;
import com.dynamic.urls.model.URLMapper;
import com.dynamic.urls.service.DynamicURLServiceImpl;

@RunWith(MockitoJUnitRunner.class)
public class DynamicURLServiceImplTest {
	
	@Mock
	DynamicURLDao dao;
	
	@InjectMocks
	DynamicURLServiceImpl service;

	@Test
	public void testFindMaskedURL() {
		String[] url = {"user", "Maria"};
		String[] url2 = {"user", "Marlo"};
		
		Map<String, Integer> urlMap = new LinkedHashMap<String, Integer>();
		urlMap.put("user", 2);
		urlMap.put("Maria", 1);
		
		URLMapper urls = new URLMapper();
		List<String> list = new ArrayList<>();
		list.add("/user/Maria");
		list.add("/user/Marlo");
		urls.setUrls(list);
		
		Mockito.when(dao.createURLMap(url)).thenReturn(true);
		Mockito.when(dao.updateURLMap(url2)).thenReturn(true);
		Mockito.when(dao.getURLMap()).thenReturn(urlMap);
		
		String actualOutput = service.findMaskedURL(urls);
		String expectedOutput = "/user/*user_name*";
		
		assertTrue(actualOutput.equals(expectedOutput));
		
	}

}
