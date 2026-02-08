package com.example.segProjectBackend.Service.Imp;

import com.example.segProjectBackend.Dto.UsuarioInfoResp;
import com.example.segProjectBackend.Repository.UsuarioInfoRepository;
import com.example.segProjectBackend.Security.Service.SecurityUtilsService;
import com.example.segProjectBackend.Service.IUsuarioInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioInfoService implements IUsuarioInfoService {

    private final UsuarioInfoRepository usuarioInfoRepository;

    private final SecurityUtilsService securityUtilsService;

    @Autowired
    public UsuarioInfoService(UsuarioInfoRepository usuarioInfoRepository, SecurityUtilsService securityUtilsService) {
        this.securityUtilsService = securityUtilsService;
        this.usuarioInfoRepository = usuarioInfoRepository;
    }

    @Override
    public UsuarioInfoResp obtenerInfoUsuario() {

        Integer idUsuario = securityUtilsService.getIdUsuarioLogueado();
        UsuarioInfoResp datos = usuarioInfoRepository.obtenerInfoUsuario(idUsuario);

        return datos;
    }


}
