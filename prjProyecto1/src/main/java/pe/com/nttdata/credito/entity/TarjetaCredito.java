package pe.com.nttdata.credito.entity;

import reactor.core.publisher.Flux;

public class TarjetaCredito extends Credito {
	
	private double montoCreditoDisponible;		// Calculado
	private Flux<TCConsumo> consumos;

}
