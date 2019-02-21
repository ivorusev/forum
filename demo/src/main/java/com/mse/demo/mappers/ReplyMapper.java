package com.mse.demo.mappers;

import org.mapstruct.Mapper;

import com.mse.demo.dto.ReplyDTO;
import com.mse.demo.persistence.entities.ReplyEntity;

@Mapper(componentModel = "spring")
public interface ReplyMapper {

	ReplyDTO toDto(ReplyEntity entity);

	ReplyEntity toEntity(ReplyDTO dto);

}
