package com.example.segProjectBackend.Service.Imp;

import com.example.segProjectBackend.Dto.TareaDto;
import com.example.segProjectBackend.Entity.TareaEntity;
import com.example.segProjectBackend.Mapper.TareaMapper;
import com.example.segProjectBackend.Repository.TareaRepository;
import com.example.segProjectBackend.Service.ITareaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TareaService implements ITareaService {

    private final TareaRepository tareaRepository;

    private final TareaMapper tareaMapper;

    @Autowired
    public TareaService(TareaRepository tareaRepository, TareaMapper tareaMapper){

        this.tareaRepository = tareaRepository;
        this.tareaMapper = tareaMapper;
    }

    @Override
    public TareaDto registrarTarea(TareaDto tareaDto){

        TareaEntity tarea = tareaMapper.toEntity(tareaDto);
        TareaEntity tareaGuardada = tareaRepository.save(tarea);

        return tareaMapper.toDto(tareaGuardada);
    }
}
