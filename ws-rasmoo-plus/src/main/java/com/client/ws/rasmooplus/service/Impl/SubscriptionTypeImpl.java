package com.client.ws.rasmooplus.service.Impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.client.ws.rasmooplus.dto.SubscriptionTypeDto;
import com.client.ws.rasmooplus.exception.NotFoundException;
import com.client.ws.rasmooplus.model.SubscriptionType;
import com.client.ws.rasmooplus.repository.SubscriptionTypeRepository;
import com.client.ws.rasmooplus.service.SubscriptionTypeService;

@Service
public class SubscriptionTypeImpl implements SubscriptionTypeService {

	@Autowired
	private SubscriptionTypeRepository subscriptionTypeRepository;

	public SubscriptionTypeImpl(SubscriptionTypeRepository subscriptionTypeRepository) {
		this.subscriptionTypeRepository = subscriptionTypeRepository;
	}

	@Override
	public List<SubscriptionType> findAll() {
		return this.subscriptionTypeRepository.findAll();
	}

	@Override
	public SubscriptionType findById(Long Id) {
		Optional<SubscriptionType> optionalSubcriptiionType = this.subscriptionTypeRepository.findById(Id);
		
		if(optionalSubcriptiionType.isPresent())
		{
			return this.subscriptionTypeRepository.findById(Id).get();
		}
		throw new NotFoundException("SubscriptionType com o ID " + Id + " não foi localizado");
		
		
	}

	@Override
	public SubscriptionType create(SubscriptionTypeDto subscriptionTypeDto) {
		
	
		
		
		return this.subscriptionTypeRepository.save(SubscriptionType.builder()
				.name(subscriptionTypeDto.getName())
				.price(subscriptionTypeDto.getPrice())
				.productKey(subscriptionTypeDto.getProductKey())
				.accessMonths(subscriptionTypeDto.getAccessMonths())
				
				
				.build());
	}

	@Override
	public SubscriptionType updateLong(Long id, SubscriptionTypeDto subscriptionTypeDto) {
		 
		findById(id);
		
		
		 
		 return this.subscriptionTypeRepository.save(SubscriptionType.builder()
					.id(id)
					.name(subscriptionTypeDto.getName())
					.price(subscriptionTypeDto.getPrice())
					.productKey(subscriptionTypeDto.getProductKey())
					.accessMonths(subscriptionTypeDto.getAccessMonths())
					
					
					.build());
	}

	@Override
	public void delete(Long id) {
		
		findById(id);
		
		this.subscriptionTypeRepository.deleteById(id);

	}
	
	
	
	
	

}
