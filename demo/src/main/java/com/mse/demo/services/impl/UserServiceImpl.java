package com.mse.demo.services.impl;

import java.util.Arrays;
import java.util.HashSet;

import org.springframework.stereotype.Service;

import com.mse.demo.dto.UserDTO;
import com.mse.demo.mappers.UsersMapper;
import com.mse.demo.persistence.UsersRepository;
import com.mse.demo.persistence.entities.RolesEntity;
import com.mse.demo.persistence.entities.UserEntity;
import com.mse.demo.services.UserService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class UserServiceImpl implements UserService {

	private UsersRepository usersRepository;

	private UsersMapper mapper;

	@Override
	public boolean saveUser(UserDTO user) {
		UserEntity entity = mapper.toEntity(user);
		RolesEntity userRole = RolesEntity.builder()
				.roleName("USER")
				.description("Common User Role")
				.build();
		HashSet<RolesEntity> hashSet = new HashSet<>(Arrays.asList(userRole));
		entity.setRoles(hashSet);
		usersRepository.save(entity);
		return true;
	}

}
