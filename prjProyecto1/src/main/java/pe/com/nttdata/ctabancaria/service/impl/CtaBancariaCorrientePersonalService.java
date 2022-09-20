package pe.com.nttdata.ctabancaria.service.impl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import pe.com.nttdata.cliente.entity.Cliente;
import pe.com.nttdata.cliente.entity.ClientePersonal;
import pe.com.nttdata.ctabancaria.entity.CtaBancariaCorriente;
import pe.com.nttdata.ctabancaria.service.ICtaBancariaCorrientePersonalService;
import reactor.core.publisher.Mono;
//import pe.com.nttdata.ctabancaria.service.ICtaCorrientePersonalService;


@Service
@Qualifier("ctaBancariaCorrientePersonalService")
public class CtaBancariaCorrientePersonalService implements ICtaBancariaCorrientePersonalService {

    private static final Logger logger = LogManager.getLogger(CtaBancariaCorrientePersonalService.class);

    @Override
    public Mono<CtaBancariaCorriente> getByDocumento(String documento) {
        return null;
    }

    @Override
    public boolean existeCuenta(Mono<CtaBancariaCorriente> ctaBancariaCorriente){

        logger.info("validar si existe Cuenta");

        boolean existe = false;

        Mono<CtaBancariaCorriente> ctaCorrienteMono = getByDocumento(ctaBancariaCorriente.block().getCliente().getDocumento());

        if(ctaCorrienteMono!=null){
            existe = true;
        }

        return existe;
    }

}
