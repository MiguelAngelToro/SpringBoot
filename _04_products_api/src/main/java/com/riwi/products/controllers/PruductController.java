package com.riwi.products.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.riwi.products.entities.Product;
import com.riwi.products.services.abstract_service.IproductService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/v1/products")
@AllArgsConstructor
public class PruductController {

    @Autowired
    private final IproductService objIproductService;

    @GetMapping
    public ResponseEntity<List<Product>> getAll(){
        return ResponseEntity.ok(this.objIproductService.getAll());
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Product> get(@PathVariable Long id){
      return ResponseEntity.ok(this.objIproductService.getById(id));
    }

    @PostMapping
    public ResponseEntity<Product> insert(@RequestBody Product objProduct){
        return ResponseEntity.ok(this.objIproductService.save(objProduct));
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<Product> update(
        @RequestBody Product objProduct,//Para obtener datos actualizados
        @PathVariable Long id//Obtener id que viene en url
    ){ 
        objProduct.setId(id);
        return ResponseEntity.ok(this.objIproductService.save(objProduct));
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        this.objIproductService.delete(id);

        return ResponseEntity.noContent().build();
    }
    
    
}
