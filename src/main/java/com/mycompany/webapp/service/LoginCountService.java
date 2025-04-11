package com.mycompany.webapp.service;

import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.ApplicationScope;

import lombok.Getter;

/**
 * LoginCountService
 */

@Service
@ApplicationScope
@Getter
public class LoginCountService {
    private int count;

    public void increment()  {
        count++;
    }
}
