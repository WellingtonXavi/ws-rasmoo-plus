package com.client.ws.rasmooplus.dto.error;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class FieldsErrors {
	
	private String field;
	
	private String message;
	

}
