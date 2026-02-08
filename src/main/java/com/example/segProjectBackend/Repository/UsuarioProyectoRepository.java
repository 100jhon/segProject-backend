package com.example.segProjectBackend.Repository;

import com.example.segProjectBackend.Entity.UsuarioProyectoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UsuarioProyectoRepository extends JpaRepository<UsuarioProyectoEntity,Integer> {

}
