package com.example.segProjectBackend.Controller;


import com.example.segProjectBackend.Dto.ActividadDto;
import com.example.segProjectBackend.Service.IActividadService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/actividad")
public class ActividadController {

    private final IActividadService iActividadService;

    public ActividadController(IActividadService iActividadService){
        this.iActividadService = iActividadService;
    }

    @PostMapping("/registrar")
    public ResponseEntity<ActividadDto> regitrarActividad(@RequestBody ActividadDto actividadDto){
        ActividadDto actividadRegistrada = iActividadService.registrarActividad(actividadDto);

        return ResponseEntity.ok(actividadRegistrada);
    }
}
