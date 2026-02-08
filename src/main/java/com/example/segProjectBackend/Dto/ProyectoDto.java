package com.example.segProjectBackend.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProyectoDto {

    private Integer idProyecto;

    private String codigoProyecto;

    private  String nombre;

    private  String descripcion;

    private Integer idEmpresa;

    private Integer idEstado;
}
