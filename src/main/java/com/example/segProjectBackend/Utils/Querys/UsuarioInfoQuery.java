package com.example.segProjectBackend.Utils.Querys;

public class UsuarioInfoQuery {

    public static final String QUERY_INFO_USARIO =
            "SELECT \n" +
                    "    u.correo,\n" +
                    "    CONCAT(u.primer_nombre, ' ', u.primer_apellido) AS \"nombre\",\n" +
                    "    e.nombre AS \"empresa\",\n" +
                    "    r.nombre AS \"rol\"\n" +
                    "FROM usuario u\n" +
                    "JOIN empresa e ON u.id_empresa = e.id_empresa\n" +
                    "JOIN rol r ON u.id_rol = r.id_rol\n" +
                    "WHERE u.id_usuario = :idUsuario";

}