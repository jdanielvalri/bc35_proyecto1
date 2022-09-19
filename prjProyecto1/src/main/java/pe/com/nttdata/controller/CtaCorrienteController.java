package pe.com.nttdata.controller;

import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;
import pe.com.nttdata.ctabancaria.entity.CtaBancariaCorriente;
import pe.com.nttdata.service.ICtaCorrienteService;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/ctacorriente")
public class CtaCorrienteController {

    @Autowired
    @Qualifier("ctacorrienteService")
    private ICtaCorrienteService iCtaCorrienteService;

    @PostMapping
    @Operation(summary = "Registro de cta corriente")
    public Mono<CtaBancariaCorriente> save(@RequestBody CtaBancariaCorriente ctaCorriente){
        return iCtaCorrienteService.save(ctaCorriente);
    }
}
