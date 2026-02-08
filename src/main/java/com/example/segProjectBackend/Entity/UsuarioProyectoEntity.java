package com.example.segProjectBackend.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@Table(name = "usuario_proyecto")
public class UsuarioProyectoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_usuario_proyecto")
    public Integer UsuarioProyecto;

    @Column(name = "id_usuario")
    public  Integer idUsuario;

    @Column(name = "id_proyecto")
    public Integer proyectoId;

    @Column(name = "fecha_asignacion")
    private LocalDateTime fechaAsignacion = LocalDateTime.now();
}
