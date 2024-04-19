package com.riwilovelace.ejercicio01.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.riwilovelace.ejercicio01.entity.Tarea;
import com.riwilovelace.ejercicio01.repository.TareaRepository;

@Service
public class TareaService {

    @Autowired
    private TareaRepository objTareaRepository;

    //Logica 

    public List<Tarea> findAll(){
        return this.objTareaRepository.findAll();
    }

    public Tarea create(Tarea objTarea){
        return this.objTareaRepository.save(objTarea);
    }
    
}
