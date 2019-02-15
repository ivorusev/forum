package com.mse.demo.controllers;

import java.util.Date;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

	private TestMapper testMapper;

	public TestController(TestMapper mapper) {
		this.testMapper = mapper;
	}

	@RequestMapping("/hello/{name}")
	public String hello(@PathVariable String name) {
		ForumDTO dtop = ForumDTO.builder().date(new Date()).text("text").build();
		ForumEntity entity = testMapper.toEntity(dtop);
		return "Hello, " + name + "!";
	}

}
