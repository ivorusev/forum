package com.mse.demo.persistence.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class LikesEntity {

	@Id
	@GeneratedValue
	@Column(unique = true)
	private Long id;
}
