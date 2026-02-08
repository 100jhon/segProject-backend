package com.example.segProjectBackend.Controller;


import com.example.segProjectBackend.Dto.UsuarioInfoResp;
import com.example.segProjectBackend.Service.IUsuarioInfoService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/usuario-info")
public class UsuarioInfoController {

    private final IUsuarioInfoService iUsuarioInfoService;

    public UsuarioInfoController(IUsuarioInfoService iUsuarioInfoService){
        this.iUsuarioInfoService = iUsuarioInfoService;
    }

    @GetMapping
    public UsuarioInfoResp obtenerInfoUsuario() {
        return iUsuarioInfoService.obtenerInfoUsuario();
    }

}
