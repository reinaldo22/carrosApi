package com.carros.reinaldo.rota;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.carros.reinaldo.domain.User;
import com.carros.reinaldo.domain.dto.UserDTO;
import com.carros.reinaldo.service.UserService;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {
	@Autowired
	private UserService service;

	@GetMapping()
	public ResponseEntity get() {
		List<UserDTO> list = service.getUsers();
		return ResponseEntity.ok(list);
	}

	@GetMapping("/info")
	public UserDTO userInfo(@AuthenticationPrincipal User user) {

		// UserDetails userDetails = JwtUtil.getUserDetails();

		return UserDTO.create(user);
	}

}
