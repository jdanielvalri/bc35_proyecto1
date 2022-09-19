package pe.com.nttdata.service;

import pe.com.nttdata.ctabancaria.entity.CtaBancariaCorriente;
import reactor.core.publisher.Mono;

public interface ICtaCorrientePersonalService extends ICtaCorrienteService {
    public boolean existeCuenta(CtaBancariaCorriente ctaCorriente);
    public Mono<CtaBancariaCorriente> getByIdCliente(Integer idCliente);
    public Mono<CtaBancariaCorriente> save(CtaBancariaCorriente ctaCorriente);
}
