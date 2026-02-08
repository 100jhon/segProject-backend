package com.example.segProjectBackend.Service.Imp;

import com.example.segProjectBackend.Dto.ProyectoDto;
import com.example.segProjectBackend.Dto.ProyectoResp;
import com.example.segProjectBackend.Entity.ProyectoEntity;
import com.example.segProjectBackend.Mapper.ProyectoMapper;
import com.example.segProjectBackend.Repository.ProyectoRepository;
import com.example.segProjectBackend.Repository.UsuarioProyectoRepository;
import com.example.segProjectBackend.Repository.UsuarioRepository;
import com.example.segProjectBackend.Security.Service.SecurityUtilsService;
import com.example.segProjectBackend.Service.IProyectoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProyectoService implements IProyectoService {

    private final ProyectoRepository proyectoRepository;

    private final ProyectoMapper proyectoMapper;

    private final SecurityUtilsService securityUtilsService;
    private final UsuarioRepository usuarioRepository;
    private final UsuarioProyectoRepository usuarioProyectoRepository;


    @Autowired
    public ProyectoService(ProyectoRepository proyectoRepository, ProyectoMapper proyectoMapper, SecurityUtilsService securityUtilsService, UsuarioRepository usuarioRepository, UsuarioProyectoRepository usuarioProyectoRepository){

        this.proyectoMapper = proyectoMapper;
        this.proyectoRepository = proyectoRepository;
        this.securityUtilsService = securityUtilsService;
        this.usuarioRepository = usuarioRepository;
        this.usuarioProyectoRepository = usuarioProyectoRepository;
    }

    @Override
    public ProyectoDto registrarProyecto(ProyectoDto proyectoDto){

        ProyectoEntity proyectoEntity = proyectoMapper.toEntity(proyectoDto);
        Integer idUsuario = securityUtilsService.getIdUsuarioLogueado();
        Integer idEmpresa = proyectoRepository.getIdEmpresa(idUsuario);
        proyectoEntity.setIdEmpresa(idEmpresa);

        ProyectoEntity proyectoGuardado = proyectoRepository.save(proyectoEntity);

        return proyectoMapper.toDto(proyectoGuardado);
    }


    @Override
    public List<ProyectoResp> obtenerProyectos() {

        Integer idUsuario = securityUtilsService.getIdUsuarioLogueado();

        if (securityUtilsService.tieneRol("Desarrollador")){
           return  proyectoRepository.obtenerProyectos(idUsuario);
        } else {
            Integer idEmpresa = proyectoRepository.getIdEmpresa(idUsuario);
            return proyectoRepository.proyectosEmpresa(idEmpresa);
        }
    }

    @Override
    public ProyectoDto actualizarProyecto(ProyectoDto proyectoDto){

        // 1. Validar si el proyecto existe
        if (!proyectoRepository.existsById(proyectoDto.getIdProyecto())) {
            throw new RuntimeException("Proyecto no encontrado con ID: " + proyectoDto.getIdProyecto());
        }

        // 2. Convertir DTO a entidad
        ProyectoEntity proyecto = proyectoMapper.toEntity(proyectoDto);

        // 3. Guardar (actualiza porque el ID existe)
        ProyectoEntity proyectoActualizado = proyectoRepository.save(proyecto);

        // 4. Convertir a DTO y devolver
        return proyectoMapper.toDto(proyectoActualizado);

    }

    @Override
    public String eliminarProyectos(List<Integer> idsProyectos) {

        if (securityUtilsService.tieneRol("Desarrollador")) {
            return "No tienes permisos para realizar esta accion";
        }


        if (idsProyectos == null || idsProyectos.isEmpty()) {
            throw new RuntimeException("No se proporcionaron IDs para eliminar");
        }

        // Validar que todos existan antes de eliminar
        for (Integer id : idsProyectos) {
            if (!proyectoRepository.existsById(id)) {
                return ("Proyecto no encontrado con ID: " + id);
            }
        }

        //Validar que el proyecto no este asignado a un susuario
        List<String> asignados = proyectoRepository.proyectosAsignados(idsProyectos);
        if (!asignados.isEmpty()) {
            return "Proyecto asignado no es posible eliminar" +asignados;
        }


        // Eliminar todos
        proyectoRepository.deleteAllById(idsProyectos);

        return "Proyectos eliminados correctamente: ID " + idsProyectos;
    }

}
