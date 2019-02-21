package com.mse.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

import com.mse.demo.persistence.UserRepository;
import com.mse.demo.persistence.entities.UserEntity;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Autowired
	private UserRepository repo;
	
	// TODO: remove
    @EventListener
    public void appReady(ApplicationReadyEvent event) {
    	UserEntity entity = new UserEntity();
    	entity.setPassword("pass");
    	entity.setUsername("name");
        repo.save(entity);
    }
}

