package com.riwi.products.services.abstract_service;

import java.util.List;

import com.riwi.products.entities.Product;

public interface IproductService {

    public Product save(Product objProduct);
    public List<Product> getAll();
    public Product getById(Long id);
    public void delete(Long id);
    public Product update(Product objProduct);

}
