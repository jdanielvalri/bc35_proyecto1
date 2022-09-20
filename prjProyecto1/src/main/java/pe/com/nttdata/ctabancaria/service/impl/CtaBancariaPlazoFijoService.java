package pe.com.nttdata.ctabancaria.service.impl;

import org.springframework.stereotype.Service;
import pe.com.nttdata.ctabancaria.entity.CtaBancariaPlazoFijo;
import pe.com.nttdata.ctabancaria.entity.Deposito;
import pe.com.nttdata.ctabancaria.entity.MovimientoCta;
import pe.com.nttdata.ctabancaria.entity.Retiro;
import pe.com.nttdata.ctabancaria.service.ICtaBancariaPlazoFijoService;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class CtaBancariaPlazoFijoService implements ICtaBancariaPlazoFijoService {

	@Override
	public void crear(Mono<CtaBancariaPlazoFijo> ctaBancaria) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void eliminar(Mono<CtaBancariaPlazoFijo> ctaBancaria) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Flux<MovimientoCta> obtenerTodosMovimientos(Mono<CtaBancariaPlazoFijo> ctaBancaria) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public double obtenerSaldoDisponible(Mono<CtaBancariaPlazoFijo> ctaBancaria) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void depositar(Mono<CtaBancariaPlazoFijo> ctaBancaria, Deposito deposito) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void retirar(Mono<CtaBancariaPlazoFijo> ctaBancaria, Retiro retiro) {
		// TODO Auto-generated method stub
		
	}

}
