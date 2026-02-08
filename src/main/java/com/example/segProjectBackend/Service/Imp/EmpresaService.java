package com.example.segProjectBackend.Service.Imp;

import com.example.segProjectBackend.Dto.EmpresaDto;
import com.example.segProjectBackend.Entity.EmpresaEntity;
import com.example.segProjectBackend.Mapper.EmpresaMapper;
import com.example.segProjectBackend.Repository.EmpresaRepository;
import com.example.segProjectBackend.Service.IEmpresaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmpresaService implements IEmpresaService {


    private final EmpresaRepository empresaRepository;

    private final EmpresaMapper empresaMapper;

    // Constructor para inyección de dependencias
    @Autowired
    public EmpresaService(EmpresaRepository empresaRepository, EmpresaMapper empresaMapper) {
        this.empresaRepository = empresaRepository;
        this.empresaMapper = empresaMapper;
    }

    @Override
    public List<EmpresaDto> obtenerEmpresas(){
      List<EmpresaEntity> empresas = empresaRepository.findAll();

      return empresaMapper.toDtoList(empresas);
    }
}
