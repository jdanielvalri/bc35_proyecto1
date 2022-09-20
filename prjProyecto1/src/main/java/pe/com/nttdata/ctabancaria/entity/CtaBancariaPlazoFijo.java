package pe.com.nttdata.ctabancaria.entity;

import java.time.LocalDate;

import lombok.Data;

@Data
public class CtaBancariaPlazoFijo extends CtaBancaria {
	
	private LocalDate diaUnicoMovimiento;

}
