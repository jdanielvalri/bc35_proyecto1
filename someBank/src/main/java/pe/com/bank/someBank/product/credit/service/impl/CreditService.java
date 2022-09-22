package pe.com.bank.someBank.product.credit.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.com.bank.someBank.client.entity.Client;
import pe.com.bank.someBank.product.credit.service.IExternalClientService;
import pe.com.bank.someBank.product.credit.entity.Credit;
import pe.com.bank.someBank.product.credit.entity.CreditCard;
import pe.com.bank.someBank.product.credit.entity.CreditCardConsumption;
import pe.com.bank.someBank.product.credit.entity.CreditPayment;
import pe.com.bank.someBank.product.credit.repository.ICreditRepository;
import pe.com.bank.someBank.product.credit.service.ICreditService;

@Service
public class CreditService implements ICreditService {
	
	@Autowired
	private ICreditRepository creditRepository;

	@Autowired
	private static IExternalClientService externalClientService ;
	
	@Override
	public void create(Credit credit)  throws Exception {
		
		credit.setClient(externalClientService.findById(credit.getClient().getId()));
		
		if(validRulesCredit(credit)== false)
			return;
		
		if(validCreditData(credit)== false)
			return;
		
		if(credit.getType() == CreditCard.EType.CARD)
			((CreditCard)credit).setCreditAmountConsumed(0);
		
		creditRepository.create(credit);
		
	}
	

	@Override
	public void update(Credit credit)  throws Exception {
		
		credit.setClient(externalClientService.findById(credit.getClient().getId()));
		
		Credit oldCredit = findById(credit.getId());
		
		if(validCreditDataRestrict(credit, oldCredit)== false)
			return;
		
		if(validCreditData(credit)== false)
			return;
		
		/*	Para evitar que se guarden estos campos por este medio	*/
	
		credit.setListPayments(oldCredit.getListPayments());
		
		if(credit.getType() == Credit.EType.CARD) {
			CreditCard creditCard = ((CreditCard)credit);
			creditCard.setListConsumptions((((CreditCard)oldCredit).getListConsumptions()));
			
			creditCard.setCreditAmountConsumed(((CreditCard)oldCredit).getCreditAmountConsumed()); // Se actualiza en otro metodo
		}		
		
		creditRepository.update(credit);
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
	public List<Credit> findAll() {
		return creditRepository.findAll();
	}

	@Override
	public Credit findById(Integer id) {
		return creditRepository.findById(id);
	}

	@Override
	public List<Credit> findByIdClient(Integer idClient) {
		return creditRepository.findByIdClient(idClient);
	}

	@Override
	public void AddPayment(Integer idCredit, CreditPayment creditPayment) throws Exception {
		Credit credit = findById(idCredit);
		
		if(validCreditPayment(credit, creditPayment) == false)
			return;
		
		creditRepository.AddPayment(idCredit, creditPayment);
	}
	
	private boolean validCreditPayment(Credit credit, CreditPayment creditPayment) throws Exception {
		if(creditPayment.getAmount() <= 0)
			throw new Exception("Monto invalido");
		return true;
	}
	

	@Override
	public void AddCreditCardConsumption(Integer idCreditCard, CreditCardConsumption creditCardConsumption) throws Exception {
		CreditCard creditCard = (CreditCard)findById(idCreditCard);
		
		if(validCreditCardConsumption(creditCard, creditCardConsumption) == false)
			return;
		
		creditRepository.AddCreditCardConsumption(idCreditCard, creditCardConsumption);
		
		updateCreditCardConsumedAmount(idCreditCard, creditCardConsumption.getAmount());
		
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
		
		List<Credit> listCreditsOfClient = findByIdClient(credit.getClient().getId());
		
		if(credit.getClient().getType() == Client.EType.PERSONAL ) {
			if(credit.getType() == Credit.EType.ENTERPRISE)
				throw new Exception("Solo puede ser Credito Personal O Tarjeta de credito");
			if(listCreditsOfClient.stream().filter(creditT -> creditT.getType() == Credit.EType.PERSONAL  ).count() > 0  ) {
				throw new Exception("El ciente solo puede tener un credito Personal");
			}
		}
		
		if(credit.getClient().getType() == Client.EType.ENTERPRISE ) {
			if(credit.getType() == Credit.EType.PERSONAL)
				throw new Exception("Solo puede ser Credito Empresarial O Tarjeta de credito");
		}
		
		if(credit.getType() == Credit.EType.CARD) {
			if(listCreditsOfClient.stream().filter(creditT -> creditT.getType() == Credit.EType.CARD  ).count() > 0  ) {
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
