package com.mycompany.webapp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.mycompany.webapp.model.Product;
import com.mycompany.webapp.service.ProductService;

import jakarta.annotation.PostConstruct;

/**
 * ProductsController
 */

@Controller
public class ProductsController {
    private final ProductService productService;

    public ProductsController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping(path = "/products")
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
