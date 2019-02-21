package com.mse.demo.persistence.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class ReplyEntity {

	@Id
	@GeneratedValue
	@Column(unique = true)
	private Long id;

	private String text;

	private Date postedOn;

	private Date editedOn;

	@ManyToOne
	private TopicEntity topic;

	@ManyToOne
	private UserEntity user;

}
