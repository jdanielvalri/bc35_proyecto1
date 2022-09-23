package pe.com.nttdata.cliente.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;
import pe.com.nttdata.credito.entity.CreditoPersonal;
import pe.com.nttdata.ctabancaria.entity.CtaBancaria;
import reactor.core.publisher.Mono;

@Setter
@Getter
@AllArgsConstructor
@Document(collection = "clientepersonal")
public class ClientePersonal extends Cliente {

	@Id
	private ObjectId id;

	//private CtaBancaria ctaBancaria;

	//private CreditoPersonal creditoPersonal;
	
	//public ClientePersonal() {
	//	super.setType(ETipoCliente.PERSONAL);
	//}
	
}
