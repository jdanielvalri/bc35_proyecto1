package pe.com.nttdata.product.account.service;


import pe.com.nttdata.product.account.entity.Account;
import pe.com.nttdata.product.account.entity.AccountTransaction;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

public interface IAccountService {

	void create(Mono<Account> account) throws Exception ;
	
	void update(Mono<Account> account) throws Exception;
	
	void delete(Integer id);
	
	Flux<Account> findAll();
	
	Flux<Account> findByIdClient(Integer idClient);

	Mono<Account> findById(Integer id);
	
	void withDraw(Integer idAccount, Mono<AccountTransaction> withDraw) throws Exception;
	
	void deposit(Integer idAccount, Mono<AccountTransaction> deposit) throws Exception;
	
	void addHolder(Integer idAccount, String holder);
	
	void addSignatory(Integer idAccount, String signatory);
	
}
