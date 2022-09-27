package pe.com.nttdata.credit.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import pe.com.nttdata.cliente.model.Cliente;

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

}
