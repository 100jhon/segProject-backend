package com.example.segProjectBackend.Dto;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ActividadDto {

    private Integer idActividad;

    private String nombre;

    private  String historiaEpica;

    private String historiaUsuario;

    private String horaEstimada;

    private  String codigoProyecto;
}
