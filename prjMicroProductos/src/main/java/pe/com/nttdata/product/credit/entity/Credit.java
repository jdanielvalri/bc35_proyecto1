package pe.com.nttdata.product.credit.entity;

import lombok.Getter;
import lombok.Setter;
import pe.com.nttdata.product.client.entity.Client;

import java.util.List;

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
