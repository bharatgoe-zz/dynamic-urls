package com.dynamic.urls.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.dynamic.urls.model.URLMapper;
import com.dynamic.urls.service.DynamicURLService;

/**
 * Main controller class for the application.
 * 
 * @author BharatGoel
 *
 */
@RestController
public class DynamicURLController {
	
	@Autowired
	DynamicURLService service;
	
	@RequestMapping(path = "/getmaskedurl", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<Object> getMaskedURL(@RequestBody URLMapper urls) {
		Object result = null;
		ResponseEntity<Object> response;
		HttpStatus status = HttpStatus.OK;
		
		result = service.findMaskedURL(urls);
		
		response = new ResponseEntity<Object>(result, status);
		return response;	
	}

}
