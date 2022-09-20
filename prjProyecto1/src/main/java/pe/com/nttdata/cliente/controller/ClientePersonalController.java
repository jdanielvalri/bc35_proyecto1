package pe.com.nttdata.cliente.controller;

import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.com.nttdata.cliente.entity.ClientePersonal;
import pe.com.nttdata.cliente.service.IClientePersonalService;
import pe.com.nttdata.ctabancaria.entity.CtaBancariaCorriente;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/clientepersonal")
public class ClientePersonalController {

    @Autowired
    IClientePersonalService iClientePersonalService;

    @PostMapping
    @Operation(summary = "Registro de clientes personales")
    public Mono<ClientePersonal> save(@RequestBody ClientePersonal clientePersonal){

        Mono<ClientePersonal> cliente = Mono.just(clientePersonal);
        iClientePersonalService.crear(cliente);
        return cliente;
    }

    @GetMapping
    @Operation(summary = "Listado de clientes personales")
    public Flux<ClientePersonal> find(){
        return iClientePersonalService.listar();
    }
}
