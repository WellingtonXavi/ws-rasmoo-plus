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

import com.client.ws.rasmooplus.dto.SubscriptionTypeDto;
import com.client.ws.rasmooplus.model.SubscriptionType;
import com.client.ws.rasmooplus.service.SubscriptionTypeService;

@RestController
@RequestMapping("/subscription-type")
public class SubscriptionTypeController {
	
	@Autowired
	private SubscriptionTypeService subscriptionTypeService;
	
	@GetMapping
	public ResponseEntity<List<SubscriptionType>> findAll(){
		return ResponseEntity.ok(this.subscriptionTypeService.findAll()) ;
	}
	
	
	@GetMapping("/{id}")
	public ResponseEntity<SubscriptionType> findById(@PathVariable Long id){
		return ResponseEntity.ok(this.subscriptionTypeService.findById(id)) ;
	}
	
	@PostMapping
	public ResponseEntity<SubscriptionType> create(@Valid @RequestBody SubscriptionTypeDto dto)
	{
		return ResponseEntity.status(HttpStatus.CREATED).body(this.subscriptionTypeService.create(dto));
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<SubscriptionType> update(@PathVariable Long id,  @RequestBody SubscriptionTypeDto dto)
	{
		return ResponseEntity.ok().body(this.subscriptionTypeService.updateLong(id, dto));
	}
	
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id)
	{
		this.subscriptionTypeService.delete(id);
		return ResponseEntity.notFound().build();
	}

}
