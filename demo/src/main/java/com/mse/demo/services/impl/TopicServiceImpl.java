package com.mse.demo.services.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.mse.demo.dto.TopicDTO;
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

	@Override
	public boolean saveTopic(TopicDTO topic) {
		TopicEntity entity = topicMapper.toEntity(topic);
		topicRepository.save(entity);
		return true;
	}

	@Override
	public List<TopicDTO> findAll() {
		List<TopicEntity> findAll = topicRepository.findAll();
		return findAll.stream().map(entity -> topicMapper.toDto(entity)).collect(Collectors.toList());
	}

}
