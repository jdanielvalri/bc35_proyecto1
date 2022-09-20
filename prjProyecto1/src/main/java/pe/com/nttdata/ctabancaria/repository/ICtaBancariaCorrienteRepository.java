package pe.com.nttdata.ctabancaria.repository;

import pe.com.nttdata.ctabancaria.entity.CtaBancariaCorriente;
import reactor.core.publisher.Mono;

public interface ICtaBancariaCorrienteRepository {

    public Mono<CtaBancariaCorriente> save(Mono<CtaBancariaCorriente> ctaBancariaCorriente);
}
