package com.mse.demo;

import java.util.Arrays;
import java.util.HashSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.event.EventListener;

import com.mse.demo.persistence.UsersRepository;
import com.mse.demo.persistence.entities.RolesEntity;
import com.mse.demo.persistence.entities.UserEntity;

@TestConfiguration
@Profile("test")
public class InitUsers {

	@Autowired
	private UsersRepository repo;

	@EventListener
	public void appReady(ApplicationReadyEvent event) {
		UserEntity userEntity = createUser("user", "pass");
		repo.save(userEntity);
	}

	private UserEntity createUser(String username, String password) {
		UserEntity entity = new UserEntity();
		entity.setPassword(password);
		entity.setUsername(username);
		RolesEntity userRole = RolesEntity.builder()
				.roleName("USER")
				.description("Common User Role")
				.build();
		HashSet<RolesEntity> hashSet = new HashSet<>(Arrays.asList(userRole));
		entity.setRoles(hashSet);
		return entity;
	}

}
