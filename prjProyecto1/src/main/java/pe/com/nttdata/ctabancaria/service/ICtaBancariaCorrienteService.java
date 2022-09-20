package pe.com.nttdata.ctabancaria.service;

import pe.com.nttdata.ctabancaria.entity.CtaBancariaCorriente;

public interface ICtaBancariaCorrienteService extends ICtaBancariaService<CtaBancariaCorriente> {
	
	void anadirTitular( CtaBancariaCorriente ctaBancariaCorriente , String titular );
	void removerTitular( CtaBancariaCorriente ctaBancariaCorriente , String titular );
	void anadirFirmante( CtaBancariaCorriente ctaBancariaCorriente , String firmante );
	void removerFirmante( CtaBancariaCorriente ctaBancariaCorriente , String firmante );

}
