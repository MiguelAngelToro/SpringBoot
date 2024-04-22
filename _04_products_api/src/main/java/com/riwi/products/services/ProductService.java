package com.riwi.products.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.riwi.products.entities.Product;
import com.riwi.products.repositories.ProductRepository;
import com.riwi.products.services.abstract_service.IproductService;

import lombok.AllArgsConstructor;


@Service
@AllArgsConstructor
public class ProductService implements IproductService{

    @Autowired
    private final ProductRepository objProductRepository;

    @Override
    public Product save(Product objProduct) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'save'");
    }

    @Override
    public List<Product> getAll() {
        
        return this.objProductRepository.findAll();
    }

    @Override
    public Product getById(Long id) {
        
        throw new UnsupportedOperationException("Unimplemented method 'getById'");
    }

    @Override
    public boolean delete(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }

    @Override
    public boolean update(Product objProduct) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }
    
}
