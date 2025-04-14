package com.mycompany.restwebapp.controllers;


import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mycompany.restwebapp.model.Country;


/**
 * CountryController
 */

@RestController
public class CountryController {
    @GetMapping(path = {"/france"})
    public ResponseEntity<Country> france() {
        Country c = Country.of("France", 67);
        return ResponseEntity
            .status(HttpStatus.ACCEPTED)
            .header("continent", "Europe")
            .header("capital", "Paris")
            .header("favorite_food", "cheese and wine")
            .body(c);
    }

    @GetMapping(path = {"/all"})
    public List<Country> countries() {
        Country c1 = Country.of("France", 67); 
        Country c2 = Country.of("Italy", 60);

        return List.of(c1, c2);
    }
}

