package com.mycompany.mvcwebapp.model;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;

import com.mycompany.mvcwebapp.service.LoggedUserManagementService;
import com.mycompany.mvcwebapp.service.LoginCountService;

import lombok.Getter;
import lombok.Setter;

/**
 * LoginProcessor
 */

@Getter
@Setter
@Component
@RequestScope
public class LoginProcessor {
  private final LoggedUserManagementService loggedUserManagementService;
  private final LoginCountService loginCountService;

  private String username;
  private String password;

  public LoginProcessor(
      LoggedUserManagementService loggedUserManagementService,
      LoginCountService loginCountService) {
    this.loggedUserManagementService = loggedUserManagementService;
    this.loginCountService = loginCountService;
  }

  public boolean login() {
    loginCountService.increment();

    boolean loginResult = false;

    if (username.equals("dat") && password.equals("123")) {
      loginResult = true;

      loggedUserManagementService.setUsername(this.username);
    }

    return loginResult;
  }
}
