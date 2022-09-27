package pe.com.nttdata.cliente.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.com.nttdata.cliente.dto.DtoClientePersonal;
import pe.com.nttdata.cliente.model.ClienteEmpresarial;
import pe.com.nttdata.cliente.repository.IClienteEmpresarialRepository;
import pe.com.nttdata.cliente.service.IClienteEmpresarialService;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class ClienteEmpresarialService implements IClienteEmpresarialService {
    @Autowired
    private IClienteEmpresarialRepository iClienteEmpresarialRepository;


    @Override
    public Mono<ClienteEmpresarial> crear(Mono<ClienteEmpresarial> cliente) {
        return iClienteEmpresarialRepository.save(cliente.block());
    }

    @Override
    public void actualizar(Mono<ClienteEmpresarial> cliente) {

    }

    @Override
    public void eliminar(Mono<ClienteEmpresarial> cliente) {

    }

    @Override
    public Flux<ClienteEmpresarial> listar() {
        return  iClienteEmpresarialRepository.findAll();
    }

    @Override
    public Mono<ClienteEmpresarial> obtener(Integer id) {

        return  null;
    }

    @Override
    public Mono<DtoClientePersonal> obtenerDetalle(Integer id) {
        return null;
    }
}
