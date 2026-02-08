package com.example.segProjectBackend.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "tarea")
public class TareaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_tarea")
    private Integer idTarea;

    private String nombre;

    private String descripcion;

    @Column(name = "hora_estimada")
    private Integer horaEstimada;

    @Column(name = "historia_epica")
    private String historiaEpica;

    @Column(name = "historia_usuario")
    private String historiaUsuario;

    @Column(name = "id_estado_tarea")
    private Integer idEstadoTarea;

    @Column(name = "id_actividad")
    private Integer idActividad;
}
