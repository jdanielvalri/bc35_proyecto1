package pe.com.nttdata.service;

import pe.com.nttdata.ctabancaria.entity.CtaBancariaCorriente;
import reactor.core.publisher.Mono;

public interface ICtaCorrienteService   {

    public Mono<CtaBancariaCorriente> save(CtaBancariaCorriente ctaCorriente);
}
