package com.sagen.cards.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.sagen.cards.config.CardsServiceConfig;
import com.sagen.cards.entity.Customer;
import com.sagen.cards.model.Properties;
import com.sagen.cards.services.CardsServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
public class CardsController {


    @Autowired
    CardsServices cardsServices;

    @Autowired
    CardsServiceConfig cardsServiceConfig;

    @PostMapping("/myCards")
    public ResponseEntity<?> getCardDetails(@RequestBody Customer customer, HttpServletRequest request) {

        String token = request.getHeader("Authorization");
        System.out.println("Token : "+token);
        return cardsServices.getCardDetails(customer);
    }

    @GetMapping("/cards/properties")
    public String getPropertyDetails() throws JsonProcessingException {
        ObjectWriter objectWriter = new ObjectMapper().writer().withDefaultPrettyPrinter();
        Properties properties = new Properties(
                cardsServiceConfig.getMsg(),
                cardsServiceConfig.getBuildVersion(),
                cardsServiceConfig.getMailDetails(),
                cardsServiceConfig.getActiveBranches()
        );

        String jsonStr = objectWriter.writeValueAsString(properties);
        return jsonStr;
    }

}
