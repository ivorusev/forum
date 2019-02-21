package com.mse.demo.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mse.demo.persistence.entities.ReplyEntity;

public interface ReplyRepository extends JpaRepository<ReplyEntity, Long> {

}
