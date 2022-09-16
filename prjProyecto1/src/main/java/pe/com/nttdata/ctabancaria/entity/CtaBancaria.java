package pe.com.nttdata.ctabancaria.entity;

import pe.com.nttdata.cliente.entity.Cliente;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public abstract class CtaBancaria {
	
	private Integer id;
	private double comisionMantenimiento;
	private boolean tieneLimiteMaxMovimientoMensual;
	private int LimiteMaxMovimientoMensual;
	
	private Mono<Cliente> cliente;
	private Flux<MovimientoCtaBancaria> movimientosCtaBancaria;
	
	private double montoDisponible;		// Calculado

}
