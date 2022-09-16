package pe.com.nttdata.cliente.entity;

import reactor.core.publisher.Mono;

public abstract class Cliente {
	
	public enum E_Type {
		PERSONAL ,
		EMPRESARIAL 
	}
	
	private Integer id;
	private Mono<Object> tarjetaCredito;
	
	private E_Type type;

}
