package pe.com.nttdata.product.credit.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.com.nttdata.product.client.entity.Client;
import pe.com.nttdata.product.credit.entity.Credit;
import pe.com.nttdata.product.credit.entity.CreditCard;
import pe.com.nttdata.product.credit.entity.CreditCardConsumption;
import pe.com.nttdata.product.credit.entity.CreditPayment;
import pe.com.nttdata.product.credit.repository.ICreditRepository;
import pe.com.nttdata.product.credit.service.ICreditService;
import pe.com.nttdata.product.credit.service.IExternalClientService;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

@Service
public class CreditService implements ICreditService {
	
	@Autowired
	private ICreditRepository creditRepository;

	@Autowired
	private static IExternalClientService externalClientService ;
	
	@Override
	public void create(Mono<Credit> credit)  throws Exception {
		
		credit.block().setClient(externalClientService.findById(credit.block().getClient().getId()).block());
		
		if(validRulesCredit(credit.block())== false)
			return;
		
		if(validCreditData(credit.block())== false)
			return;
		
		if(credit.block().getType() == CreditCard.EType.CARD){
			((CreditCard)credit.block()).setCreditAmountConsumed(0);
		}

		creditRepository.create(credit.block());
		
	}
	

	@Override
	public void update(Mono<Credit> credit)  throws Exception {
		
		credit.block().setClient(externalClientService.findById(credit.block().getClient().getId()).block());
		
		Mono<Credit> oldCredit = findById(credit.block().getId());
		
		if(validCreditDataRestrict(credit.block(), oldCredit.block())== false)
			return;
		
		if(validCreditData(credit.block())== false)
			return;
		
		/*	Para evitar que se guarden estos campos por este medio	*/
	
		credit.block().setListPayments(oldCredit.block().getListPayments());
		
		if(credit.block().getType() == Credit.EType.CARD) {
			CreditCard creditCard = ((CreditCard)credit.block());
			creditCard.setListConsumptions((((CreditCard)oldCredit.block()).getListConsumptions()));
			
			creditCard.setCreditAmountConsumed(((CreditCard)oldCredit.block()).getCreditAmountConsumed()); // Se actualiza en otro metodo
		}		
		
		creditRepository.update(credit.block());
	}
	
	private void updateCreditCardConsumedAmount(Integer idCreditCard, double amountConsumed) {
		CreditCard creditCard = (CreditCard)creditRepository.findById(idCreditCard);
		creditCard.setCreditAmountConsumed(creditCard.getCreditAmountConsumed() - amountConsumed  );
		creditRepository.update(creditCard);
	}


	@Override
	public void delete(Integer id)  throws Exception {
		creditRepository.delete(id);
	}

	@Override
	public Flux<Credit> findAll() {
		return Flux.fromIterable(creditRepository.findAll());
	}

	@Override
	public Mono<Credit> findById(Integer id) {
		return Mono.just(creditRepository.findById(id));
	}

	@Override
	public Flux<Credit> findByIdClient(Integer idClient) {
		return Flux.fromIterable(creditRepository.findByIdClient(idClient));
	}

	@Override
	public void AddPayment(Integer idCredit, Mono<CreditPayment> creditPayment) throws Exception {
		Mono<Credit> credit = findById(idCredit);
		
		if(validCreditPayment(credit.block(), creditPayment.block()) == false) {
			return;
		}
		
		creditRepository.AddPayment(idCredit, creditPayment.block());
	}
	
	private boolean validCreditPayment(Credit credit, CreditPayment creditPayment) throws Exception {
		if(creditPayment.getAmount() <= 0)
			throw new Exception("Monto invalido");
		return true;
	}
	

	@Override
	public void AddCreditCardConsumption(Integer idCreditCard, Mono<CreditCardConsumption> creditCardConsumption) throws Exception {
		CreditCard creditCard = (CreditCard)findById(idCreditCard).block();
		
		if(validCreditCardConsumption(creditCard, creditCardConsumption.block()) == false)
			return;
		
		creditRepository.AddCreditCardConsumption(idCreditCard, creditCardConsumption.block());
		
		updateCreditCardConsumedAmount(idCreditCard, creditCardConsumption.block().getAmount());
		
	}
	
	private boolean validCreditCardConsumption(CreditCard creditCard, CreditCardConsumption creditCardConsumption) throws Exception {
		if(creditCardConsumption.getAmount() <= 0)
			throw new Exception("Monto invalido");
		if(creditCardConsumption.getAmount() > (creditCard.getCreditAmount() - creditCard.getCreditAmountConsumed()) )
			throw new Exception("Saldo insuficiente");
		return true;
	}
	
	/////////////////////////////////////////////////////
	
	private boolean validRulesCredit(Credit credit) throws Exception {
		
		Flux<Credit> listCreditsOfClient = findByIdClient(credit.getClient().getId());
		
		if(credit.getClient().getType() == Client.EType.PERSONAL ) {
			if(credit.getType() == Credit.EType.ENTERPRISE)
				throw new Exception("Solo puede ser Credito Personal O Tarjeta de credito");
			if(listCreditsOfClient.collectList().block().stream().filter(creditT -> creditT.getType() == Credit.EType.PERSONAL  ).count() > 0  ) {
				throw new Exception("El ciente solo puede tener un credito Personal");
			}
		}
		
		if(credit.getClient().getType() == Client.EType.ENTERPRISE ) {
			if(credit.getType() == Credit.EType.PERSONAL)
				throw new Exception("Solo puede ser Credito Empresarial O Tarjeta de credito");
		}
		
		if(credit.getType() == Credit.EType.CARD) {
			if(listCreditsOfClient.collectList().block().stream().filter(creditT -> creditT.getType() == Credit.EType.CARD  ).count() > 0  ) {
				throw new Exception("El ciente ya posee una tarjeta de credito");
			}
		}
		return true;
	}

	private boolean validCreditData(Credit credit) throws Exception {
		
		if(credit.getCreditAmount() <= 0)
			throw new Exception("El monto del credito debe ser mayor a 0");
		
		
		return true;
	}
	
	private boolean validCreditDataRestrict(Credit credit, Credit oldCredit) throws Exception{
		
		if( oldCredit.getType() != credit.getType() || 
				oldCredit.getClient().equals(credit.getClient()) == false ) {
			throw new Exception("Esta informacion no se puede cambiar");
		}
		return true;
		
	}

}
