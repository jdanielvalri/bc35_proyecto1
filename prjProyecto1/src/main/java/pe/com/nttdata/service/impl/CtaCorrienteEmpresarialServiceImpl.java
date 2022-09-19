package pe.com.nttdata.service.impl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import pe.com.nttdata.ctabancaria.entity.CtaBancariaCorriente;
import pe.com.nttdata.repository.ICtaCorrienteRepository;
import pe.com.nttdata.service.ICtaCorrienteEmpresarialService;
import reactor.core.publisher.Mono;

@Service
@Qualifier("ctacorrienteEmpresarialService")
public class CtaCorrienteEmpresarialServiceImpl implements  ICtaCorrienteEmpresarialService {

    private static final Logger logger = LogManager.getLogger(CtaCorrienteEmpresarialServiceImpl.class);

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

}
