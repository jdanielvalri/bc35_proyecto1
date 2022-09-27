package pe.com.nttdata.cliente.service;

import pe.com.nttdata.cliente.dto.DtoClientePersonal;
import pe.com.nttdata.cliente.model.Cliente;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface IClienteService <T extends Cliente> {

    Mono<T> crear(Mono<T> cliente);

    void actualizar(Mono<T> cliente);

    void eliminar(Mono<T> cliente);

    Flux<T> listar();

    Mono<T> obtener(Integer id);

    Mono<DtoClientePersonal> obtenerDetalle(Integer id);
}
