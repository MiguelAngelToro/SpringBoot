package com.riwi.primeraweb.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.riwi.primeraweb.entity.Coder;
import com.riwi.primeraweb.service.CoderService;

@Controller
@RequestMapping("/")
public class CoderController {

    @Autowired
    private CoderService objCoderService;

    //Metodo para mostrar la vista y enviarle toda la lista de coders

    @GetMapping
    public String showViewCoders(Model objModel){

        //obtenemos lista de coders
        List<Coder> listCoders = this.objCoderService.findAll();

        objModel.addAttribute("listCoders", listCoders);

        return "viewCoders";
    }

    /**
     * Método para mostrar la vista de formulario y además
     * Enviar una instancia de Coder vacia
     */
    @GetMapping("form")
    public String showViewForm(Model model) {
        model.addAttribute("coder", new Coder());
        model.addAttribute("action", "/create-coder");
        return "viewForm";
    }

    /**
     * Método para recibir todos la información del formulario
     * 
     * @ModelAttribute lo utilizamos para recibir información de la vista
     */
    @PostMapping("create-coder")
    public String createCoder(@ModelAttribute Coder objCoder) {
        this.objCoderService.create(objCoder);
        return "redirect:/";
    }
    
}
