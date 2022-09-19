package pe.com.nttdata.credito.entity;

import reactor.core.publisher.Flux;

import java.util.List;

public class TarjetaCredito extends Credito {
	
	private double montoCreditoDisponible;		// Calculado
	private List<TCConsumo> consumos;

}
