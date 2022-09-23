package pe.com.nttdata.product.credit.service;

import pe.com.nttdata.product.client.entity.Client;

public interface IExternalClientService {
	
	Client findById(Integer id);

}
