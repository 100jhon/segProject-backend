package com.example.segProjectBackend.Utils.Querys;

public class ProyectosQuery {

    public static final String QUERY_PROYECTOS_USUARIO ="SELECT \n" +
            "    p.id_proyecto AS idProyecto, \n" +
            "    p.codigo_proyecto AS codigoProyecto, \n" +
            "    p.nombre, \n" +
            "    p.descripcion \n" +
            "FROM proyecto p \n" +
            "INNER JOIN usuario_proyecto up ON p.id_proyecto = up.id_proyecto \n" +
            "WHERE up.id_usuario = :idUsuario";

    public static final String QUERY_ID_EMPRESA_POR_USUARIO =
            "SELECT \n" +
            "    u.id_empresa \n" +
            "FROM usuario u \n" +
            "WHERE u.id_usuario = :idUsuario";



    public static final String QUERY_PROYECTOS_POR_EMPRESA =    "SELECT \n" +
            "    p.id_proyecto AS idProyecto, \n" +
            "    p.codigo_proyecto AS codigoProyecto, \n" +
            "    p.nombre, \n" +
            "    p.descripcion, \n" +
            "    p.id_empresa AS idEmpresa, \n" +
            "    p.id_estado AS idEstado \n" +
            "FROM proyecto p \n" +
            "WHERE p.id_empresa = :idEmpresa";
}
