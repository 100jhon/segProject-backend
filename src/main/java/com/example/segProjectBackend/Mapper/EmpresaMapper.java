package com.example.segProjectBackend.Mapper;

import com.example.segProjectBackend.Dto.EmpresaDto;
import com.example.segProjectBackend.Entity.EmpresaEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface EmpresaMapper {

    EmpresaMapper INTANCE = Mappers.getMapper(EmpresaMapper.class);

    EmpresaDto toDto(EmpresaEntity entity);

    List<EmpresaDto> toDtoList(List<EmpresaEntity> entities);
}