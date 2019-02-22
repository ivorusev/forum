package com.mse.demo.mappers;

import org.mapstruct.Mapper;

import com.mse.demo.dto.UserDTO;
import com.mse.demo.persistence.entities.UserEntity;

@Mapper(componentModel = "spring")
public interface UsersMapper {

	UserDTO toDto(UserEntity entity);

	UserEntity toEntity(UserDTO dto);

}
