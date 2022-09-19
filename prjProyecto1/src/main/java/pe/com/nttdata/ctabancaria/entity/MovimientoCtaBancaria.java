package pe.com.nttdata.ctabancaria.entity;

import lombok.Data;
import pe.com.nttdata.enumerador.ETipoMovimientoCtaBancaria;

import java.util.Date;

@Data
public class MovimientoCtaBancaria {

	private ETipoMovimientoCtaBancaria type;
	private Date fecha;
	private double monto;
	

}
