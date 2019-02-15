package com.mse.demo.controllers;

import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TestMapper {

	ForumDTO toDto(ForumEntity entity);

	ForumEntity toEntity(ForumDTO dto);

}
