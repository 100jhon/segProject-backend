package com.example.segProjectBackend.Repository;

import com.example.segProjectBackend.Dto.UsuarioInfoResp;
import com.example.segProjectBackend.Entity.UsuarioEntity;
import com.example.segProjectBackend.Utils.Querys.UsuarioInfoQuery;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;

public interface UsuarioInfoRepository extends Repository<UsuarioEntity, Integer> {

    @Query(value = UsuarioInfoQuery.QUERY_INFO_USARIO, nativeQuery = true)
    UsuarioInfoResp obtenerInfoUsuario (@Param("idUsuario") Integer idUsuario);

}
