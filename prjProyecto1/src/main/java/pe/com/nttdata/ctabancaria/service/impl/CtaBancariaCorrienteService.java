package pe.com.nttdata.ctabancaria.service.impl;

import pe.com.nttdata.ctabancaria.entity.CtaBancariaCorriente;
import pe.com.nttdata.ctabancaria.entity.Deposito;
import pe.com.nttdata.ctabancaria.entity.MovimientoCta;
import pe.com.nttdata.ctabancaria.entity.Retiro;
import pe.com.nttdata.ctabancaria.service.ICtaBancariaCorrienteService;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class CtaBancariaCorrienteService implements ICtaBancariaCorrienteService {

	@Override
	public void crear(Mono<CtaBancariaCorriente> ctaBancaria) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void eliminar(Mono<CtaBancariaCorriente> ctaBancaria) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Flux<MovimientoCta> obtenerTodosMovimientos(Mono<CtaBancariaCorriente> ctaBancaria) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public double obtenerSaldoDisponible(Mono<CtaBancariaCorriente> ctaBancaria) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void depositar(Mono<CtaBancariaCorriente> ctaBancaria, Deposito deposito) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void retirar(Mono<CtaBancariaCorriente> ctaBancaria, Retiro retiro) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void anadirTitular(CtaBancariaCorriente ctaBancariaCorriente, String titular) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removerTitular(CtaBancariaCorriente ctaBancariaCorriente, String titular) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void anadirFirmante(CtaBancariaCorriente ctaBancariaCorriente, String firmante) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removerFirmante(CtaBancariaCorriente ctaBancariaCorriente, String firmante) {
		// TODO Auto-generated method stub
		
	}

}
