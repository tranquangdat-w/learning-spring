package com.mycompany.webapp.auth;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;

/**
 * LoginProcessor
 */

@Component
@RequestScope
public class LoginProcessor {
    private String username;
    private String password;

	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

    public boolean login() {
        String username = this.getUsername();
        String passowrd = this.getPassword();

        return username.equals("dat") && passowrd.equals("123");
    }
}
