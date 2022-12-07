package com.sagen.cards.services;

import com.sagen.cards.entity.Customer;
import org.springframework.http.ResponseEntity;

public interface CardsServices {
    ResponseEntity<?> getCardDetails(Customer customer);
}
