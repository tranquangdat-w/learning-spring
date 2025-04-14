package com.mycompany.mvcwebapp.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.mycompany.mvcwebapp.model.Product;

/**
 * ProductService
 */

@Service
public class ProductService {
    private List<Product> products = new ArrayList<>();

    public void addProduct(Product product) {
        products.add(product);
    }

    public List<Product> findAll() {
        return products;
    }
}
