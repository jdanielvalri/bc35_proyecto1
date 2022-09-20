package pe.com.nttdata.cliente.service;

import pe.com.nttdata.cliente.entity.Cliente;
import pe.com.nttdata.ctabancaria.entity.CtaBancaria;
import pe.com.nttdata.ctabancaria.entity.Deposito;
import pe.com.nttdata.ctabancaria.entity.MovimientoCta;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface IClienteService <T extends Cliente> {

    void crear(Mono<T> cliente);

    void actualizar(Mono<T> cliente);

    void eliminar(Mono<T> cliente);

    Flux<T> listar();

    Mono<T> obtener(String codigo);
}
