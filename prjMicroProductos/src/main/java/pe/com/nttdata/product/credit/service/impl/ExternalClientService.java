package pe.com.nttdata.product.credit.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;
import pe.com.nttdata.product.client.entity.Client;
import pe.com.nttdata.product.credit.service.IExternalClientService;
import reactor.core.publisher.Mono;

@Component
public class ExternalClientService implements IExternalClientService {

	@Autowired
	private WebClient.Builder webClientBuilder;
		
	private static final String uriBase = "http://localhost:8080/clients";
	
	@Override
	public Mono<Client> findById(Integer id) {
		
		String uri = uriBase+"/"+id;
		
		return Mono.just (new RestTemplate().getForObject(uri, Client.class));
		/*
		return webClientBuilder.build()
		.get()
		.uri(uri)
		.retrieve()
		.bodyToMono(Client.class).block();
		*/
		
	}

}
