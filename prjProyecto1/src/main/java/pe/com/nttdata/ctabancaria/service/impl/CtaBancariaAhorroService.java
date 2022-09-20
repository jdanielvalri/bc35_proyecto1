package pe.com.nttdata.ctabancaria.service.impl;

import pe.com.nttdata.ctabancaria.entity.CtaBancariaAhorro;
import pe.com.nttdata.ctabancaria.entity.Deposito;
import pe.com.nttdata.ctabancaria.entity.MovimientoCta;
import pe.com.nttdata.ctabancaria.entity.Retiro;
import pe.com.nttdata.ctabancaria.service.ICtaBancariaAhorroService;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class CtaBancariaAhorroService implements ICtaBancariaAhorroService {

	@Override
	public void crear(Mono<CtaBancariaAhorro> ctaBancaria) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void eliminar(Mono<CtaBancariaAhorro> ctaBancaria) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Flux<MovimientoCta> obtenerTodosMovimientos(Mono<CtaBancariaAhorro> ctaBancaria) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public double obtenerSaldoDisponible(Mono<CtaBancariaAhorro> ctaBancaria) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void depositar(Mono<CtaBancariaAhorro> ctaBancaria, Deposito deposito) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void retirar(Mono<CtaBancariaAhorro> ctaBancaria, Retiro retiro) {
		// TODO Auto-generated method stub
		
	}

}
