package pe.com.bank.someBank.product.account.entity;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Walter
 *
 */
@Getter
@Setter
public class FixedTermAccount extends Account {
	
	private int dayTransaction;

	@Override
	public String toString() {
		return super.toString() + "FixedTermAccount [dayTransaction=" + dayTransaction + "]";
	}

	
}
