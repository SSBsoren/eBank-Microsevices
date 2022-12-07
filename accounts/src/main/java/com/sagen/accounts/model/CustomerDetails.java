package com.sagen.accounts.model;

import java.util.List;

import com.sagen.accounts.entity.Account;
import com.sagen.accounts.entity.Card;
import com.sagen.accounts.entity.Loans;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data @Getter @Setter
public class CustomerDetails {
	private Account account;
	private List<Loans> loans;
	private List<Card> card;

}
