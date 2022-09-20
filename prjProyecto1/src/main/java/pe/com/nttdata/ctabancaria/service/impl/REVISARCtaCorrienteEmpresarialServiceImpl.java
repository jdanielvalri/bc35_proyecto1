package pe.com.nttdata.ctabancaria.service.impl;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import pe.com.nttdata.ctabancaria.entity.CtaBancariaCorriente;
import pe.com.nttdata.ctabancaria.repository.ICtaCorrienteRepository;
//import pe.com.nttdata.ctabancaria.service.ICtaCorrienteEmpresarialService;
import reactor.core.publisher.Mono;

@Service
@Qualifier("ctacorrienteEmpresarialService")
public class REVISARCtaCorrienteEmpresarialServiceImpl {
/*
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(CtaCorrienteEmpresarialServiceImpl.class);

    @Autowired
    private ICtaCorrienteRepository iCtaCorrienteRepository;

    @Override
    public Mono<CtaBancariaCorriente> save(CtaBancariaCorriente ctaCorriente) {
       return null;
    }

    @Override
    public boolean validarTitular(CtaBancariaCorriente ctaCorriente){

        logger.info("validarTitular");

        boolean valido = false;

        if(ctaCorriente.getTitulares()!=null){
            if(ctaCorriente.getTitulares().size() >0){
                valido = true;
            }
        }

        return valido;
    }
*/
}
