package pe.com.nttdata.ctabancaria.service.impl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.com.nttdata.cliente.entity.ETipoCliente;
import pe.com.nttdata.ctabancaria.entity.CtaBancariaCorriente;
import pe.com.nttdata.ctabancaria.entity.Deposito;
import pe.com.nttdata.ctabancaria.entity.MovimientoCta;
import pe.com.nttdata.ctabancaria.entity.Retiro;
import pe.com.nttdata.ctabancaria.repository.impl.CtaBancariaCorrienteRepository;
import pe.com.nttdata.ctabancaria.service.ICtaBancariaCorrienteEmpresarialService;
import pe.com.nttdata.ctabancaria.service.ICtaBancariaCorrientePersonalService;
import pe.com.nttdata.ctabancaria.service.ICtaBancariaCorrienteService;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class CtaBancariaCorrienteService implements ICtaBancariaCorrienteService {

	private static final Logger logger = LogManager.getLogger(CtaBancariaCorrientePersonalService.class);

	@Autowired
	private ICtaBancariaCorrientePersonalService iCtaBancariaCorrientePersonalService;
	@Autowired
	private ICtaBancariaCorrienteEmpresarialService iCtaBancariaCorrienteEmpresarialService;

	@Autowired
	private CtaBancariaCorrienteRepository ctaCorrienteRepository;

	@Override
	public void crear(Mono<CtaBancariaCorriente> ctaBancaria) {
		// TODO Auto-generated method stub
		logger.debug("Crear cuenta corriente");

		if(ctaBancaria.block().getCliente().getType().toString().equals(ETipoCliente.PERSONAL.toString())){
			//Un cliente personal solo puede tener un máximo de una cuenta de ahorro, una cuenta
			//corriente o cuentas a plazo fijo.
			if(iCtaBancariaCorrientePersonalService.existeCuenta(ctaBancaria)){
				logger.error("Ya existe na cuenta corriente para el cliente");
				return;
			}
		}

		//Un cliente empresarial no puede tener una cuenta de ahorro o de plazo fijo pero sí
		//múltiples cuentas corrientes.
		if(ctaBancaria.block().getCliente().getType().toString().equals(ETipoCliente.EMPRESARIAL.toString())){
			//Las cuentas bancarias empresariales pueden tener uno o más titulares y cero o más
			//firmantes autorizados.
			if(!iCtaBancariaCorrienteEmpresarialService.validarTitular(ctaBancaria)){
				logger.error("Debe ingresar al menos un titular para la cuenta");
				return;
			}
		}

		ctaCorrienteRepository.save(ctaBancaria);
		
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
