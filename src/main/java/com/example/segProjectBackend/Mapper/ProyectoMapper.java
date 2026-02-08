package com.example.segProjectBackend.Mapper;

import com.example.segProjectBackend.Dto.ProyectoDto;
import com.example.segProjectBackend.Entity.ProyectoEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProyectoMapper {



    ProyectoEntity toEntity(ProyectoDto dto);
    ProyectoDto toDto(ProyectoEntity entity);


    List<ProyectoDto> toDtoList(List<ProyectoEntity> entities);
    List<ProyectoEntity> toEntityList(List<ProyectoDto> dtos);
}
