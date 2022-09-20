package pe.com.nttdata.cliente.entity;

import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;
import pe.com.nttdata.credito.entity.CreditoEmpresarial;
import pe.com.nttdata.ctabancaria.entity.CtaBancariaCorriente;

import java.util.List;

@Data
@Document(collection = "clienteempresa")
public class ClienteEmpresarial extends Cliente {

	@Id
	private ObjectId id;

	private List<CtaBancariaCorriente> ctaCorriente;

	private List<CreditoEmpresarial> creditoEmpresarial;
	
	public ClienteEmpresarial() {
	   super.setType(ETipoCliente.EMPRESARIAL);
	}
	
}
