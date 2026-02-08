package com.example.segProjectBackend.Controller;

import com.example.segProjectBackend.Dto.ProyectoDto;
import com.example.segProjectBackend.Dto.ProyectoResp;
import com.example.segProjectBackend.Service.IProyectoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/proyecto")
public class ProyectoController {

   private final IProyectoService iProyectoService;

   @Autowired
   public ProyectoController(IProyectoService iProyectoService){

       this.iProyectoService = iProyectoService;
   }

    @GetMapping("/listar")
    public ResponseEntity<List<ProyectoResp>> obtenerProyectos() {
        List<ProyectoResp> proyectos = iProyectoService.obtenerProyectos();
        return ResponseEntity.ok(proyectos);
    }

   @PostMapping("/registrar")
    public ResponseEntity<ProyectoDto> registrarProyecto(@RequestBody ProyectoDto proyectoDto){
       ProyectoDto proyectoRegistrado = iProyectoService.registrarProyecto(proyectoDto);

       return ResponseEntity.ok(proyectoRegistrado);
   }

    @PutMapping("/actualizar")
    public ResponseEntity<ProyectoDto> actualizarProyecto(@RequestBody ProyectoDto proyectoDto) {
        ProyectoDto proyectoActualizado =iProyectoService.actualizarProyecto(proyectoDto);
        return ResponseEntity.ok(proyectoActualizado);
    }

    @DeleteMapping("/eliminar")
    public ResponseEntity<String> eliminarProyectos(@RequestBody List<Integer> idsProyectos) {
        String mensaje = iProyectoService.eliminarProyectos(idsProyectos);
        return ResponseEntity.ok(mensaje);
    }
}
