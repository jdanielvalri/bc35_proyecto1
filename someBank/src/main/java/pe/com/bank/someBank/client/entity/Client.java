package pe.com.bank.someBank.client.entity;

import java.util.List;
import java.util.Objects;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import pe.com.bank.someBank.product.credit.entity.Credit;
import pe.com.bank.someBank.product.credit.entity.CreditCard;

@Getter
@Setter
@ToString
public class Client {
	
	public enum EType {
		PERSONAL, ENTERPRISE
	}

	private Integer id;
	private String name;
	private CreditCard creditCard;
	private List<Credit> listCredits;
	
	private EType type;
	
	
	@Override
	public int hashCode() {
		return Objects.hash(id, name);
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Client other = (Client) obj;
		return Objects.equals(id, other.id) /*&& Objects.equals(name, other.name)*/;
	}
	
	
	
}
