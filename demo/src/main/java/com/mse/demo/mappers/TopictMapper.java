package com.mse.demo.mappers;

import org.mapstruct.Mapper;

import com.mse.demo.dto.TopicDTO;
import com.mse.demo.persistence.entities.TopicEntity;

@Mapper(componentModel = "spring")
public interface TopictMapper {

	TopicDTO toDto(TopicEntity entity);

	TopicEntity toEntity(TopicDTO dto);

}
