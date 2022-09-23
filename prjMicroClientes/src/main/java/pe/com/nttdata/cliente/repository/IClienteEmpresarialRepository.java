package pe.com.nttdata.cliente.repository;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import pe.com.nttdata.cliente.model.ClienteEmpresarial;

@Repository
public interface IClienteEmpresarialRepository extends ReactiveCrudRepository<ClienteEmpresarial, String> {
}
