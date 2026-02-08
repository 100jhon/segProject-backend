package com.example.segProjectBackend.Repository;

import com.example.segProjectBackend.Entity.EmpresaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmpresaRepository extends JpaRepository<EmpresaEntity, Integer> {
}
