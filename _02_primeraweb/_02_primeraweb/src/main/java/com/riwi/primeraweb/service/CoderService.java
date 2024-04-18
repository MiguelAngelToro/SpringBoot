package com.riwi.primeraweb.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.riwi.primeraweb.entity.Coder;
import com.riwi.primeraweb.repository.CoderRepository;

@Service
public class CoderService {

    //Registra la inyeccion de dependencias en spring boot
    @Autowired
    private CoderRepository objCoderRepository;

    public List<Coder> findAll(){
        return this.objCoderRepository.findAll();

    }

    public Page<Coder> findAllPaginate(int page, int size){
        //Validar que la pagian no sea menor a 0
        if (page < 0) {
            page = 0;
        }

        //Crear paginación
        Pageable objPage = PageRequest.of(page, size);

        return this.objCoderRepository.findAll(objPage);

    }
    
    /*
     * Método para crear un nuevo coder, se hace uso del repositorio y
     * del método save, el cual se encarga de insertar en la base de datos
     */
    public Coder create(Coder objCoder) {
        return this.objCoderRepository.save(objCoder);
    }


    public void delete(Long id){
        //Llamar repositorio
        this.objCoderRepository.deleteById(id);
    }

    public Coder findById(Long id){
        return this.objCoderRepository.findById(id).orElse(null);
    }

    public Coder update(Long id, Coder coder){

        //Buscar coder por id
        Coder objCoderDB = this.findById(id);

        //Verificar que exista
        if (objCoderDB == null) return null;

        //Actualizar coder antiguo
        objCoderDB = coder;

        return this.objCoderRepository.save(objCoderDB);
    }

    
}
