package com.mse.demo.services.impl;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.mse.demo.dto.ReplyDTO;
import com.mse.demo.mappers.ReplyMapper;
import com.mse.demo.persistence.ReplyRepository;
import com.mse.demo.persistence.TopicRepository;
import com.mse.demo.persistence.UsersRepository;
import com.mse.demo.persistence.entities.ReplyEntity;
import com.mse.demo.persistence.entities.TopicEntity;
import com.mse.demo.persistence.entities.UserEntity;
import com.mse.demo.services.ReplyService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class ReplyServiceImpl implements ReplyService {

	private ReplyRepository replyRepository;

	private TopicRepository topicRepository;

	private UsersRepository userRepository;

	private ReplyMapper mapper;

	@Override
	public void saveReply(ReplyDTO reply) {
		Optional<TopicEntity> findById = topicRepository.findById(reply.getTopicId());
		if (!findById.isPresent()) {
			throw new IllegalArgumentException("Trying to add a reply for non-existing topic!");
		}

		Optional<UserEntity> user = userRepository.findById(reply.getUserId());
		if (!user.isPresent()) {
			throw new IllegalArgumentException("Trying to add a reply for non-existing user!");
		}

		ReplyEntity entity = mapper.toEntity(reply);
		entity.setTopic(findById.get());
		entity.setUser(user.get());
		replyRepository.saveAndFlush(entity);
	}

}
