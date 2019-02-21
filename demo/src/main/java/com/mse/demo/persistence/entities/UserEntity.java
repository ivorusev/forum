package com.mse.demo.persistence.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity(name = "users")
public class UserEntity {

	@Id
	@GeneratedValue
	@Column(unique = true)
	private Long id;

	private String username;

	private String password;

	private String email;

}
