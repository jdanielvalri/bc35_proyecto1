package pe.com.bank.someBank.client.repository.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import pe.com.bank.someBank.client.entity.Client;
import pe.com.bank.someBank.client.repository.IClientRepository;

@Repository
public class ClientRepository implements IClientRepository {

	private static final List<Client> listClients = new ArrayList<>();
	private static int lastIdClient = 0;
	
	/*static {
		listClients = new ArrayList<>();
		PersonalClient client = new PersonalClient();
		client.setId(1);
		client.setName("NingunNombre");
		listClients.add(client);
	}*/
	
	@Override
	public void create(Client client) {
		client.setId(getLastIdClient());
		listClients.add(client);
	}

	@Override
	public void update(Client client) {
		int position = listClients.indexOf(client);
		listClients.set(position, client);	
	}

	@Override
	public void delete(Integer id) {
		Client client = findById(id);
		listClients.remove(client);
	}

	@Override
	public List<Client> findAll() {
		return listClients;
	}

	@Override
	public Client findById(Integer id) {
		return listClients.stream()
				.filter(client -> client.getId() == id)
				.findAny()
				.orElse(null);
	}
	
	private int getLastIdClient() {
		return ++lastIdClient;
	}


}
