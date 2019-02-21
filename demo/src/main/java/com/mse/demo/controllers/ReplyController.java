package com.mse.demo.controllers;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mse.demo.dto.ReplyDTO;
import com.mse.demo.services.ReplyService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping(value = "/replies")
@AllArgsConstructor
public class ReplyController {

	private ReplyService replyService;

	@RequestMapping(method = RequestMethod.POST)
	public String createReply(@RequestBody ReplyDTO reply) {
		replyService.saveReply(reply);
		return "OK!";
	}

}
