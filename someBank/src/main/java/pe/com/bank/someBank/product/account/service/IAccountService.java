package pe.com.bank.someBank.product.account.service;

import java.util.List;

import pe.com.bank.someBank.product.account.entity.Account;
import pe.com.bank.someBank.product.account.entity.AccountTransaction;

public interface IAccountService {

	void create(Account account) throws Exception ;
	
	void update(Account account) throws Exception;
	
	void delete(Integer id);
	
	List<Account> findAll();
	
	List<Account> findByIdClient(Integer idClient);
	
	Account findById(Integer id);
	
	void withDraw(Integer idAccount, AccountTransaction withDraw) throws Exception;
	
	void deposit(Integer idAccount, AccountTransaction deposit) throws Exception;
	
	void addHolder(Integer idAccount, String holder);
	
	void addSignatory(Integer idAccount, String signatory);
	
}
