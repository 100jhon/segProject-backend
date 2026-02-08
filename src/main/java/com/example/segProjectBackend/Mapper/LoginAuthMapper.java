package com.example.segProjectBackend.Mapper;

import com.example.segProjectBackend.Entity.UsuarioEntity;
import com.example.segProjectBackend.Security.Dto.LoginRequestDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface LoginAuthMapper {

    LoginRequestDto INSTANCE = Mappers.getMapper(LoginRequestDto.class);

    LoginRequestDto toDto(UsuarioEntity entity);
    UsuarioEntity toEntity(LoginRequestDto dto);
}
