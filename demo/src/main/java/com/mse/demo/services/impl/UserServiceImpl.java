package com.mse.demo.services.impl;

import org.springframework.stereotype.Service;

import com.mse.demo.dto.UserDTO;
import com.mse.demo.mappers.UsersMapper;
import com.mse.demo.persistence.UsersRepository;
import com.mse.demo.services.UserService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class UserServiceImpl implements UserService {

	private UsersRepository usersRepository;

	private UsersMapper mapper;

	@Override
	public boolean saveUser(UserDTO user) {
		usersRepository.save(mapper.toEntity(user));
		return true;
	}

}
