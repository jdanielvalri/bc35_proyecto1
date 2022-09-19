package pe.com.nttdata.service.impl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import pe.com.nttdata.ctabancaria.entity.CtaBancariaCorriente;
import pe.com.nttdata.enumerador.ETipoCliente;
import pe.com.nttdata.repository.ICtaCorrienteRepository;
import pe.com.nttdata.service.ICtaCorrienteEmpresarialService;
import pe.com.nttdata.service.ICtaCorrientePersonalService;
import pe.com.nttdata.service.ICtaCorrienteService;
import reactor.core.publisher.Mono;

@Service
@Qualifier("ctacorrienteService")
public class CtaCorrienteServiceImpl implements ICtaCorrienteService {

    private static final Logger logger = LogManager.getLogger(CtaCorrienteServiceImpl.class);
    @Autowired
    private ICtaCorrientePersonalService iCtaCorrientePersonalService;
    @Autowired
    private ICtaCorrienteEmpresarialService iCtaCorrienteEmpresarialService;

    @Autowired
    private ICtaCorrienteRepository iCtaCorrienteRepository;

    @Override
    public Mono<CtaBancariaCorriente> save(CtaBancariaCorriente ctaCorriente) {

        logger.debug("Iniciando registro de cuenta corriente");

        if(ctaCorriente.getCliente().getType().toString().equals(ETipoCliente.PERSONAL.toString())){
            //Un cliente personal solo puede tener un máximo de una cuenta de ahorro, una cuenta
            //corriente o cuentas a plazo fijo.
            if(iCtaCorrientePersonalService.existeCuenta(ctaCorriente)){
                logger.error("Ya existe na cuenta corriente para el cliente");
                return null;
            }
        }
        //Un cliente empresarial no puede tener una cuenta de ahorro o de plazo fijo pero sí
        //múltiples cuentas corrientes.
        if(ctaCorriente.getCliente().getType().toString().equals(ETipoCliente.EMPRESARIAL.toString())){
            //Las cuentas bancarias empresariales pueden tener uno o más titulares y cero o más
            //firmantes autorizados.
            if(!iCtaCorrienteEmpresarialService.validarTitular(ctaCorriente)){
                logger.error("Debe ingresar al menos un titular para la cuenta");
                return null;
            }
        }

        return iCtaCorrienteRepository.save(ctaCorriente);
    }


}
