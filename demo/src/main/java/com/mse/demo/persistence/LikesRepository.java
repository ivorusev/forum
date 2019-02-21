package com.mse.demo.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mse.demo.persistence.entities.LikesEntity;

public interface LikesRepository extends JpaRepository<LikesEntity, Long> {

}
