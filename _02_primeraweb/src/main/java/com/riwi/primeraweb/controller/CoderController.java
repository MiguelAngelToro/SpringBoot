package com.riwi.primeraweb.controller;

//import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.riwi.primeraweb.entity.Coder;
import com.riwi.primeraweb.service.CoderService;


@Controller
@RequestMapping("/")
public class CoderController {

    @Autowired
    private CoderService objCoderService;

    //Metodo para mostrar la vista y enviarle toda la lista de coders

    /**@GetMapping
    public String showViewCoders(Model objModel){

        //obtenemos lista de coders
        List<Coder> listCoders = this.objCoderService.findAll();

        objModel.addAttribute("listCoders", listCoders);

        return "viewCoders";
    }*/

    @GetMapping
    public String showViewCoders(Model objModel, 
        @RequestParam(defaultValue = "1")int page, 
        @RequestParam(defaultValue = "2")int size){

        //obtenemos lista de coders
        Page<Coder> listCoders = this.objCoderService.findAllPaginate(page - 1, size);

        objModel.addAttribute("listCoders", listCoders);
        objModel.addAttribute("currentPage", page);
        objModel.addAttribute("totalPage", listCoders.getTotalPages());

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

    //Controlador para eliminar recibirá como parametro el id por url
    //@PathVariable (ejem: /delete/10) donde 10 es dinamico

    @GetMapping("/delete/{id}")
    public String deleteCoder(@PathVariable Long id){
        this.objCoderService.delete(id);

        //Redireccionar a la lista coders
        return "redirect:/";
    }

    @GetMapping("/update/{id}")
    public String updateCoder(@PathVariable Long id, Model model){
        Coder objCoder = this.objCoderService.findById(id);
        model.addAttribute("coder", objCoder);
        model.addAttribute("action", "/edit/" + id);
        return "viewForm";
    }
    
    @PostMapping("edit/{id}")
    public String updateCoder(@PathVariable Long id, @ModelAttribute Coder objCoder){
        this.objCoderService.update(id, objCoder);
        return "redirect:/";
    }
}
