package com.example.segProjectBackend.Utils.Querys;

public class UsuarioProyectoQuery {

    public static final String QUEY_USUARIO_PROYECTO_ASIGNADO = "SELECT p.nombre " +
            "FROM proyecto p " +
            "JOIN usuario_proyecto up ON p.id_proyecto  = up.id_proyecto  " +
            "WHERE p.id_proyecto IN (:idsProyectos)";
}
