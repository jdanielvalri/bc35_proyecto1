package pe.com.nttdata.cliente.entity;

import lombok.Data;
import pe.com.nttdata.credito.entity.CreditoEmpresarial;
import pe.com.nttdata.ctabancaria.entity.CtaBancariaCorriente;

import java.util.List;

@Data
public class ClienteEmpresarial extends Cliente {

	private List<CtaBancariaCorriente> ctaCorriente;
	private List<CreditoEmpresarial> creditoEmpresarial;
	
	public ClienteEmpresarial() {
		super.setType(ETipoCliente.EMPRESARIAL);
	}
	
}
