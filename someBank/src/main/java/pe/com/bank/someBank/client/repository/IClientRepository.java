package pe.com.bank.someBank.client.repository;

import java.util.List;

import pe.com.bank.someBank.client.entity.Client;

public interface IClientRepository {

	void create(Client client);
	
	void update(Client client);
	
	void delete(Integer id);
	
	List<Client> findAll();
	
	Client findById(Integer id);
	
}
