package com.carros.reinaldo.domain.dto;

import com.carros.reinaldo.domain.Role;
import com.carros.reinaldo.domain.User;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserDTO {

	private String login;
	private String nome;
	private String email;

	// token jwt
	private String token;
	private List<String> roles;

	public static UserDTO create(User user) {
		ModelMapper modelMapper = new ModelMapper();
		UserDTO dto = modelMapper.map(user, UserDTO.class);

		dto.roles = user.getRoles().stream().map(Role::getNome).collect(Collectors.toList());

		return dto;
	}

	public static UserDTO create(User user, String token) {
		ModelMapper modelMapper = new ModelMapper();
		UserDTO dto = modelMapper.map(user, UserDTO.class);
		dto.setToken(token);
		return dto;
	}

	public String toJson() throws JsonProcessingException {
		ObjectMapper m = new ObjectMapper();
		return m.writeValueAsString(this);
	}

	public UserDTO() {
		super();
	}


	public UserDTO(String login, String nome, String email) {
		super();
		this.login = login;
		this.nome = nome;
		this.email = email;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}
	public List<String> getRoles() {
		return roles;
	}

	public void setRoles(List<String> roles) {
		this.roles = roles;
	}

}
