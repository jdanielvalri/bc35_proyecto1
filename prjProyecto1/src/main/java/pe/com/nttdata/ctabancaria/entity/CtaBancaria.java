package pe.com.nttdata.ctabancaria.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import pe.com.nttdata.cliente.entity.Cliente;
import pe.com.nttdata.enumerador.ETipoCtaBancaria;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

@Data
public class CtaBancaria {
	
	private Integer id;
	private double comisionMantenimiento;
	private boolean tieneLimiteMaxMovimientoMensual;
	private int LimiteMaxMovimientoMensual;
	
	private Cliente cliente;
	private List<MovimientoCtaBancaria> movimientosCtaBancaria;
	private ETipoCtaBancaria type;
	
	private double montoDisponible;		// Calculado

}
