package com.riwi.primeraweb.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


//Indica a spring boot que esta clase es una entidad
@Entity
//Permite configurara la tabla que creará el ORM (Hibernate)
@Table(name = "coder")
public class Coder {

    //Indica que el atributo será la llave primaria
    @Id
    //Indica que será auto incrementado 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String clan;
    private int age;

    public Coder() {
    }

    public Coder(Long id, String nombre, String clan, int age) {
        this.id = id;
        this.nombre = nombre;
        this.clan = clan;
        this.age = age;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getClan() {
        return clan;
    }

    public void setClan(String clan) {
        this.clan = clan;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Coder [id=" + id + ", nombre=" + nombre + ", clan=" + clan + ", age=" + age + "]";
    }

    



    
    
}
