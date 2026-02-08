package com.example.segProjectBackend.Security.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RegisterRequestDto {

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
