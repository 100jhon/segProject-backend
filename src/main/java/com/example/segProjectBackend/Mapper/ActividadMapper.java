package com.example.segProjectBackend.Mapper;


import com.example.segProjectBackend.Dto.ActividadDto;
import com.example.segProjectBackend.Entity.ActividadEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ActividadMapper {

    ActividadEntity toEntity(ActividadDto dto);
    ActividadDto toDto(ActividadEntity entity);
    List<ActividadEntity> toEntityList(List<ActividadDto> dtos);
    List<ActividadDto> toDtoList(List<ActividadEntity> entities); // <- este es útil si haces findAll()

}