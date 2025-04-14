package com.mycompany.mvcwebapp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.mycompany.mvcwebapp.model.Product;
import com.mycompany.mvcwebapp.service.ProductService;

import lombok.Getter;
import lombok.Setter;

/**
 * ProductsController
 */

@Controller
@Getter
@Setter
public class ProductsController {
    private final ProductService productService;

    public ProductsController(ProductService productService) {
        this.productService = productService;
    }

    /**
     * @param p
     * @param model
     * @return
     */
    @PostMapping(path = "/products")
/*     This method automatically create product with requestparamaters name of instance of product. 
    In this situation requestparamater are name and price
    But in this class must have getter method for name and price */
    public String addProduct(Product p, Model model) {
        productService.addProduct(p);
        var products = productService.findAll();
        model.addAttribute("products", products);

        return "products.html";
    }

    @GetMapping(path = "/products")
    public String viewAllProducts(Model model) {
        var products = productService.findAll();
        model.addAttribute("products", products);
        return "products.html";
    }
}
