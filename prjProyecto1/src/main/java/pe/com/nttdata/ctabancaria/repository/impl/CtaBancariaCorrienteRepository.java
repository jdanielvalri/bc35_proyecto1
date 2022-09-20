package pe.com.nttdata.ctabancaria.repository.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import pe.com.nttdata.ctabancaria.entity.CtaBancariaCorriente;
import pe.com.nttdata.ctabancaria.repository.ICtaBancariaCorrienteRepository;
import reactor.core.publisher.Mono;

@Repository
public class CtaBancariaCorrienteRepository implements ICtaBancariaCorrienteRepository {

    private static final Logger logger = LoggerFactory.getLogger(CtaBancariaCorrienteRepository.class);

    @Override
    public Mono<CtaBancariaCorriente> save(
            Mono<CtaBancariaCorriente> ctaBancariaCorriente) {
        logger.info("Se registró la cta corriente");
        return ctaBancariaCorriente;
    }

}
