package pe.com.nttdata.product.account.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.com.nttdata.product.account.entity.Account;
import pe.com.nttdata.product.account.entity.AccountTransaction;
import pe.com.nttdata.product.account.entity.FixedTermAccount;
import pe.com.nttdata.product.account.repository.IAccountRepository;
import pe.com.nttdata.product.account.service.IAccountService;
import pe.com.nttdata.product.account.service.IIExternalClientService;
import pe.com.nttdata.product.client.entity.Client;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

@Service
public class AccountService implements IAccountService {

	@Autowired
	private IAccountRepository accountRepository;
	
	@Autowired
	private IIExternalClientService externalClientService ;

	@Override
	public void create(Mono<Account> account) throws Exception {
		
		account.block().setClient(externalClientService.findById(account.block().getClient().getId())); // CLIENT - SERVICE
		
		System.out.println(account);
		
		if (validAccountRules(account.block()) == false ) {
			return;
		}
		
		System.out.println("paso 01");
	
		if(validAccountData(account.block()) == false)
			return;
		
		System.out.println("paso 02");
		
		account.block().setAvailableBalance(0);
		
		System.out.println("paso 03");
		
		accountRepository.create(account.block());
	}

	@Override
	public void update(Mono<Account> account) throws Exception {
		
		account.block().setClient(externalClientService.findById(account.block().getClient().getId())); // CLIENT - SERVICE

		Mono<Account> oldAccount = findById(account.block().getId());

		if(validAccountDataRestrict(account.block(), oldAccount.block()))
			return;
		
		if(validAccountData(account.block())== false)
			return;
		
		account.block().setAvailableBalance(oldAccount.block().getAvailableBalance());		//	para evitar que se actualizen el saldo disponible por este medio
		
		account.block().setListTransactions(oldAccount.block().getListTransactions());		//	para evitar que se actualizen las transacciones por este metodo
		account.block().setListHolders(oldAccount.block().getListHolders());				//	para evitar que se actualizen los titulares por este metodo
		account.block().setListSignatories(oldAccount.block().getListSignatories());		//	para evitar que se actualizen los firmantes por este metodo
		
		accountRepository.update(account.block());
		
	}
	
	@Override
	public void delete(Integer id) {
		accountRepository.delete(id);
	}

	@Override
	public Flux<Account> findAll() {
		return Flux.fromIterable(accountRepository.findAll());
	}

	@Override
	public Mono<Account> findById(Integer id) {
		return Mono.just(accountRepository.findById(id));
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
	public void withDraw(Integer idAccount, Mono<AccountTransaction> withDraw) throws Exception {
		Mono<Account> account = findById(idAccount);
		if (validAccountTransactionCounts(account.block(), withDraw.block()) == false || validAccountTransactionData(account.block(), withDraw.block()) == false ) {
			return;
		}
		
		withDraw.block().setType(AccountTransaction.EType.WITHDRAW);
		accountRepository.addTransaction(idAccount, withDraw.block());
		
		updateAvailableBalance(idAccount, (withDraw.block().getAmount() * - 1) );
	}

	@Override
	public void deposit(Integer idAccount, Mono<AccountTransaction> deposit) throws Exception {
		Mono<Account> account = findById(idAccount);
		if (validAccountTransactionCounts(account.block(), deposit.block()) == false || validAccountTransactionData(account.block(), deposit.block()) == false ) {
			return;
		}
		deposit.block().setType(AccountTransaction.EType.DEPOSIT);
		accountRepository.addTransaction(idAccount, deposit.block());
		
		updateAvailableBalance(idAccount, deposit.block().getAmount() );
	}
	
	@Override
	public Flux<Account> findByIdClient(Integer idClient) {

		return Flux.fromIterable(accountRepository.findByIdClient(idClient));
	}
	
	////////////////////////////
	
	private void updateAvailableBalance(Integer idAccount, double amount) throws Exception {
		Mono<Account> account = findById(idAccount);
		account.block().setAvailableBalance(account.block().getAvailableBalance() + amount );
		accountRepository.update(account.block());
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
			Flux<Account> listAccountsOfClient = findByIdClient(account.getClient().getId());

			if (listAccountsOfClient.collectList().block().stream()
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
		if(transaction.getType() == AccountTransaction.EType.WITHDRAW && transaction.getAmount() > account.getAvailableBalance() )
			throw new Exception("Saldo insuficiente");
		return true;
	}



}
