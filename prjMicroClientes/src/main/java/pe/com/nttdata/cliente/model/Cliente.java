package pe.com.nttdata.cliente.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;


@Data
public  class Cliente {

    @Id
    private ObjectId id;
    private String codigo;
}
