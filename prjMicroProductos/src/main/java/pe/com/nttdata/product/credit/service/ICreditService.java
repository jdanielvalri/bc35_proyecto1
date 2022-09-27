package pe.com.nttdata.product.credit.service;

import pe.com.nttdata.product.credit.entity.Credit;
import pe.com.nttdata.product.credit.entity.CreditCardConsumption;
import pe.com.nttdata.product.credit.entity.CreditPayment;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

public interface ICreditService {

	void create(Mono<Credit> credit) throws Exception;
	
	void update(Mono<Credit> credit) throws Exception;
	
	void delete(Integer id) throws Exception;

	Flux<Credit> findAll();
	
	Mono<Credit> findById(Integer id);
	
	Flux<Credit> findByIdClient(Integer idClient);
	
	void AddPayment(Integer idCredit, Mono<CreditPayment> creditPayment) throws Exception;
	
	void AddCreditCardConsumption(Integer idCreditCard, Mono<CreditCardConsumption> creditCardConsumption) throws Exception;

}
