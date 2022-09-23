package pe.com.nttdata.cliente.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Setter
@Getter
@AllArgsConstructor
@Document(collection = "clientepersonal")
public class ClientePersonal extends Cliente {

	private String documento;
	private String nombre;
}
