package pe.com.nttdata.credito.entity;

import pe.com.nttdata.cliente.entity.Cliente;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public abstract class Credito {

	private Integer id;
	private Mono<Cliente> cliente;
	private double montoCredito;
	private Flux<PagoCredito> pagosRealizados;
	
}
