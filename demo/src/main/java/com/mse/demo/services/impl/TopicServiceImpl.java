package com.mse.demo.services.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.mse.demo.dto.ReplyDTO;
import com.mse.demo.dto.TopicDTO;
import com.mse.demo.mappers.ReplyMapper;
import com.mse.demo.mappers.TopictMapper;
import com.mse.demo.persistence.TopicRepository;
import com.mse.demo.persistence.entities.TopicEntity;
import com.mse.demo.services.TopicService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class TopicServiceImpl implements TopicService {

	private TopicRepository topicRepository;

	private TopictMapper topicMapper;
	private ReplyMapper replyMapper;

	@Override
	public boolean saveTopic(TopicDTO topic) {
		TopicEntity entity = topicMapper.toEntity(topic);
		topicRepository.save(entity);
		return true;
	}

	@Override
	public List<TopicDTO> findAll() {
		List<TopicDTO> result = new ArrayList<TopicDTO>();
		List<TopicEntity> findAll = topicRepository.findAll();
		for (TopicEntity entity : findAll) {
			TopicDTO dto = topicMapper.toDto(entity);
			List<ReplyDTO> collect = entity.getReplies().stream().map(p -> replyMapper.toDto(p))
					.collect(Collectors.toList());
			dto.setTopicReplies(collect);
			result.add(dto);
		}
		return result;
	}

}
