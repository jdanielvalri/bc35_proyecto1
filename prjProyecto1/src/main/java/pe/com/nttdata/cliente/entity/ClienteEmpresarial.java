package pe.com.nttdata.cliente.entity;

import pe.com.nttdata.credito.entity.CreditoEmpresarial;
import pe.com.nttdata.ctabancaria.entity.CtaCorriente;
import reactor.core.publisher.Flux;

public class ClienteEmpresarial extends Cliente {

	private Flux<CtaCorriente> ctaCorriente;
	private Flux<CreditoEmpresarial> creditoEmpresarial;
	
}
