package com.mycompany.webapp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;


/**
 * MainController
 */

@Controller
public class MainController {
    @GetMapping(path = "/home/{color}")
    public String home(@PathVariable String color, @RequestParam(defaultValue = "dat", required = false) String username, Model page) {
        page.addAttribute("username", username);
        page.addAttribute("color", color);
        return "home.html";
    }
}

