package com.client.ws.rasmooplus.model;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "subscriptions_type")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SubscriptionType  implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "subscriptions_type_id")
	private Long id;
	
	private String name;
	
	@Column(name = "access_months")
	private Long accessMonths;
	
	private BigDecimal price;
	
	@Column(name = "product_key", unique = true)
	private String productKey;

}
