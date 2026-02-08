package com.example.segProjectBackend.Controller;


import com.example.segProjectBackend.Dto.DetalleTareaDto;
import com.example.segProjectBackend.Service.IDetalleTareaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/detalle-tarea")
public class DetalleTareaController {

  private final IDetalleTareaService iDetalleTareaService;

  public DetalleTareaController(IDetalleTareaService iDetalleTareaService){
      this.iDetalleTareaService = iDetalleTareaService;
  }

    @PostMapping("/registrar")
    public ResponseEntity<DetalleTareaDto> registrarDetalleTarea(@RequestBody DetalleTareaDto detalleTareaDto) {
        DetalleTareaDto savedDetalle = iDetalleTareaService.registrarDetalleTarea(detalleTareaDto);
        return new ResponseEntity<>(savedDetalle, HttpStatus.CREATED);
    }

}
