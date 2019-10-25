package com.carros.reinaldo.security;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import org.springframework.stereotype.Service;

import com.carros.reinaldo.domain.User;
import com.carros.reinaldo.repository.UserRepository;

@Service(value = "userDetailService")
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

	
		
		User user = userRepository.findByLogin(username);
		
		if(user == null) {
			throw new UsernameNotFoundException("User Not Found");
		}

		return user;

		
	}
	
	/*
	 if (username.equals("user")) {

			return User.withUsername(username).password(encoder.encode("user")).roles("USER").build();
		} else if (username.equals("admin")) {

			return User.withUsername(username).password(encoder.encode("admin")).roles("USER", "ADMIN").build();
		}
	 
	  */

}
