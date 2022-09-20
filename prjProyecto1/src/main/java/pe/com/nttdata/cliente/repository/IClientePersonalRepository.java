package pe.com.nttdata.cliente.repository;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import pe.com.nttdata.cliente.entity.Cliente;
import pe.com.nttdata.cliente.entity.ClientePersonal;

@Repository
public interface IClientePersonalRepository extends ReactiveCrudRepository<ClientePersonal, String> {
}
