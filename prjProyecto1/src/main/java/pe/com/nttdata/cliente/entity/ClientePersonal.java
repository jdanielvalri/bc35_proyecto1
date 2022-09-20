package pe.com.nttdata.cliente.entity;

import lombok.Data;
import pe.com.nttdata.credito.entity.CreditoPersonal;
import pe.com.nttdata.ctabancaria.entity.CtaBancaria;
import reactor.core.publisher.Mono;

@Data
public class ClientePersonal extends Cliente {

	private CtaBancaria ctaBancaria;
	private CreditoPersonal creditoPersonal;
	
	public ClientePersonal() {
		super.setType(ETipoCliente.PERSONAL);
	}
	
}
