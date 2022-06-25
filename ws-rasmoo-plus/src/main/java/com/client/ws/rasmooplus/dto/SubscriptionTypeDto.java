package com.client.ws.rasmooplus.dto;

import java.math.BigDecimal;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SubscriptionTypeDto {
	
	@NotBlank(message = "Campo obrigatório")
	private String name;
	
	@Max(value = 12, message = "Máximo 12")
	private Long accessMonths;
	
	@NotNull(message = "campo obrigatorio")
	private BigDecimal price;
	
	@NotBlank(message = "Campo obrigatório")
	private String productKey;

}
