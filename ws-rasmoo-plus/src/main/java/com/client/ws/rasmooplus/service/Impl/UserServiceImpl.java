package com.client.ws.rasmooplus.service.Impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.client.ws.rasmooplus.dto.UserDto;
import com.client.ws.rasmooplus.exception.NotFoundException;
import com.client.ws.rasmooplus.model.User;
import com.client.ws.rasmooplus.model.UserType;
import com.client.ws.rasmooplus.repository.UserRepository;
import com.client.ws.rasmooplus.repository.UserTypeRepository;
import com.client.ws.rasmooplus.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserTypeRepository userTypeRepository;
	@Autowired
	private UserRepository userRepository;

	@Override
	public User create(UserDto dto) {
		
		Optional<UserType> userTypeOptional = this.userTypeRepository.findById(dto.getUserTypeId());
		if(userTypeOptional.isEmpty())
		{
			throw new NotFoundException("UserType não encontrado");
		}
		
		UserType userType = this.userTypeRepository.findById(dto.getUserTypeId()).get();
		
		User user = new User();
		user.setCpf(dto.getCpf());
		user.setDtExpiration(dto.getDtExpiration());
		user.setDtSubscription(dto.getDtSubscription());
		user.setEmail(dto.getEmail());
		user.setName(dto.getName());
		user.setPhone(dto.getPhone());
		user.setSubscriptionType(null);
		user.setUsertype(userType);
	
		return this.userRepository.save(user);
	}

}
