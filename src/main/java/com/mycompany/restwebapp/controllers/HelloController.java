package com.mycompany.restwebapp.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * HelloController
 */
@RestController
public class HelloController {
    @GetMapping(path = {"/hello"})
    public String hello() {
        return "hello!";
    }

    @GetMapping(path = {"/ciao"})
    public String ciao() {
        return "ciao";
    }
}
