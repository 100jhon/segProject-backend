package com.example.segProjectBackend.Controller;


import com.example.segProjectBackend.Dto.TareaDto;
import com.example.segProjectBackend.Service.ITareaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/tarea")
public class TareaController {

    private final ITareaService iTareaService;

    @Autowired
    public TareaController(ITareaService iTareaService){
        this.iTareaService = iTareaService;
    }

    @PostMapping("/registrar")
   public ResponseEntity<TareaDto> registrarTarea(@RequestBody TareaDto tareaDto){

       TareaDto tareaRegistrada = iTareaService.registrarTarea(tareaDto);

       return ResponseEntity.ok(tareaRegistrada);
   }
}
