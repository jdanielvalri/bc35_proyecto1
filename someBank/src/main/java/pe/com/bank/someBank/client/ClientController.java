package pe.com.bank.someBank.client;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pe.com.bank.someBank.client.entity.Client;
import pe.com.bank.someBank.client.service.IClientService;

@RestController
@RequestMapping("clients")
public class ClientController {
	
	@Autowired
	private IClientService clientService;

	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable Integer id) {
		clientService.delete(id);
	};
	
	@GetMapping
	public List<Client> findAll(){
		return clientService.findAll();
	}
	
	@PostMapping
	public void create(@RequestBody Client client) {
		System.out.println("Enterprise" + client);
		clientService.create(client);
	}
	
	@PutMapping
	public void update(@RequestBody Client client) {
		clientService.update(client);
	}

	@GetMapping("/{id}")
	public Client findById(@PathVariable Integer id) {
		return clientService.findById(id);
	}
	
}