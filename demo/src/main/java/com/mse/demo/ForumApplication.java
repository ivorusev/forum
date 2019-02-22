package com.mse.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

import com.mse.demo.persistence.UsersRepository;
import com.mse.demo.persistence.entities.UserEntity;

@SpringBootApplication
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
		entity.setUsername("name");
		repo.save(entity);
	}
}
