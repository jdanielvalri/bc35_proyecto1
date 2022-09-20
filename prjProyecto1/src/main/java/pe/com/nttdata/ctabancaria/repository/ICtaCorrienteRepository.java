package pe.com.nttdata.ctabancaria.repository;

import pe.com.nttdata.ctabancaria.entity.CtaBancariaCorriente;
import reactor.core.publisher.Mono;

public interface ICtaCorrienteRepository {

    public Mono<CtaBancariaCorriente> save(CtaBancariaCorriente ctaCorriente);
}
