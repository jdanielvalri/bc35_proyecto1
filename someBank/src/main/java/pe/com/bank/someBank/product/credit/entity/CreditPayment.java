package pe.com.bank.someBank.product.credit.entity;

import java.time.LocalDate;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreditPayment {

	private Integer id;
	private LocalDate date;
	private double amount;
	
}
