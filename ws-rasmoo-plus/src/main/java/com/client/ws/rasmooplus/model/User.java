package com.client.ws.rasmooplus.model;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "users")
@NoArgsConstructor
@Data
@Builder
@AllArgsConstructor
public class User implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "users_id")
	private Long id;
	
	private String name;	
	
	private String email;
	
	private String phone;
	
	private String cpf;
	
	@Column(name = "dt_subscription")
	private LocalDate dtSubscription;
	
	@Column(name = "dt_expiration")
	private LocalDate dtExpiration;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_type_id")
	private UserType usertype;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "subscriptions_type_id")
	private SubscriptionType subscriptionType;
	
	
	

}
