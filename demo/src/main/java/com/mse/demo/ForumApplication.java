package com.mse.demo;

import java.util.Arrays;
import java.util.HashSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;

import com.mse.demo.persistence.UsersRepository;
import com.mse.demo.persistence.entities.RolesEntity;
import com.mse.demo.persistence.entities.UserEntity;

@SpringBootApplication
@EnableWebSecurity
@EnableResourceServer
@EnableAuthorizationServer
public class ForumApplication {

	public static void main(String[] args) {
		SpringApplication.run(ForumApplication.class, args);
	}

	@Autowired
	private UsersRepository repo;

	// TODO: remove, this inserts an user
	@EventListener
	public void appReady(ApplicationReadyEvent event) {
		UserEntity entity = new UserEntity();
		entity.setPassword("pass");
		entity.setUsername("user");
		RolesEntity userRole = RolesEntity.builder()
				.roleName("USER")
				.description("Common User Role")
				.build();
		HashSet<RolesEntity> hashSet = new HashSet<>(Arrays.asList(userRole));
		entity.setRoles(hashSet);
		repo.save(entity);
	}
}
