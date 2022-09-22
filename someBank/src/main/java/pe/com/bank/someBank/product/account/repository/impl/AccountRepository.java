package pe.com.bank.someBank.product.account.repository.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Repository;

import pe.com.bank.someBank.client.entity.Client;
import pe.com.bank.someBank.product.account.entity.Account;
import pe.com.bank.someBank.product.account.entity.AccountTransaction;
import pe.com.bank.someBank.product.account.repository.IAccountRepository;

@Repository
public class AccountRepository implements IAccountRepository {

	private static final List<Account> listAccounts = new ArrayList<>();
	private static int lastIdAccount = 0;
	
	/*static {
	listAccounts = new ArrayList<>();
	Account account = new Account();
	Client client = new Client(); 
	client.setId(1);
	client.setName("NingunNombre");
	account.setClient(client);
	
	account.setListHolders(new ArrayList<>());
	account.getListHolders().add("Titular 1");
	
	listAccounts.add(account);
}*/

	
	@Override
	public void create(Account account) {
		account.setId(getLastIdClient());
		account.setListTransactions(new ArrayList<>());
		if(account.getListSignatories() == null ) account.setListSignatories(new ArrayList<>());
		listAccounts.add(account);
	}

	@Override
	public void update(Account account) {
		int position = listAccounts.indexOf(account);
		listAccounts.set(position, account);
	}

	@Override
	public void delete(Integer id) {
		Account account = findById(id);
		listAccounts.remove(account);
	}

	@Override
	public List<Account> findAll() {
		return listAccounts;
	}

	@Override
	public Account findById(Integer id) {
		return listAccounts.stream()
				.filter(account -> account.getId() == id)
				.findAny()
				.orElse(null);
	}

	@Override
	public void addTransaction(Integer idAccount, AccountTransaction transaction) {
		Account account = findById(idAccount);
		account.getListTransactions().add(transaction);
	}

	@Override
	public void addHolder(Integer idAccount, String holder) {
		Account account = findById(idAccount);
		account.getListHolders().add(holder);
	}

	@Override
	public void addSignatory(Integer idAccount, String signatory) {
		Account account = findById(idAccount);
		account.getListHolders().add(signatory);
	}
	
	private int getLastIdClient() {
		return ++lastIdAccount;
	}

	@Override
	public List<Account> findByIdClient(Integer idClient) {
		return findAll().stream()
				.filter(accountT -> accountT.getClient().getId() == idClient)
				.collect(Collectors.toList());
	}

}