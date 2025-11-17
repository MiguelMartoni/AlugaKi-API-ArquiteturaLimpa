package com.AlugaKi.infrastructure.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StatusAluguelRepository extends JpaRepository<StatusAluguelEntity, Integer> {
    
}