package com.example.segProjectBackend.Repository;

import com.example.segProjectBackend.Entity.TareaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TareaRepository extends JpaRepository<TareaEntity, Integer> {
}
