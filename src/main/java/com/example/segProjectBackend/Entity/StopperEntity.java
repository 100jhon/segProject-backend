package com.example.segProjectBackend.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "stopper")
public class StopperEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_stopper")
    private Integer idStopper;

    private String motivo;

    private String descripcion;

    @Column(name = "tiempo_stopper")
    private Integer tiempoStopper;

    @Column(name = "id_tarea")
    private Integer idTarea;

    @Column(name = "id_usuario")
    private Integer idUsuario;
}
