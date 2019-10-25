package com.carros.reinaldo.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.carros.reinaldo.domain.User;

public interface UserRepository extends JpaRepository<User, Long>{

	User findByLogin(String login); 
}
