package pe.com.nttdata.product.credit.repository;

import pe.com.nttdata.product.credit.entity.Credit;
import pe.com.nttdata.product.credit.entity.CreditCardConsumption;
import pe.com.nttdata.product.credit.entity.CreditPayment;

import java.util.List;

public interface ICreditRepository {
	
	void create(Credit credit);
	
	void update(Credit credit);
	
	void delete(Integer id);
	
	List<Credit> findAll();
	
	Credit findById(Integer id);

	List<Credit> findByIdClient(Integer idClient);
	
	void AddPayment(Integer idCredit, CreditPayment creditPayment);
	
	void AddCreditCardConsumption(Integer idCreditCard, CreditCardConsumption creditCardConsumption);

}
