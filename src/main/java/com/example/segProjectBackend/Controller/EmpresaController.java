package com.example.segProjectBackend.Controller;

import com.example.segProjectBackend.Dto.EmpresaDto;
import com.example.segProjectBackend.Entity.EmpresaEntity;
import com.example.segProjectBackend.Service.IEmpresaService;
import com.example.segProjectBackend.Service.Imp.EmpresaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/empresas")
public class EmpresaController {

    private final IEmpresaService iEmpresaService;

    @Autowired
    public EmpresaController(IEmpresaService iEmpresaService) {
        this.iEmpresaService = iEmpresaService;
    }

    @GetMapping
    public List<EmpresaDto> listarEmpresas() {
        return iEmpresaService.obtenerEmpresas();
    }
}
