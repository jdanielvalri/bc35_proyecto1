package pe.com.nttdata.ctabancaria.entity;

import lombok.Data;

import java.util.Date;

@Data
public class MovimientoCta {

	private ETipoMovimientoCtaBancaria type;
	private Date fecha;
	private double monto;
	

}
