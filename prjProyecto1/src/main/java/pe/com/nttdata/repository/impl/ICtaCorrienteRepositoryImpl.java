package pe.com.nttdata.repository.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import pe.com.nttdata.ctabancaria.entity.CtaBancariaCorriente;
import pe.com.nttdata.repository.ICtaCorrienteRepository;
import pe.com.nttdata.service.impl.CtaCorrienteServiceImpl;
import reactor.core.publisher.Mono;

@Repository
public class ICtaCorrienteRepositoryImpl implements ICtaCorrienteRepository {

    private static final Logger logger = LoggerFactory.getLogger(ICtaCorrienteRepositoryImpl.class);

    @Override
    public Mono<CtaBancariaCorriente> save(
            CtaBancariaCorriente ctaCorriente) {
        logger.info("Se registró la cta corriente");
        return Mono.just(ctaCorriente);
    }
}
