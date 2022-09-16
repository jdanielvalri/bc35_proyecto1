package pe.com.nttdata.cliente.entity;

import pe.com.nttdata.credito.entity.CreditoPersonal;
import pe.com.nttdata.ctabancaria.entity.CtaBancaria;
import reactor.core.publisher.Mono;

public class ClientePersonal extends Cliente {

	private Mono<CtaBancaria> ctaBancaria;
	private Mono<CreditoPersonal> creditoPersonal;
	
}
