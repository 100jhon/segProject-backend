package com.example.segProjectBackend.Repository;

import com.example.segProjectBackend.Entity.ActividadEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ActividadRepository extends JpaRepository<ActividadEntity, Integer> {
}
