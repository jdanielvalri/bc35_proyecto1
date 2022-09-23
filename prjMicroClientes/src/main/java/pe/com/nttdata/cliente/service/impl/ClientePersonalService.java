package pe.com.nttdata.cliente.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.com.nttdata.cliente.model.ClientePersonal;
import pe.com.nttdata.cliente.repository.IClientePersonalRepository;
import pe.com.nttdata.cliente.service.IClientePersonalService;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class ClientePersonalService implements IClientePersonalService {

    @Autowired
    private IClientePersonalRepository iClientePersonalRepository;

    @Override
    public Mono<ClientePersonal> crear(Mono<ClientePersonal> cliente) {
        ClientePersonal clientePersonal = cliente.block();
        return iClientePersonalRepository.save(clientePersonal);
    }

    @Override
    public void actualizar(Mono<ClientePersonal> cliente) {

    }

    @Override
    public void eliminar(Mono<ClientePersonal> cliente) {

    }

    @Override
    public Flux<ClientePersonal> listar() {
        return iClientePersonalRepository.findAll();
    }

    @Override
    public Mono<ClientePersonal> obtener(String codigo) {
        return iClientePersonalRepository.findById(codigo);
    }
}
