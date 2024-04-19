package com.riwilovelace.ejercicio01.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.riwilovelace.ejercicio01.entity.Tarea;
import com.riwilovelace.ejercicio01.service.TareaService;

@Controller
@RequestMapping("/")
public class TareaController {

    @Autowired
    private TareaService objTareaService;


    //LISTAR

    @GetMapping
    public String showViewTareas(Model objModel){

        //Obtener lista de tareas
        List<Tarea> listTareas = objTareaService.findAll();

        objModel.addAttribute("listTareas", listTareas);

        return "viewTareas";

    }

    //CREAR
    @GetMapping("form")
    public String showViewForm(Model objModel){
        objModel.addAttribute("tarea", new Tarea());
        objModel.addAttribute("action", "/create-tarea");
        return "viewForm";
    }



    

}
