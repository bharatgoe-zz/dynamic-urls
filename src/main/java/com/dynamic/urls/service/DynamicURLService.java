package com.dynamic.urls.service;

import com.dynamic.urls.model.URLMapper;

/**
 * Represents the Service layer for this project.
 * It has the responsibility of processing the input URL strings,
 * using DataAccessObject layer.
 * 
 * @author BharatGoel
 *
 */
public interface DynamicURLService {
	
	/**
	 * Returns the masked URL, given the list of URL strings
	 * 
	 * @param urls
	 * @return masked URL
	 */
	public String findMaskedURL(URLMapper urls);


}
