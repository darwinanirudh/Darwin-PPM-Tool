package com.concordia.domain;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

@Service
public class MapErrorValidatorService {

	public Map<String,String> MapErrorValidator(BindingResult result) {
		
		Map<String,String> errorMap = new HashMap<String,String>();
		
		for(FieldError error : result.getFieldErrors()) {
			
			errorMap.put(error.getField(), error.getDefaultMessage());
		}
	
		return errorMap;
		
	}
	
}
