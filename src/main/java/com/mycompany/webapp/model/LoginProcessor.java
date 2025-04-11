package com.mycompany.webapp.model;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;

import lombok.Getter;
import lombok.Setter;


/**
 * LoginProcessor
 */

@Getter
@Setter
@Component
// @RequestScope
public class LoginProcessor {
    private String username = "default name";
    private String password = "default password";

    public LoginProcessor() {
    }

    public LoginProcessor(String password, String username) {
		this.password = password;
		this.username = username;
	}

    public boolean login() {
        return username.equals("dat") && password.equals("123");
    }
}

