package com.mse.demo.persistence.entities;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity(name = "topics")
public class TopicEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(unique = true)
	private Long id;

	@Column(unique = true)
	private String title;

	private Date postedOn;

	private long views;

	@OneToMany(mappedBy = "topic", fetch = FetchType.LAZY)
	private List<ReplyEntity> replies;

	@PrePersist
	public void onPrePersist() {
		postedOn = new Date();
	}

}
