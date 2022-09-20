package pe.com.nttdata.ctabancaria.service;

import pe.com.nttdata.ctabancaria.entity.CtaBancariaCorriente;
import reactor.core.publisher.Mono;

public interface ICtaBancariaCorrientePersonalService  {

    public boolean existeCuenta(Mono<CtaBancariaCorriente> ctaBancariaCorriente);

    public Mono<CtaBancariaCorriente> getByDocumento(String documento);
}
