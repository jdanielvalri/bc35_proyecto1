package pe.com.bank.someBank.product.account.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import pe.com.bank.someBank.client.entity.Client;
import pe.com.bank.someBank.product.account.service.IIExternalClientService;

@Component
public class EExternalClientService implements IIExternalClientService {

	@Autowired
	private WebClient.Builder webClientBuilder;
		
	private static final String uriBase = "http://localhost:8080/clients";
	
	@Override
	public Client findById(Integer id) {
		
		String uri = uriBase+"/"+id;
		
		return (new RestTemplate()).getForObject(uri, Client.class);
		/*
		return webClientBuilder.build()
		.get()
		.uri(uri)
		.retrieve()
		.bodyToMono(Client.class).block();
		*/
		
	}

}
