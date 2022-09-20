package pe.com.nttdata.ctabancaria.service;

import pe.com.nttdata.ctabancaria.entity.CtaBancariaCorriente;
import reactor.core.publisher.Mono;

public interface ICtaBancariaCorrienteEmpresarialService {
    public boolean validarTitular(Mono<CtaBancariaCorriente> ctaBancariaCorriente);
}
