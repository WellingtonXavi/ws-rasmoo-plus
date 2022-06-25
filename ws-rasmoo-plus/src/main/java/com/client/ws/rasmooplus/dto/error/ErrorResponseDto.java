package com.client.ws.rasmooplus.dto.error;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.http.HttpStatus;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class ErrorResponseDto {
	
	private String titulo;
	private HttpStatus status;
	private Integer statusCode;
	private LocalDateTime date_error;
	
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private List<FieldsErrors> fieldsErrors;
	
	

}
