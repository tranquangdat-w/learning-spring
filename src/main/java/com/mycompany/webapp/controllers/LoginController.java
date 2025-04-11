package com.mycompany.webapp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.mycompany.webapp.model.LoginProcessor;
import com.mycompany.webapp.service.LoggedUserManagementService;

import lombok.AllArgsConstructor;

/**
 * LoginController
 */

@Controller
@AllArgsConstructor
public class LoginController {
    private final LoginProcessor loginProcessor;
    private final LoggedUserManagementService loggedUserManagementService;

    @GetMapping(path = {"/", "/login"})
    public String loginGet() {
        String username = loggedUserManagementService.getUsername();

        if (username == null) {
            return "login.html";
        }

        return "redirect:/main";

    }

    @PostMapping(path = "/")
    public String loginPost(
        @RequestParam(name = "username", required = false) String username,
        @RequestParam(name = "password", required = false) String password,
        Model loginPage
    ) {
        loginProcessor.setUsername(username);
        loginProcessor.setPassword(password);

        boolean loggedIn = loginProcessor.login();

        if (loggedIn) {
            return "redirect:/main";
        } 

        loginPage.addAttribute("message", "Login failed");

        return "login.html";
    }
}
