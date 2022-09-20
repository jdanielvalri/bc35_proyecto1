package pe.com.nttdata.ctabancaria.service;

import pe.com.nttdata.ctabancaria.entity.CtaBancaria;
import pe.com.nttdata.ctabancaria.entity.Deposito;
import pe.com.nttdata.ctabancaria.entity.MovimientoCta;
import pe.com.nttdata.ctabancaria.entity.Retiro;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ICtaBancariaService <T extends CtaBancaria> {
	
	void crear(Mono<T> ctaBancaria);
	
	void eliminar(Mono<T> ctaBancaria);
	
	Flux<MovimientoCta> obtenerTodosMovimientos(Mono<T> ctaBancaria);
	
	double obtenerSaldoDisponible(Mono<T> ctaBancaria);
	
	void depositar(Mono<T> ctaBancaria, Deposito deposito);
	
	void retirar(Mono<T> ctaBancaria, Retiro retiro);

}
