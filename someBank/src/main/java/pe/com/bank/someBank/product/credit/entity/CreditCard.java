package pe.com.bank.someBank.product.credit.entity;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreditCard extends Credit {
	
	private List<CreditCardConsumption> listConsumptions;
	private double creditAmountConsumed;

}
