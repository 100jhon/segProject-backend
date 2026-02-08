package com.example.segProjectBackend.Repository;

import com.example.segProjectBackend.Dto.ProyectoDto;
import com.example.segProjectBackend.Dto.ProyectoResp;
import com.example.segProjectBackend.Dto.UsuarioInfoResp;
import com.example.segProjectBackend.Entity.ProyectoEntity;
import com.example.segProjectBackend.Entity.UsuarioProyectoEntity;
import com.example.segProjectBackend.Utils.Querys.ProyectosQuery;
import com.example.segProjectBackend.Utils.Querys.UsuarioInfoQuery;
import com.example.segProjectBackend.Utils.Querys.UsuarioProyectoQuery;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProyectoRepository extends JpaRepository<ProyectoEntity,Integer> {

    @Query(value = ProyectosQuery.QUERY_PROYECTOS_USUARIO, nativeQuery = true)
    List<ProyectoResp> obtenerProyectos (@Param("idUsuario") Integer idUsuario);

    @Query(value = ProyectosQuery.QUERY_ID_EMPRESA_POR_USUARIO, nativeQuery = true)
     Integer getIdEmpresa (@Param("idUsuario") Integer idUsuario);

    @Query(value = ProyectosQuery.QUERY_PROYECTOS_POR_EMPRESA, nativeQuery = true)
    List<ProyectoResp> proyectosEmpresa (@Param("idEmpresa") Integer idEmpresa);

    @Query(value = UsuarioProyectoQuery.QUEY_USUARIO_PROYECTO_ASIGNADO, nativeQuery = true)
    List<String> proyectosAsignados(List<Integer> idsProyectos);
}
