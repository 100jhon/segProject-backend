package com.example.segProjectBackend.Service;

import com.example.segProjectBackend.Dto.ProyectoDto;
import com.example.segProjectBackend.Dto.ProyectoResp;

import java.util.List;

public interface IProyectoService {

    ProyectoDto registrarProyecto(ProyectoDto proyectoDto);

    List<ProyectoResp> obtenerProyectos();

    ProyectoDto actualizarProyecto(ProyectoDto proyectoDto);

    String eliminarProyectos(List<Integer> idsProyectos);

}
