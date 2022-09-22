package pe.com.bank.someBank.product.account.entity;

import java.time.LocalDate;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AccountTransaction {
	
	public enum EType{
		WITHDRAW, DEPOSIT
	}
	
	private Integer id;
	private EType type;
	private LocalDate date;
	private double amount;

}