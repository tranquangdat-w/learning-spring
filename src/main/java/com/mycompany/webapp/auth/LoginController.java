package com.mycompany.webapp.auth;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.mycompany.webapp.model.LoginProcessor;

import lombok.AllArgsConstructor;

/**
 * LoginController
 */

@Controller
@AllArgsConstructor
public class LoginController {
    private final LoginProcessor loginProcessor;

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
        @RequestParam(name = "username", required = false) String username,
        @RequestParam(name = "password", required = false) String password,
        Model loginPage
    ) {
        System.out.println("this.loginProcessor = " + loginProcessor);
        loginProcessor.setUsername(username);
        loginProcessor.setPassword(password);

        boolean loggedIn = loginProcessor.login();

        if (loggedIn) {
            loginPage.addAttribute("message", "Login successful");
        } else {
            loginPage.addAttribute("message", "Login failed");
        }

        return "login.html";
    }
}
