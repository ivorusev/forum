package com.mse.demo.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mse.demo.persistence.entities.TopicEntity;

public interface TopicRepository extends JpaRepository<TopicEntity, Long> {

}
