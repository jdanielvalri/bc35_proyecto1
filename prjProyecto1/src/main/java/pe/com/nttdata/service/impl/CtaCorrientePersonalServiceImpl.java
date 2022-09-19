package pe.com.nttdata.service.impl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import pe.com.nttdata.ctabancaria.entity.CtaBancariaCorriente;
import pe.com.nttdata.repository.ICtaCorrienteRepository;
import pe.com.nttdata.service.ICtaCorrientePersonalService;
import reactor.core.publisher.Mono;

@Service
@Qualifier("ctacorrientePersonalService")
public class CtaCorrientePersonalServiceImpl implements  ICtaCorrientePersonalService{

    private static final Logger logger = LogManager.getLogger(CtaCorrientePersonalServiceImpl.class);

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

}
