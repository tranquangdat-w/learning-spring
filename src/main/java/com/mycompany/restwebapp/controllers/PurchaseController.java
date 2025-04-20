package com.mycompany.restwebapp.controllers;

import org.springframework.web.bind.annotation.RestController;

import com.mycompany.restwebapp.model.Purchase;
import com.mycompany.restwebapp.repository.PurchaseRepository;

import lombok.AllArgsConstructor;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@AllArgsConstructor
public class PurchaseController {

  private final PurchaseRepository purchaseRepository;

  @GetMapping("purchase")
  public List<Purchase> getAllPurchase() {
    return purchaseRepository.findAllPurchases();
  }

  @PostMapping("purchase")
  public void storePurchase(@RequestBody Purchase purchase) {
    purchaseRepository.storePurchase(purchase);
  }
}
