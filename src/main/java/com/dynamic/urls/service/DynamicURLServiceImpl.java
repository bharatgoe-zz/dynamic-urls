package com.dynamic.urls.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.dynamic.urls.dao.DynamicURLDao;
import com.dynamic.urls.model.URLMapper;
import com.dynamic.urls.util.DynamicURLUtils;

/**
 * Implementation of Service layer.
 * 
 * @author BharatGoel
 *
 */
@Component
public class DynamicURLServiceImpl implements DynamicURLService {

	@Autowired
	DynamicURLDao dao;
	
	public String findMaskedURL(URLMapper urls) {
		int numOfURLs = urls.getUrls().size();
		String[] firstArr = DynamicURLUtils.tokenizeString(urls.getUrls().get(0), "/");	
		dao.createURLMap(firstArr);
		
		urls.getUrls().remove(0);
		
		urls.getUrls().forEach(url-> {
			String[] arr = DynamicURLUtils.tokenizeString(url, "/");
			dao.updateURLMap(arr);
		});
		
		Map<String, Integer> keyMap = dao.getURLMap();
        
		return DynamicURLUtils.createMaskedURL(keyMap, numOfURLs);
	}

}
