package com.riwilovelace.ejercicio01.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.riwilovelace.ejercicio01.entity.Tarea;

@Repository
public interface TareaRepository extends JpaRepository<Tarea, Long> {
    
}
