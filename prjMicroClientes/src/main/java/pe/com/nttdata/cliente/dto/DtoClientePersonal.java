package pe.com.nttdata.cliente.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import pe.com.nttdata.credit.entity.Credit;

import java.util.List;

@Setter
@Getter
@AllArgsConstructor
public class DtoClientePersonal {

    private String codigo;
    private String documento;
    private String nombre;
    private List<Credit> credits;
}
