package com.example.segProjectBackend.Mapper;

import com.example.segProjectBackend.Dto.DetalleTareaDto;
import com.example.segProjectBackend.Entity.DetalleTareaEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface DetalleTareaMapper {

    DetalleTareaEntity toEntity(DetalleTareaDto dto);
    DetalleTareaDto toDto(DetalleTareaEntity entity);

}
