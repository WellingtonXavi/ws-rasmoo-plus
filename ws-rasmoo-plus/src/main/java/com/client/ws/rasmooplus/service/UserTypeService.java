package com.client.ws.rasmooplus.service;

import java.util.List;

import com.client.ws.rasmooplus.dto.UserTypeDto;
import com.client.ws.rasmooplus.model.UserType;


public interface UserTypeService {
	
	UserType findById(Long id);
	
	List<UserType> findAll();
	
	UserType create(UserTypeDto dto);
	
	UserType update(Long id, UserTypeDto dto);
	
	void delete(Long id);

}
