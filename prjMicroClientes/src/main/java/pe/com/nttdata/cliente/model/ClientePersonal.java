package pe.com.nttdata.cliente.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;
import org.w3c.dom.stylesheets.LinkStyle;
import pe.com.nttdata.credit.entity.Credit;

import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@Document(collection = "clientepersonal")
public class ClientePersonal extends Cliente {

	private String documento;
	private String nombre;

}
