package com.dynamic.urls.util;

import java.util.Map;
import java.util.Set;

/**
 * The util class - consists of all the common methods
 * 
 * @author BharatGoel
 *
 */
public class DynamicURLUtils {

	/**
	 * Given a URL string, and the delimiter, it splits the string,
	 * and returns a String array.
	 * 
	 * @param input
	 * @param delimiter
	 * @return String array
	 */
	public static String[] tokenizeString(String input, String delimiter) {
		String[] incomingArray = input.split(delimiter);

		String[] outgoingArray = new String[incomingArray.length - 1];
		System.arraycopy(incomingArray, 1, outgoingArray, 0, outgoingArray.length);
		
		return outgoingArray;
	}

	/**
	 * Creates and returns the masked url, given the URL Map, and size of input.
	 * 
	 * @param urlMap
	 * @param size
	 * @return masked URL
	 */
	public static String createMaskedURL(Map<String, Integer> urlMap, int size) {
		StringBuilder builder = new StringBuilder();

		Set<String> keys = urlMap.keySet();
		String dynamicStringToken = "";
		for (String key : keys) {
			if (urlMap.get(key) == size) {
				builder.append("/" + key);
				dynamicStringToken = key + "_name";
			} else {
				builder.append("/" + "*" + dynamicStringToken + "*");
			}
		}

		return builder.toString();
	}

}
