package com.sagen.cards.services;

import com.sagen.cards.entity.Customer;
import com.sagen.cards.entity.Card;
import com.sagen.cards.repository.CardsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CardsServicesImpl implements CardsServices {

    @Autowired
    private CardsRepository cardsRepository;

    @Override
    public ResponseEntity<?> getCardDetails(Customer customer) {
        List<Card> cards = cardsRepository.findByCustomerId(customer.getCustomerId());

        if (cards == null) {
            ResponseEntity.ok("Account not found");
        }
        return ResponseEntity.ok(cards);

    }
}
