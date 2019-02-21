package com.mse.demo.persistence.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class UserEntity {

	@Id
	@GeneratedValue
	@Column(unique = true)
	private Long id;

	private String username;

	private String password;

	private String email;

	@OneToMany(fetch = FetchType.LAZY)
	private List<ReplyEntity> replies;

}
