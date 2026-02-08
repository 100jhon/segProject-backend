package com.example.segProjectBackend.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DetalleTareaDto {

    private Integer horasTrabajadas;

    private String observaciones;

    private Integer idTarea;

    private Integer idUsuario;
}
