package pe.com.nttdata.product.account.entity;

import lombok.Getter;
import lombok.Setter;
import pe.com.nttdata.product.client.entity.Client;

import java.util.List;

@Getter
@Setter
public class Account {
	
	public enum EType{
		CURRENT, FIXEDTERM, SAVING
	}

	private Integer id;
	
	private double accountMaintanceFee;
	private int maximumMovementLimit;
	private EType type;
	
	private Client client;
	

	private List<String> listHolders;		//	titulares
	private List<String> listSignatories;	//	firmantes
	
	private List<AccountTransaction> listTransactions;
	
	private double availableBalance;

	@Override
	public String toString() {
		return "Account [id=" + id + ", accountMaintanceFee=" + accountMaintanceFee + ", maximumMovementLimit="
				+ maximumMovementLimit + ", type=" + type + ", client=" + client + ", listHolders=" + listHolders
				+ ", listSignatories=" + listSignatories + ", listTransactions=" + listTransactions
				+ ", availableBalance=" + availableBalance + "]";
	}
	
	
	
}
