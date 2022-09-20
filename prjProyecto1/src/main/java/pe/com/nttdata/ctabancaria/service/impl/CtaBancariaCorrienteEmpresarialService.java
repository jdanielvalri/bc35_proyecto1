package pe.com.nttdata.ctabancaria.service.impl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import pe.com.nttdata.ctabancaria.entity.CtaBancariaCorriente;
import pe.com.nttdata.ctabancaria.service.ICtaBancariaCorrienteEmpresarialService;
import reactor.core.publisher.Mono;
//import pe.com.nttdata.ctabancaria.service.ICtaCorrienteEmpresarialService;


@Service
@Qualifier("ctaBancariaCorrienteEmpresarialService")
public class CtaBancariaCorrienteEmpresarialService implements ICtaBancariaCorrienteEmpresarialService {

    private static final Logger logger = LogManager.getLogger(CtaBancariaCorrienteEmpresarialService.class);

    @Override
    public boolean validarTitular(Mono<CtaBancariaCorriente> ctaBancariaCorriente){

        logger.info("validarTitular");

        boolean valido = false;

        if(ctaBancariaCorriente.block().getTitulares()!=null){
            if(ctaBancariaCorriente.block().getTitulares().size() >0){
                valido = true;
            }
        }

        return valido;
    }

}
