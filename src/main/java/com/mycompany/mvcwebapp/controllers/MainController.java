package com.mycompany.mvcwebapp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.mycompany.mvcwebapp.service.LoggedUserManagementService;
import com.mycompany.mvcwebapp.service.LoginCountService;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;


/**
 * MainController
 */

@Setter
@Getter
@Controller
@AllArgsConstructor
public class MainController {
    private final LoggedUserManagementService loggedUserManagementService;
    private final LoginCountService loginCountService;

    @GetMapping(path = {"/main"})
    public String home(
        @RequestParam(required = false) String logout,
        Model model
    ) {
        if (logout != null) {
            loggedUserManagementService.setUsername(null);
        }

        String username = loggedUserManagementService.getUsername();

        if (username == null) {
            return "redirect:/";
        }

        int countLoginAttempts = loginCountService.getCount();

        model.addAttribute("username", username);
        model.addAttribute("logincount", countLoginAttempts);

        return "main.html";
    }
}

