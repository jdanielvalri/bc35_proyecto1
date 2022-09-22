package pe.com.bank.someBank.product.credit.repository;

import java.util.List;

import pe.com.bank.someBank.product.credit.entity.Credit;
import pe.com.bank.someBank.product.credit.entity.CreditCardConsumption;
import pe.com.bank.someBank.product.credit.entity.CreditPayment;

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
