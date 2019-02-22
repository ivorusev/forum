package com.mse.demo.services;

import java.util.List;

import com.mse.demo.dto.TopicDTO;
import com.mse.demo.dto.TopicWithRepliesDTO;

public interface TopicService {

	boolean saveTopic(TopicDTO topic);

	List<TopicDTO> findAll();

	TopicWithRepliesDTO findById(long id);

}