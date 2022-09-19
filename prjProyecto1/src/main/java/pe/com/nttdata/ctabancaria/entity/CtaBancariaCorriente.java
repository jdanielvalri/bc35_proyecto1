package pe.com.nttdata.ctabancaria.entity;

import lombok.Data;

import java.util.List;

@Data
public class CtaBancariaCorriente extends CtaBancaria {

	private List<String> titulares;
	private List<String> firmantes;
	
}
