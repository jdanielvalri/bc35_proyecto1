package pe.com.nttdata.product.account;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.com.nttdata.product.account.entity.Account;
import pe.com.nttdata.product.account.entity.AccountTransaction;
import pe.com.nttdata.product.account.entity.FixedTermAccount;
import pe.com.nttdata.product.account.service.IAccountService;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

@RestController
@RequestMapping("accounts")
public class AccountController {
	
	@Autowired
	private IAccountService accountService;
	
	@PostMapping
	public void create(@RequestBody Account account) throws Exception {
		accountService.create(Mono.just(account));
	}
	
	@PutMapping
	public void update(@RequestBody Account account) throws Exception{
		accountService.update(Mono.just(account));
	}
	
	@PostMapping("/fixedTerm")
	public void create(@RequestBody FixedTermAccount account) throws Exception {
		accountService.create(Mono.just(account));
	}
	
	@PutMapping("/fixedTerm")
	public void update(@RequestBody FixedTermAccount account) throws Exception{
		accountService.update(Mono.just(account));
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable Integer id) {
		accountService.delete(id);
	}
	
	@GetMapping
	public Flux<Account> findAll(){
		return accountService.findAll();
	}
	
	@GetMapping("/{id}")
	public Mono<Account> findById(@PathVariable Integer id) {
		return accountService.findById(id);
	}
	
	@PostMapping("/{id}/withDraw")
	public void withDraw(@PathVariable Integer idAccount, @RequestBody Mono<AccountTransaction> withDraw) throws Exception{
		accountService.withDraw(idAccount, withDraw);
	}
	
	@PostMapping("/{id}/deposit")
	public void deposit(@PathVariable Integer idAccount, @RequestBody Mono<AccountTransaction> deposit) throws Exception{
		accountService.deposit(idAccount, deposit);
	}
	
	@PostMapping("/{id}/holder")
	public void addHolder(@PathVariable Integer idAccount, @RequestBody String holder) {
		accountService.addHolder(idAccount, holder);
	}
	
	@PostMapping("/{id}/signatory")
	public void addSignatory(Integer idAccount, String signatory) {
		accountService.addSignatory(idAccount, signatory);
	}

}