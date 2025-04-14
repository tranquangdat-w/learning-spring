package com.mycompany.restwebapp.controllers;

import java.util.UUID;
import java.util.logging.Logger;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.mycompany.restwebapp.dto.Payment;
import com.mycompany.restwebapp.model.PaymentDetails;
import com.mycompany.restwebapp.services.PaymentService;

import lombok.AllArgsConstructor;

/**
 * PaymentController
 */

@RestController
@AllArgsConstructor
public class PaymentController {
    private final PaymentService paymentService;
    private final Logger logger = Logger.getLogger(PaymentController.class.getName());

    @PostMapping(path = {"/payment"})
    public ResponseEntity<Payment> makePayment(
        @RequestHeader String requestId,
        @RequestBody Payment payment
    ) {
        logger.info("Received request with ID: " + requestId + " with payment: " + payment);

        payment.setId(UUID.randomUUID().toString());

        logger.info("Generated payment ID: " + payment.getId());

        return ResponseEntity
            .status(HttpStatus.OK)
            .header("requestId", requestId)
            .body(payment);
    }
    
}
