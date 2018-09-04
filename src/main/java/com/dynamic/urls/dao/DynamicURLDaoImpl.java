package com.dynamic.urls.dao;

import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.stereotype.Component;

/**
 * Implementation of DAO Layer
 * 
 * @author BharatGoel
 *
 */
@Component
public class DynamicURLDaoImpl implements DynamicURLDao{
	
	private Map<String, Integer> urlMap;
	
	public boolean createURLMap(String[] url) {
		urlMap = new LinkedHashMap<String, Integer>();
		
		for(int i = 0; i < url.length; i++) {
			urlMap.put(url[i], 1);
		}
		return true;
	}

	public Map<String, Integer> getURLMap() {
		return this.urlMap;
	}

	public boolean updateURLMap(String[] url) {
		for (int i = 0; i < url.length; i++) {
			if (urlMap.containsKey(url[i])) {
				Integer value = urlMap.get(url[i]);
				urlMap.put(url[i], value+1);
			}
		}
		return true;
	}

}
