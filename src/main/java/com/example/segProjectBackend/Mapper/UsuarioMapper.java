package com.example.segProjectBackend.Mapper;
import com.example.segProjectBackend.Entity.RolEntity;
import com.example.segProjectBackend.Entity.UsuarioEntity;
import com.example.segProjectBackend.Security.Dto.LoginRequestDto;
import com.example.segProjectBackend.Security.Dto.RegisterRequestDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UsuarioMapper{



    UsuarioEntity toEntity(RegisterRequestDto dto);
    RegisterRequestDto toDto(UsuarioEntity entity);

    List<UsuarioEntity> toEntity(List<RegisterRequestDto> dtos);


    // Convertir Integer a RolEntity (para ir del DTO a la Entity)
    default RolEntity map(Integer idRol) {
        if (idRol == null) return null;
        RolEntity rol = new RolEntity();
        rol.setIdRol(idRol);
        return rol;
    }

    // Convertir RolEntity a Integer (para ir de la Entity al DTO)
    default Integer map(RolEntity rolEntity) {
        if (rolEntity == null) return null;
        return rolEntity.getIdRol();
    }
}
