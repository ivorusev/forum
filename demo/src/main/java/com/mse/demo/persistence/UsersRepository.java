package com.mse.demo.persistence;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mse.demo.persistence.entities.UserEntity;

public interface UsersRepository extends JpaRepository<UserEntity, Long> {

	Optional<UserEntity> findByUsername(String username);

}
