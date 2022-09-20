package pe.com.nttdata.ctabancaria.controller;

import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.server.ServerResponse;
import pe.com.nttdata.ctabancaria.entity.CtaBancariaCorriente;
import pe.com.nttdata.ctabancaria.service.ICtaBancariaCorrienteService;
import reactor.core.publisher.Mono;
//import pe.com.nttdata.ctabancaria.service.ICtaCorrienteService;


@RestController
@RequestMapping("/ctabancariacorriente")
public class CtaBancariaCorrienteController {

    @Autowired
    //@Qualifier("ctacorrienteService")
    private ICtaBancariaCorrienteService iCtaBancariaCorrienteService;

    @PostMapping
    @Operation(summary = "Registro de cta corriente")
    public Mono<CtaBancariaCorriente> save(@RequestBody CtaBancariaCorriente ctaCorriente){

        Mono<CtaBancariaCorriente> response = Mono.just(ctaCorriente);
        iCtaBancariaCorrienteService.crear(Mono.just(ctaCorriente));
        return response;
    }

}
