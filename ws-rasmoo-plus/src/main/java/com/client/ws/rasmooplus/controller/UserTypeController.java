package com.client.ws.rasmooplus.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.client.ws.rasmooplus.dto.UserTypeDto;
import com.client.ws.rasmooplus.model.UserType;
import com.client.ws.rasmooplus.service.UserTypeService;

@RestController
@RequestMapping("/user-type")
public class UserTypeController {
	
	@Autowired
	private UserTypeService userTypeService;
	
	
	
	@PutMapping("/{id}")
	public ResponseEntity<UserType> update(@PathVariable Long id,   @RequestBody UserTypeDto dto)
	{
		return ResponseEntity.ok().body(this.userTypeService.update(id, dto));
	}
	
	
	@PostMapping
	public ResponseEntity<UserType> create(@Valid @RequestBody UserTypeDto dto)
	{
		return ResponseEntity.status(HttpStatus.CREATED).body(this.userTypeService.create(dto));
	}
	
	@GetMapping
	public ResponseEntity<List<UserType>> findAll()
	{
		return ResponseEntity.ok(this.userTypeService.findAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<UserType> findById(@PathVariable Long id)
	{
		return ResponseEntity.ok(this.userTypeService.findById(id));
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id)
	{
		this.userTypeService.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	

}
