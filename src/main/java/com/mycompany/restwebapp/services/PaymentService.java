package com.mycompany.restwebapp.services;

import org.springframework.stereotype.Service;

import com.mycompany.restwebapp.exception.NotEnoughMoneyException;
import com.mycompany.restwebapp.model.PaymentDetails;

/**
 * PaymentService
 */

@Service
public class PaymentService {

    public PaymentDetails processPayment() {
        throw new NotEnoughMoneyException();
    }
    
}
