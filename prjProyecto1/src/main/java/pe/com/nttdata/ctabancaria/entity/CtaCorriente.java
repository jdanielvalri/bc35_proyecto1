package pe.com.nttdata.ctabancaria.entity;

import reactor.core.publisher.Flux;

public class CtaCorriente extends CtaBancaria {

	private Flux<String> titulares;
	private Flux<String> firmantes;
	
}
