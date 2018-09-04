package com.dynamic.urls.dao;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

import com.dynamic.urls.dao.DynamicURLDaoImpl;
import com.dynamic.urls.model.URLMapper;

@RunWith(MockitoJUnitRunner.class)
public class DynamicURLDaoImplTest {

	@InjectMocks
	DynamicURLDaoImpl dao;
	
	@Test
	public void testCreateURLMap() {
		String[] url1 = {"user", "Maria"};
		String[] url2 = {"user", "Marlo"};
		
		URLMapper urls = new URLMapper();
		List<String> list = new ArrayList<>();
		list.add("/user/Maria");
		list.add("/user/Marlo");
		urls.setUrls(list);
		
		Map<String, Integer> urlMap = new LinkedHashMap<String, Integer>();
		urlMap.put("user", 2);
		urlMap.put("Maria", 1);
		
		assertTrue(dao.createURLMap(url1));
		assertTrue(dao.updateURLMap(url2));
		
		Map<String, Integer> actualMap = dao.getURLMap();	
		assertTrue(actualMap.equals(urlMap));
		
	}
}
