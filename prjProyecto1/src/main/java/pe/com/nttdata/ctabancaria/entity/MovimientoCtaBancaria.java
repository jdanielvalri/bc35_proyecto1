package pe.com.nttdata.ctabancaria.entity;

import java.time.DateTimeException;
import java.time.LocalDate;

public class MovimientoCtaBancaria {
	
	public enum E_Type{
		RETIRO, DEPOSITO
	}
	
	private E_Type type;
	private LocalDate Fecha;
	private double monto;
	

}
