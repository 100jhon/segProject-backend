package com.example.segProjectBackend.Mapper;


import com.example.segProjectBackend.Dto.TareaDto;
import com.example.segProjectBackend.Entity.TareaEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface TareaMapper {

    TareaEntity toEntity(TareaDto dto);
    TareaDto toDto(TareaEntity entity);

    List<TareaDto> toDtoList(List<TareaEntity> entities);
}
