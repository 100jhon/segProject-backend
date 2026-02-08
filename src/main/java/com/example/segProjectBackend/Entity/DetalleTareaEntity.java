package com.example.segProjectBackend.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@Table(name = "detalle_tarea")
public class DetalleTareaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_detalle_tarea")
    private Integer idDetalleTarea;

    @Column(nullable = false, updatable = false, insertable = false,
            columnDefinition = "datetime DEFAULT GETDATE()")
    private LocalDateTime fecha;

    @Column(name = "horas_trabajadas")
    private Integer horasTrabajadas;

    private String observaciones;

    @Column(name = "id_tarea")
    private Integer idTarea;

    @Column(name = "id_usuario")
    private Integer idUsuario;
}