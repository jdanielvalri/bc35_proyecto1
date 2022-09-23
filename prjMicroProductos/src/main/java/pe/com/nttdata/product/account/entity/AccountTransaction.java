package pe.com.nttdata.product.account.entity;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

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