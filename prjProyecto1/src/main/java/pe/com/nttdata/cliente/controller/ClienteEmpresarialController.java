package pe.com.nttdata.cliente.controller;

import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.com.nttdata.cliente.entity.ClienteEmpresarial;
import pe.com.nttdata.cliente.entity.ClientePersonal;
import pe.com.nttdata.cliente.service.IClienteEmpresarialService;
import pe.com.nttdata.cliente.service.IClientePersonalService;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/clienteempresarial")
public class ClienteEmpresarialController {

    @Autowired
    IClienteEmpresarialService iClienteEmpresarialService;

    @PostMapping
    @Operation(summary = "Registro de clientes personales")
    public Mono<ClienteEmpresarial> save(@RequestBody ClienteEmpresarial clienteEmpresarial){

        Mono<ClienteEmpresarial> cliente = Mono.just(clienteEmpresarial);
        iClienteEmpresarialService.crear(cliente);
        return cliente;
    }

}
