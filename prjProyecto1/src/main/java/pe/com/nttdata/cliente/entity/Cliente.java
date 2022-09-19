package pe.com.nttdata.cliente.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import pe.com.nttdata.credito.entity.TarjetaCredito;
import pe.com.nttdata.enumerador.ETipoCliente;
import reactor.core.publisher.Mono;

import java.util.List;

@Data
public  class Cliente {

	private Integer id;
	private List<TarjetaCredito> tarjetaCredito;
	private ETipoCliente type;

}
