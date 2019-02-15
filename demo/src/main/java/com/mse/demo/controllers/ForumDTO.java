package com.mse.demo.controllers;

import java.util.Date;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ForumDTO {
	
	private String text;
	
	private Date date;

}
