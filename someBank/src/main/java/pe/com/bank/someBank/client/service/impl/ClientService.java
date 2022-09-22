package pe.com.bank.someBank.client.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.com.bank.someBank.client.entity.Client;
import pe.com.bank.someBank.client.repository.IClientRepository;
import pe.com.bank.someBank.client.service.IClientService;

@Service
public class ClientService implements IClientService {
	
	@Autowired
	private IClientRepository clientRepository;

	@Override
	public void create(Client client) {
		clientRepository.create(client);
	}

	@Override
	public void update(Client client) {
		clientRepository.update(client);
	}

	@Override
	public void delete(Integer id) {
		clientRepository.delete(id);
	}

	@Override
	public List<Client> findAll() {
		return clientRepository.findAll();
	}
	
	@Override
	public Client findById(Integer id) {
		return clientRepository.findById(id);
	}
	

}
