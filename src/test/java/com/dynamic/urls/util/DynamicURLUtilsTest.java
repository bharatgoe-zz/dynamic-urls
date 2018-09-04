package com.dynamic.urls.util;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;

import com.dynamic.urls.model.URLMapper;
import com.dynamic.urls.util.DynamicURLUtils;

public class DynamicURLUtilsTest {

	@Test
	public void testTokenizeString() {
		String input = "/user/Maria/info/location";
		String delimiter = "/";
		
		String[] expectedOutput = {"user", "Maria", "info", "location"};
		String[] actualOutput = DynamicURLUtils.tokenizeString(input, delimiter);
		
		assertTrue(Arrays.equals(actualOutput, expectedOutput));
	}

	@Test
	public void testCreateMaskedURL() {
		Map<String, Integer> urlMap = new LinkedHashMap<String, Integer>();
		urlMap.put("user", 2);
		urlMap.put("Maria", 1);
		
		URLMapper urls = new URLMapper();
		List<String> list = new ArrayList<>();
		list.add("/user/Maria");
		list.add("/user/Marlo");
		urls.setUrls(list);
		
		String expectedOutput = "/user/*user_name*";
		String actualOutput = DynamicURLUtils.createMaskedURL(urlMap, 2);

		assertTrue(actualOutput.equals(expectedOutput));
	}

}
