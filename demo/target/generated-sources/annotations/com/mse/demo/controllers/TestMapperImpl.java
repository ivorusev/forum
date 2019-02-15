package com.mse.demo.controllers;

import com.mse.demo.controllers.ForumDTO.ForumDTOBuilder;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2019-02-15T17:12:53+0200",
    comments = "version: 1.3.0.Final, compiler: javac, environment: Java 1.8.0_162 (Oracle Corporation)"
)
@Component
public class TestMapperImpl implements TestMapper {

    @Override
    public ForumDTO toDto(ForumEntity entity) {
        if ( entity == null ) {
            return null;
        }

        ForumDTOBuilder forumDTO = ForumDTO.builder();

        forumDTO.text( entity.getText() );
        forumDTO.date( entity.getDate() );

        return forumDTO.build();
    }

    @Override
    public ForumEntity toEntity(ForumDTO dto) {
        if ( dto == null ) {
            return null;
        }

        ForumEntity forumEntity = new ForumEntity();

        forumEntity.setText( dto.getText() );
        forumEntity.setDate( dto.getDate() );

        return forumEntity;
    }
}
