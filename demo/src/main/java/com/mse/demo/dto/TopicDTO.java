package com.mse.demo.dto;

import java.util.Date;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Null;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TopicDTO {

	@Null
	private Long id;

	@NotBlank(message = "Title may not be empty")
	private String title;

	private Date postedOn;

}
