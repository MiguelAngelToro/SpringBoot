package com.riwi.primeraweb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.riwi.primeraweb.entity.Coder;

//Se encarga de toda la persistencia de los datos, interactua con la base de datos
@Repository
public interface CoderRepository extends JpaRepository<Coder,Long> { //Extendemos de la interfaz Jpa para obtener todos los metodos CRUD
    
}
