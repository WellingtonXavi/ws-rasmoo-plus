package com.client.ws.rasmooplus.integration.impl;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.client.ws.rasmooplus.dto.wsraspay.CustomerDto;
import com.client.ws.rasmooplus.dto.wsraspay.OrderDto;
import com.client.ws.rasmooplus.dto.wsraspay.PaymentDto;
import com.client.ws.rasmooplus.integration.WsRaspayIntegration;

@Component
public class WsRaspayIntegrationImpl implements WsRaspayIntegration {
	
	private RestTemplate restTemplate;
	
	public WsRaspayIntegrationImpl() {
		
		restTemplate = new RestTemplate();
	}

	@Override
	public CustomerDto createCustomer(CustomerDto customerDto) {
		return null;
	}

	@Override
	public OrderDto createOrder(OrderDto orderDto) {
		return null;
	}

	@Override
	public Boolean processPayment(PaymentDto paymentDto) {
		return null;
	}

}
