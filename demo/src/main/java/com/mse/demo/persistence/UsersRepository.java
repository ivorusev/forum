package com.mse.demo.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mse.demo.persistence.entities.UserEntity;

public interface UsersRepository extends JpaRepository<UserEntity, Long> {

	UserEntity findByUsername(String username);

}
