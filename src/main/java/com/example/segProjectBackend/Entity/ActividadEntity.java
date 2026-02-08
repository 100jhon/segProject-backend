package com.example.segProjectBackend.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "actividad")
public class ActividadEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_actividad")
    private Integer idActividad;

    private String nombre;

    @Column(name = "historia_epica")
    private  String historiaEpica;

    @Column(name = "historia_usuario")
    private String historiaUsuario;

    @Column(name = "hora_estimada")
    private String horaEstimada;

    @Column(name = "codigo_proyecto")
    private  String codigoProyecto;
}
