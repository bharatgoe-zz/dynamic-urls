package com.dynamic.urls.dao;

import java.util.Map;

/**
 * This class represents the Data Access Object layer for this project.
 * It has the responsibility of maintaining data objects
 * for given input.
 * 
 * @author BharatGoel
 *
 */
public interface DynamicURLDao {
	
	/**
	 * Creates a map for URL strings.
	 * 
	 * @param url
	 * @return boolean
	 */
	public boolean createURLMap(String[] url);

	/**
	 * Returns the map of URL strings.
	 * 
	 * @return Map<String, String>
	 */
	public Map<String, Integer> getURLMap();

	/**
	 * Updates the values of URL string Map, given
	 * the URL in the form of String array.
	 * 
	 * @param url
	 * @return boolean
	 */
	public boolean updateURLMap(String[] url);
	
}
