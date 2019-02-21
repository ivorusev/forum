package com.mse.demo.services.impl;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.mse.demo.dto.ReplyDTO;
import com.mse.demo.mappers.ReplyMapper;
import com.mse.demo.persistence.ReplyRepository;
import com.mse.demo.persistence.TopicRepository;
import com.mse.demo.persistence.entities.ReplyEntity;
import com.mse.demo.persistence.entities.TopicEntity;
import com.mse.demo.services.ReplyService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class ReplyServiceImpl implements ReplyService {

	private ReplyRepository replyRepository;

	private TopicRepository topicRepository;

	private ReplyMapper mapper;

	@Override
	public void saveReply(ReplyDTO reply) {
		Optional<TopicEntity> findById = topicRepository.findById(reply.getTopicId());
		if (!findById.isPresent()) {
			throw new IllegalArgumentException();
		}
		TopicEntity topicEntity = findById.get();
		ReplyEntity entity = mapper.toEntity(reply);
		entity.setTopic(topicEntity);
		replyRepository.saveAndFlush(entity);
		topicRepository.save(topicEntity);
	}

}
