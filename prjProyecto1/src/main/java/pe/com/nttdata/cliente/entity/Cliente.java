package pe.com.nttdata.cliente.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;
import pe.com.nttdata.credito.entity.TarjetaCredito;
import reactor.core.publisher.Mono;

import java.util.List;

@Setter
@Getter
public  class Cliente {

	private String codigo;
	private String documento;
	private String nombre;

	//@Transient
	//private List<TarjetaCredito> tarjetaCredito;
	@Transient
	private ETipoCliente type;

}
