package pe.com.nttdata.product.credit.repository.impl;

import org.springframework.stereotype.Repository;

import pe.com.nttdata.product.client.entity.Client;
import pe.com.nttdata.product.credit.entity.Credit;
import pe.com.nttdata.product.credit.entity.CreditCard;
import pe.com.nttdata.product.credit.entity.CreditCardConsumption;
import pe.com.nttdata.product.credit.entity.CreditPayment;
import pe.com.nttdata.product.credit.repository.ICreditRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class CreditRepository implements ICreditRepository {
	
	private static final List<Credit> listCredits = new ArrayList<>();
	private static int lastIdCredit = 0;

	@Override
	public void create(Credit credit) {
		credit.setId(getLastIdCredit());
		credit.setListPayments(new ArrayList<CreditPayment>());
		if(credit.getType() == Credit.EType.CARD) {
			((CreditCard)credit).setListConsumptions(new ArrayList<CreditCardConsumption>());
		}
		listCredits.add(credit);
	}

	@Override
	public void update(Credit credit) {
		int position = listCredits.indexOf(credit);
		listCredits.set(position, credit);	
	}

	@Override
	public void delete(Integer id) {
		Credit credit = findById(id);
		listCredits.remove(credit);
	}

	@Override
	public List<Credit> findAll() {
		List<Credit> listCredits = new ArrayList<>();
		Credit credit= new Credit();
		credit.setId(1);
		credit.setCreditAmount(2000.00);
		credit.setType(Credit.EType.PERSONAL);
		credit.setClient(new Client(1,"daniel valenzuela",null,null, Client.EType.PERSONAL));
		listCredits.add(credit);

		return listCredits;
	}

	@Override
	public Credit findById(Integer id) {
		return listCredits.stream()
				.filter(credit -> credit.getId() == id)
				.findAny()
				.orElse(null);
	}
	
	private int getLastIdCredit() {
		return ++lastIdCredit;
	}

	@Override
	public void AddPayment(Integer idCredit, CreditPayment creditPayment) {
		Credit credit = findById(idCredit);
		credit.getListPayments().add(creditPayment);
		
	}

	@Override
	public void AddCreditCardConsumption(Integer idCreditCard, CreditCardConsumption creditCardConsumption) {
		CreditCard credit = (CreditCard)findById(idCreditCard);
		credit.getListConsumptions().add(creditCardConsumption);
		
	}

	@Override
	public List<Credit> findByIdClient(Integer idClient) {
		return findAll().stream()
				.filter(creditT -> creditT.getClient().getId() == idClient)
				.collect(Collectors.toList());
	}
	
	

}
