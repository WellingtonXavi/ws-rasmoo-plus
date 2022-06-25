package com.client.ws.rasmooplus.dto;

import java.time.LocalDate;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.br.CPF;

import com.sun.istack.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class UserDto {
	
	
	@NotBlank(message = "Nome é um campo obrigatório")
	private String name;	
	
	@Email(message = "E-mail inválido")
	private String email;
	
	
	private String phone;
	
	@CPF(message = "CPF inválido")
	private String cpf;
	
	private LocalDate dtSubscription = LocalDate.now();
	
	private LocalDate dtExpiration = LocalDate.now();
	
	@NotNull
	private Long userTypeId;
	

	private Long subscriptionTypeId;

}
