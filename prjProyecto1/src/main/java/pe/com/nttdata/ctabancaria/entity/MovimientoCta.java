package pe.com.nttdata.ctabancaria.entity;

import lombok.Data;

import java.time.LocalDate;
import java.util.Date;

@Data
public class MovimientoCta {

	private ETipoMovimientoCtaBancaria type;
	private LocalDate fecha;
	private double monto;
	

}
