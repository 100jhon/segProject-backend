package com.example.segProjectBackend.Service.Imp;

import com.example.segProjectBackend.Dto.ActividadDto;
import com.example.segProjectBackend.Entity.ActividadEntity;
import com.example.segProjectBackend.Mapper.ActividadMapper;
import com.example.segProjectBackend.Repository.ActividadRepository;
import com.example.segProjectBackend.Service.IActividadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ActividadService implements IActividadService {

    private final ActividadRepository actividadRepository;

    private final ActividadMapper actividadMapper;

    @Autowired
    public ActividadService(ActividadRepository actividadRepository, ActividadMapper actividadMapper){

        this.actividadRepository = actividadRepository;
        this.actividadMapper = actividadMapper;
    }

    @Override
    public ActividadDto registrarActividad(ActividadDto actividadDto){

        ActividadEntity actividadEntity = actividadMapper.toEntity(actividadDto);

        ActividadEntity actividadRegistrada = actividadRepository.save(actividadEntity);

        return actividadMapper.toDto(actividadRegistrada);
    }
}
