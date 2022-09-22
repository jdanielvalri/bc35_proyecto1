package pe.com.bank.someBank.product.account.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.com.bank.someBank.client.entity.Client;
import pe.com.bank.someBank.product.account.entity.Account;
import pe.com.bank.someBank.product.account.entity.AccountTransaction;
import pe.com.bank.someBank.product.account.entity.FixedTermAccount;
import pe.com.bank.someBank.product.account.entity.AccountTransaction.EType;
import pe.com.bank.someBank.product.account.repository.IAccountRepository;
import pe.com.bank.someBank.product.account.service.IAccountService;
import pe.com.bank.someBank.product.account.service.IIExternalClientService;

@Service
public class AccountService implements IAccountService {

	@Autowired
	private IAccountRepository accountRepository;
	
	@Autowired
	private IIExternalClientService externalClientService ;

	@Override
	public void create(Account account) throws Exception {
		
		account.setClient(externalClientService.findById(account.getClient().getId())); // CLIENT - SERVICE
		
		System.out.println(account);
		
		if (validAccountRules(account) == false ) {
			return;
		}
		
		System.out.println("paso 01");
	
		if(validAccountData(account) == false)
			return;
		
		System.out.println("paso 02");
		
		account.setAvailableBalance(0);
		
		System.out.println("paso 03");
		
		accountRepository.create(account);
	}



	@Override
	public void update(Account account) throws Exception {
		
		account.setClient(externalClientService.findById(account.getClient().getId())); // CLIENT - SERVICE
		
		Account oldAccount = findById(account.getId());

		if(validAccountDataRestrict(account, oldAccount))
			return;
		
		if(validAccountData(account)== false)
			return;
		
		account.setAvailableBalance(oldAccount.getAvailableBalance());		//	para evitar que se actualizen el saldo disponible por este medio
		
		account.setListTransactions(oldAccount.getListTransactions());		//	para evitar que se actualizen las transacciones por este metodo
		account.setListHolders(oldAccount.getListHolders());				//	para evitar que se actualizen los titulares por este metodo
		account.setListSignatories(oldAccount.getListSignatories());		//	para evitar que se actualizen los firmantes por este metodo
		
		accountRepository.update(account);
		
	}
	
	@Override
	public void delete(Integer id) {
		accountRepository.delete(id);
	}

	@Override
	public List<Account> findAll() {
		return accountRepository.findAll();
	}

	@Override
	public Account findById(Integer id) {
		return accountRepository.findById(id);
	}

	@Override
	public void addHolder(Integer idAccount, String holder) {
		accountRepository.addHolder(idAccount, holder);
	}

	@Override
	public void addSignatory(Integer idAccount, String signatory) {
		accountRepository.addSignatory(idAccount, signatory);
	}

	@Override
	public void withDraw(Integer idAccount, AccountTransaction withDraw) throws Exception {
		Account account = findById(idAccount);
		if (validAccountTransactionCounts(account, withDraw) == false || validAccountTransactionData(account, withDraw) == false ) {
			return;
		}
		
		withDraw.setType(AccountTransaction.EType.WITHDRAW);
		accountRepository.addTransaction(idAccount, withDraw);
		
		updateAvailableBalance(idAccount, (withDraw.getAmount() * - 1) );
	}

	@Override
	public void deposit(Integer idAccount, AccountTransaction deposit) throws Exception {
		Account account = findById(idAccount);
		if (validAccountTransactionCounts(account, deposit) == false || validAccountTransactionData(account, deposit) == false ) {
			return;
		}
		deposit.setType(AccountTransaction.EType.DEPOSIT);
		accountRepository.addTransaction(idAccount, deposit);
		
		updateAvailableBalance(idAccount, deposit.getAmount() );
	}
	
	@Override
	public List<Account> findByIdClient(Integer idClient) {
		return accountRepository.findByIdClient(idClient);
	}
	
	////////////////////////////
	
