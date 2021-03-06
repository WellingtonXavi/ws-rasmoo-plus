package com.client.ws.rasmooplus.dto;

import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserTypeDto {
	
	
	@NotBlank
	private String name;
	
	@NotBlank
	private String description;

}
