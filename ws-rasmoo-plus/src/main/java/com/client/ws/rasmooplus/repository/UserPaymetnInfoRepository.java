package com.client.ws.rasmooplus.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.client.ws.rasmooplus.model.UserPaymentInfo;

@Repository
public interface UserPaymetnInfoRepository extends JpaRepository<UserPaymentInfo, Long> {

}
