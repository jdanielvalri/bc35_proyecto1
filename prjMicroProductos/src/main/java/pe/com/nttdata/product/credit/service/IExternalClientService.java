package pe.com.nttdata.product.credit.service;

import pe.com.nttdata.product.client.entity.Client;
import reactor.core.publisher.Mono;

public interface IExternalClientService {
	
	Mono<Client> findById(Integer id);

}
