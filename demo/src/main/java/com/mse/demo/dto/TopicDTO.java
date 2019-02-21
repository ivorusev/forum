package com.mse.demo.dto;

import java.util.Date;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TopicDTO {

	private String title;

	private String text;

	private Date date;

	private List<ReplyDTO> topicReplies;

}
