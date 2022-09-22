package pe.com.bank.someBank.product.account.repository;

import java.util.List;

import pe.com.bank.someBank.product.account.entity.Account;
import pe.com.bank.someBank.product.account.entity.AccountTransaction;

public interface IAccountRepository {
	
	void create(Account account);
	
	void update(Account account);
	
	void delete(Integer id);
	
	List<Account> findAll();
	
	Account findById(Integer id);
	
	List<Account> findByIdClient(Integer idClient);
	
	void addTransaction(Integer idAccount, AccountTransaction transaction);
	
	void addHolder(Integer idAccount, String holder);
	
	void addSignatory(Integer idAccount, String signatory);

}