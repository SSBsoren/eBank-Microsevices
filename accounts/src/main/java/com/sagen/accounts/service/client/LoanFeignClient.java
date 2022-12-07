package com.sagen.accounts.service.client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sagen.accounts.entity.Customer;
import com.sagen.accounts.entity.Loans;
@FeignClient("loans")
public interface LoanFeignClient {
	@RequestMapping(method = RequestMethod.POST,value = "myLoans",consumes = "application/json")
	List<Loans> getLoansDetails(@RequestBody Customer customer);

}