	private void updateAvailableBalance(Integer idAccount, double amount) throws Exception {
		Account account = findById(idAccount);
		account.setAvailableBalance(account.getAvailableBalance() + amount );
		accountRepository.update(account);
	}
	
	/////////////////////////
	

	
	private boolean validAccountRules(Account account) throws Exception {
		if (account.getClient().getType() == Client.EType.PERSONAL) {
			if (validAccountTypePersonalClient(account)== false) 
				return false;
		}
		
		if (account.getClient().getType() == Client.EType.ENTERPRISE) {
			if (validAccountTypeEnterpriseClient(account)== false) 
				return false;
		}
		return true;
	}
	
	private boolean validAccountTypePersonalClient(Account account) throws Exception {
		if(account.getType() != Account.EType.FIXEDTERM) {
			List<Account> listAccountsOfClient = findByIdClient(account.getClient().getId()); 

			if (listAccountsOfClient.stream()
					.filter(accountT -> accountT.getType() == account.getType())
					.findAny()
					.orElse(null) != null) {
				throw new Exception("El cliente solo puede tener este tipo de cuenta");
			}
		}
		return true;
	}
	
	private boolean validAccountTypeEnterpriseClient(Account account) throws Exception {
		if(account.getType() != Account.EType.CURRENT) {
			throw new Exception("El cliente no puede tener este tipo de cuenta");
		}
		return true;
	}
	
	private boolean validAccountData(Account account) throws Exception {
		if( 
			( account.getType() == Account.EType.FIXEDTERM  ||  account.getType() == Account.EType.SAVING ) && 
				account.getAccountMaintanceFee() != 0  ) 
			throw new Exception("La cuenta es libre de Mantenimiento");
		
		if(account.getType() == Account.EType.SAVING && account.getMaximumMovementLimit() <=  0)
			throw new Exception("El tipo de cuenta debe de tener un limite maximo de Movimientos");

		if(account.getType() == Account.EType.CURRENT && account.getMaximumMovementLimit() != 0)
			throw new Exception("El limite maximo de movimientos debe ser 0, por que el tipo de cuenta no tiene limite");
		
		if(account.getType() == Account.EType.FIXEDTERM && account.getMaximumMovementLimit() != 1)
			throw new Exception("Solo se permite un maximo de un movimiento mensual");
		
		if(account.getType() == Account.EType.FIXEDTERM){
			if ( ( ((FixedTermAccount)account).getDayTransaction() > 0 && ((FixedTermAccount)account).getDayTransaction() <= 30) == false) {
				throw new Exception("El dia de transaccion es erroneo");
			}
		}

		if( (account.getClient().getType() == Client.EType.ENTERPRISE) && (account.getListHolders() == null || account.getListHolders().size() == 0 ) )
			throw new Exception("El cliente debe tener al menos un titular");
			
		return true;
	}
	
	private boolean validAccountDataRestrict(Account account, Account oldAccount)  throws Exception {
		if( oldAccount.getType() != account.getType() || 
				oldAccount.getClient().equals(account.getClient()) == false ) {
			throw new Exception("Esta informacion no se puede cambiar");
		}
		return true;
	}
	
	///////////////////////////////////////////////////////////
	
	private boolean validAccountTransactionCounts(Account account, AccountTransaction withDraw) throws Exception {
		if(account.getMaximumMovementLimit() != 0) {
			if(account.getListTransactions().stream()
					.filter( transaction -> transaction.getDate().getMonthValue() == withDraw.getDate().getMonthValue() )
					.count() >=  account.getMaximumMovementLimit()) {
				throw new Exception("No se pueden hacer mas movimientos en el mes");
			}
		}
		return true;
	}
	
	private boolean validAccountTransactionData(Account account, AccountTransaction transaction) throws Exception {
		if(transaction.getAmount() <= 0)
			throw new Exception("Monto invalido");
		if(transaction.getType() == EType.WITHDRAW && transaction.getAmount() > account.getAvailableBalance() )
			throw new Exception("Saldo insuficiente");
		return true;
	}



}
