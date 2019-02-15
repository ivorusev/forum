package com.mse.demo.controllers;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class ForumEntity {
	
	@Id
	@GeneratedValue
	@Column(unique = true)
	private Long id;
	
	private String text;
	
	private Date date;

}
