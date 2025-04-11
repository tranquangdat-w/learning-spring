package com.mycompany.webapp.service;

import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.SessionScope;

import lombok.Getter;
import lombok.Setter;

/**
 * LoggedUserManagementService
 */

@Getter
@Setter
@Service
@SessionScope
public class LoggedUserManagementService {
    private String username;
}
