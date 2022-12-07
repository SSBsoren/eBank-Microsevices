package com.sagen.accounts.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.sagen.accounts.config.AccountsServiceConfig;
import com.sagen.accounts.entity.Account;
import com.sagen.accounts.entity.Card;
import com.sagen.accounts.entity.Customer;
import com.sagen.accounts.entity.Loans;
import com.sagen.accounts.model.CustomerDetails;
import com.sagen.accounts.model.Properties;
import com.sagen.accounts.repository.AccountsRepository;
import com.sagen.accounts.service.client.CardsFeignClient;
import com.sagen.accounts.service.client.LoanFeignClient;
import com.sagen.accounts.services.AccountServices;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import io.github.resilience4j.retry.annotation.Retry;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AccountsController {
	@Autowired
	AccountsRepository accountsRepository;

	@Autowired
	AccountServices accountServices;

	@Autowired
	AccountsServiceConfig accountsServiceConfig;

	@Autowired
	CardsFeignClient cardsFeignClient;

	@Autowired
	LoanFeignClient loanFeignClient;

	@PostMapping("/myAccount")
	public ResponseEntity<?> getAccountDetails(@RequestBody Customer customer) {
		return accountServices.getAccountDetails(customer);
	}

	@GetMapping("/account/properties")
	public String getPropertiesDetails() throws JsonProcessingException {
		ObjectWriter objectWriter = new ObjectMapper().writer().withDefaultPrettyPrinter();
		Properties properties = new Properties(accountsServiceConfig.getMsg(), accountsServiceConfig.getBuildVersion(),
				accountsServiceConfig.getMailDetails(), accountsServiceConfig.getActiveBranches());
		String jsonStr = objectWriter.writeValueAsString(properties);
		return jsonStr;
	}

	@PostMapping("/myCustomerDetails")
	// @CircuitBreaker(name = "detailsForCustomerSupportApp", fallbackMethod =
	// "myCustomerDetailsFallBack")
	@Retry(name = "retryForMyCustomerDetails")
	public CustomerDetails myCustomerDetails(@RequestBody Customer customer) {
		Account account = accountsRepository.findByCustomerId(customer.getCustomerId());
		List<Loans> loans = loanFeignClient.getLoansDetails(customer);
		List<Card> cards = cardsFeignClient.getCardsDetails(customer);

		CustomerDetails customerDetails = new CustomerDetails();
		customerDetails.setAccount(account);
		customerDetails.setCard(cards);
		customerDetails.setLoans(loans);

		return customerDetails;
	}

	private CustomerDetails myCustomerDetailsFallBack(Customer customer, Throwable t) {
		Account account = accountsRepository.findByCustomerId(customer.getCustomerId());
		List<Loans> loans = loanFeignClient.getLoansDetails(customer);

		CustomerDetails customerDetails = new CustomerDetails();
		customerDetails.setAccount(account);
		customerDetails.setLoans(loans);

		return customerDetails;
	}

	@GetMapping("/sayHello")
	@RateLimiter(name = "sayHello", fallbackMethod = "sayHelloFallback")
	public String sayHello() {
		return "Hello, Welcom to e-Bank";
	}
	
	private String sayHelloFallback(Throwable t) {
		return "Hi, Welcom to e-Bank";

	}
}
