package com.dynamic.urls.model;

import java.util.List;

/**
 * Represents the data model for input of URL strings.
 * 
 * @author BharatGoel
 *
 */
public class URLMapper {

	private List<String> urls;

	/**
	 * Returns the list of url strings
	 * 
	 * @return
	 */
	public List<String> getUrls() {
		return urls;
	}

	/**
	 * Sets the list of url strings
	 * 
	 * @param urls
	 */
	public void setUrls(List<String> urls) {
		this.urls = urls;
	}
	
}
