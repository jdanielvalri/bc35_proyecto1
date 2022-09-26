package pe.com.nttdata.cliente.controller;

import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.com.nttdata.cliente.model.ClientePersonal;
import pe.com.nttdata.cliente.service.IClientePersonalService;
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

        return iClientePersonalService.crear(Mono.just(clientePersonal));
    }

    @GetMapping
    @Operation(summary = "Listado de clientes personales")
    public Flux<ClientePersonal> find(){
        return iClientePersonalService.listar();
    }

   }
