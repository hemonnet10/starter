package com.agriyo.services.agriyodb.agriyodbservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.agriyo.services.agriyodb.agriyodbservice.model.User;

public interface UserRepository extends JpaRepository<User, Integer>,UserRepositoryCustom {

	User findByMobileAndPassword(String mobileNo,String password);
	User findById(Long userId);
	


}

