package pe.com.nttdata.ctabancaria.service.impl;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import pe.com.nttdata.ctabancaria.entity.CtaBancariaCorriente;
import pe.com.nttdata.ctabancaria.repository.ICtaCorrienteRepository;
//import pe.com.nttdata.ctabancaria.service.ICtaCorrientePersonalService;
import reactor.core.publisher.Mono;

@Service
@Qualifier("ctacorrientePersonalService")
public class REVISARCtaCorrientePersonalServiceImpl{
/*
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(CtaCorrientePersonalServiceImpl.class);

    @Autowired
    private ICtaCorrienteRepository iCtaCorrienteRepository;

    @Override
    public Mono<CtaBancariaCorriente> getByIdCliente(Integer idCliente) {
        return null;
    }

    @Override
    public Mono<CtaBancariaCorriente> save(CtaBancariaCorriente ctaCorriente) {
       return null;
    }

    @Override
    public boolean existeCuenta(CtaBancariaCorriente ctaCorriente){

        logger.info("validar si existe Cuenta");

        boolean existe = false;

        Mono<CtaBancariaCorriente> ctaCorrienteMono = getByIdCliente(ctaCorriente.getCliente().getId());

        if(ctaCorrienteMono!=null){
            existe = true;
        }

        return existe;
    }
*/
}
