package pe.com.bank.someBank.product.credit.service;

import java.util.List;

import pe.com.bank.someBank.product.credit.entity.Credit;
import pe.com.bank.someBank.product.credit.entity.CreditCardConsumption;
import pe.com.bank.someBank.product.credit.entity.CreditPayment;

public interface ICreditService {

	void create(Credit credit) throws Exception;
	
	void update(Credit credit) throws Exception;
	
	void delete(Integer id) throws Exception;
	
	List<Credit> findAll();
	
	Credit findById(Integer id);
	
	List<Credit> findByIdClient(Integer idClient);
	
	void AddPayment(Integer idCredit, CreditPayment creditPayment) throws Exception;
	
	void AddCreditCardConsumption(Integer idCreditCard, CreditCardConsumption creditCardConsumption) throws Exception;
	
}
