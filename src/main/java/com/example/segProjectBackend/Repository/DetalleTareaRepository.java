package com.example.segProjectBackend.Repository;

import com.example.segProjectBackend.Entity.DetalleTareaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DetalleTareaRepository extends JpaRepository<DetalleTareaEntity, Integer> {
}
