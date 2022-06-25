package com.client.ws.rasmooplus.service.Impl;

import java.util.List;
import java.util.Optional;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.client.ws.rasmooplus.dto.UserTypeDto;
import com.client.ws.rasmooplus.exception.NotFoundException;
import com.client.ws.rasmooplus.model.UserType;
import com.client.ws.rasmooplus.repository.UserTypeRepository;
import com.client.ws.rasmooplus.service.UserTypeService;

@Service
public class UserTypeImpl implements UserTypeService{

	private UserTypeRepository userTypeRepository;
	
	public UserTypeImpl(UserTypeRepository userTypeRepository) {

		this.userTypeRepository = userTypeRepository;
	}
	
	
	@Override
	public UserType findById(Long id) {
	
	Optional<UserType> optionalUserType = this.userTypeRepository.findById(id);
	
	if(optionalUserType.isPresent())
	{
		return optionalUserType.get();
	}
		
		 throw new NotFoundException("User type com o código " + id + " não localizado");
	}

	@Override
	@Cacheable(value = "findAll")
	public List<UserType> findAll() {
		return this.userTypeRepository.findAll();
	}


	@Override
	@CacheEvict(value = "findAll", allEntries = true)
	public UserType create(UserTypeDto dto ) {
		
	
			return this.userTypeRepository.save(UserType.builder()
					.name(dto.getName())
					.description(dto.getDescription())				
					.build());
		
		
	}


	@Override
	public UserType update(Long id, UserTypeDto dto) {
		
		 findById(id);
		 
		 return this.userTypeRepository.save(UserType.builder()
				    .id(id)
					.name(dto.getName())
					.description(dto.getDescription())				
					.build());
	}


	@Override
	public void delete(Long id) {
		findById(id);
		
		this.userTypeRepository.deleteById(id);
		
	}

}
