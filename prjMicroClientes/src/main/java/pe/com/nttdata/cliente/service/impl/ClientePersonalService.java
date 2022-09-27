package pe.com.nttdata.cliente.service.impl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import pe.com.nttdata.cliente.dto.DtoClientePersonal;
import pe.com.nttdata.cliente.model.ClientePersonal;
import pe.com.nttdata.cliente.repository.IClientePersonalRepository;
import pe.com.nttdata.cliente.service.IClientePersonalService;
import pe.com.nttdata.credit.entity.Credit;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.List;

@Service
public class ClientePersonalService implements IClientePersonalService {

    private static final Logger logger = LogManager.getLogger(ClientePersonalService.class);

    private final WebClient webClient;

    public ClientePersonalService(WebClient.Builder webClientBuilder){
        this.webClient = webClientBuilder.baseUrl("http://localhost:8086").build();
    }

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
    public Mono<ClientePersonal> obtener(Integer id) {
        return null;
    }

    @Override
    public Mono<DtoClientePersonal> obtenerDetalle(Integer id) {

        logger.debug("obtener");

        Flux<Credit> credityCliente = this.webClient.get().uri("/credits/findByIdClient/{id}", id).retrieve().bodyToFlux(Credit.class);

        List<Credit> creditos = new ArrayList<>();
        Credit credit = new Credit();

        return credityCliente.flatMap(x -> {
            credit.setId(x.getId());
            credit.setCreditAmount(x.getCreditAmount());
            creditos.add(credit);
            Mono<DtoClientePersonal> creditMono = Mono.just(new DtoClientePersonal("1","46668322","daniel valenzuela", creditos));
            return creditMono;
        }).single();


    }
}
