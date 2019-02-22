package com.mse.demo.persistence.entities;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity(name = "replies")
public class ReplyEntity {

	@Id
	@GeneratedValue
	@Column(unique = true)
	private Long id;

	private String text;

	private Date postedOn;

	private Date editedOn;

	@ManyToOne
	@JoinColumn(name = "topic_id")
	private TopicEntity topic;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "user_id")
	private UserEntity user;

}
