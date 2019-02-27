package com.mse.demo.controllers;

import java.util.List;

import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mse.demo.dto.TopicDTO;
import com.mse.demo.dto.TopicWithRepliesDTO;
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

	@Secured({ "USER" })
	@RequestMapping(method = RequestMethod.GET)
	public List<TopicDTO> getAll() {
		return topicService.findAll();
	}

	@RequestMapping(value = "{id}", method = RequestMethod.GET)
	public TopicWithRepliesDTO getTopicWithReplies(@PathVariable Long id) {
		return topicService.findById(id);
	}

}
