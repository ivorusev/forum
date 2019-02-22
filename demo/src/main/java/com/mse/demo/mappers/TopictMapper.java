package com.mse.demo.mappers;

import java.util.List;
import java.util.stream.Collectors;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

import com.mse.demo.dto.ReplyDTO;
import com.mse.demo.dto.TopicDTO;
import com.mse.demo.dto.TopicWithRepliesDTO;
import com.mse.demo.persistence.entities.ReplyEntity;
import com.mse.demo.persistence.entities.TopicEntity;

@Mapper(componentModel = "spring")
public interface TopictMapper {

	TopicDTO toDto(TopicEntity entity);

	@Mapping(source = "replies", target = "topicReplies", qualifiedByName = "repliesTransformation")
	TopicWithRepliesDTO toDtoWithReplies(TopicEntity entity);

	TopicEntity toEntity(TopicDTO dto);

	@Named("repliesTransformation")
	default List<ReplyDTO> myCustomTransformation(List<ReplyEntity> entities) {
		ReplyMapper replyMapper = Mappers.getMapper(ReplyMapper.class);
		return entities.stream().map(entity -> replyMapper.toDto(entity)).collect(Collectors.toList());
	}
}