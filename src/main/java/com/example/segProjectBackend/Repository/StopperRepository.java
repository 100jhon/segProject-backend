package com.example.segProjectBackend.Repository;

import com.example.segProjectBackend.Entity.StopperEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StopperRepository extends JpaRepository<StopperEntity, Integer> {
}
