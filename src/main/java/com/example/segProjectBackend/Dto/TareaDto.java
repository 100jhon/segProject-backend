package com.example.segProjectBackend.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TareaDto {

    private String nombre;

    private String descripcion;

    private Integer horaEstimada;

    private String historiaEpica;

    private String historiaUsuario;

    private Integer idEstadoTarea;

    private Integer idActividad;
}
