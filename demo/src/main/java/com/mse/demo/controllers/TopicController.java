package com.mse.demo.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mse.demo.dto.TopicDTO;
import com.mse.demo.services.TopicService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/topics")
@AllArgsConstructor
public class TopicController {

	private TopicService topicService;

	@RequestMapping(method = RequestMethod.POST)
	public String createTopic(@RequestBody TopicDTO topic) {
		topicService.saveTopic(topic);
		return "OK!";
	}

	@RequestMapping(method = RequestMethod.GET)
	public List<TopicDTO> getAll() {
		return topicService.findAll();
	}

}
