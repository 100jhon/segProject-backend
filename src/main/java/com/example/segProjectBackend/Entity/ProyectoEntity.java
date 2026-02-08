package com.example.segProjectBackend.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "proyecto")
@Getter
@Setter
public class ProyectoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_proyecto")
    private Integer idProyecto;

    @Column(name = "codigo_proyecto")
    private String codigoProyecto;

    private  String nombre;

    private  String descripcion;

    @Column(name = "id_empresa")
    private Integer idEmpresa;

    @Column(name = "id_estado")
    private Integer idEstado;
}
