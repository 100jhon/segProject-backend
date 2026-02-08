package com.example.segProjectBackend.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioDto {

    private Integer idUsuario;

    private String primerNombre;

    private String segundoNombre;

    private String primerApellido;

    private String segundoApellido;

    private String correo;

    private String password;

    private String telefono;

    private String direccion;

    private Integer idEmpresa;

    private  Integer idRol;
}
