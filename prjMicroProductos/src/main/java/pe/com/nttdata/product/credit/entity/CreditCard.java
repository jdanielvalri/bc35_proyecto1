package pe.com.nttdata.product.credit.entity;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class CreditCard extends Credit {
	
	private List<CreditCardConsumption> listConsumptions;
	private double creditAmountConsumed;

}
