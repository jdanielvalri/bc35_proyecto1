package pe.com.nttdata.service;

import pe.com.nttdata.ctabancaria.entity.CtaBancariaCorriente;
import reactor.core.publisher.Mono;

public interface ICtaCorrienteEmpresarialService extends  ICtaCorrienteService {
    public boolean validarTitular(CtaBancariaCorriente ctaCorriente);

    public Mono<CtaBancariaCorriente> save(CtaBancariaCorriente ctaCorriente);

}
