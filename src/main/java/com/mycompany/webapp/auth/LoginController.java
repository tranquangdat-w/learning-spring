package com.mycompany.webapp.auth;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * LoginController
 */

@Controller
public class LoginController {
    @GetMapping(path = "/")
    public String loginGet() {
        return "login.html";
    }

    /**
     * @param loginProcessor
     * @param loginPage
     * @return
     */
    @PostMapping(path = "/")
    public String loginPost(
        // @RequestParam(name = "username", required = false) String username,
        // @RequestParam(name = "password", required = false) String password,
        LoginProcessor loginProcessor,
        Model loginPage
    ) {
        boolean loggedIn = loginProcessor.login();
        System.out.println(loginProcessor);

        if (loggedIn) {
            loginPage.addAttribute("message", "Login successful");
        } else {
            loginPage.addAttribute("message", "Login failed");
        }

        return "login.html";
    }
}
