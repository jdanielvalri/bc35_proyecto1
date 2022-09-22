package pe.com.bank.someBank.product.credit.repository.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Repository;

import pe.com.bank.someBank.product.credit.entity.Credit;
import pe.com.bank.someBank.product.credit.entity.CreditCard;
import pe.com.bank.someBank.product.credit.entity.CreditCardConsumption;
import pe.com.bank.someBank.product.credit.entity.CreditPayment;
import pe.com.bank.someBank.product.credit.entity.Credit.EType;
import pe.com.bank.someBank.product.credit.repository.ICreditRepository;

@Repository
public class CreditRepository implements ICreditRepository {
	
	private static final List<Credit> listCredits = new ArrayList<>();
	private static int lastIdCredit = 0;

	@Override
	public void create(Credit credit) {
		credit.setId(getLastIdCredit());
		credit.setListPayments(new ArrayList<CreditPayment>());
		if(credit.getType() == EType.CARD) {
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
