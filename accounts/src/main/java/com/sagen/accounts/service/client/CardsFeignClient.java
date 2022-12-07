package com.sagen.accounts.service.client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sagen.accounts.entity.Card;
import com.sagen.accounts.entity.Customer;

@FeignClient("cards")
public interface CardsFeignClient {
	@RequestMapping(method = RequestMethod.POST,value = "myCards",consumes = "application/json")
	List<Card> getCardsDetails(@RequestBody Customer customer);

}
