package pe.com.bank.someBank.product.credit.entity;

import java.util.List;

import lombok.Getter;
import lombok.Setter;
import pe.com.bank.someBank.client.entity.Client;

@Getter
@Setter
public class Credit {
	
	public enum EType{
		PERSONAL, ENTERPRISE, CARD
	}

	private Integer id;
	private double creditAmount;
	
	private EType type;
	
	private Client client;
	
	private List<CreditPayment> listPayments;

	
}
