package pe.com.nttdata.product.credit.entity;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class CreditCardConsumption {

	private Integer id;
	private LocalDate date;
	private double amount;
	
}
