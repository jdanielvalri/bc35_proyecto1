package pe.com.bank.someBank.product.account;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pe.com.bank.someBank.product.account.entity.Account;
import pe.com.bank.someBank.product.account.entity.AccountTransaction;
import pe.com.bank.someBank.product.account.entity.FixedTermAccount;
import pe.com.bank.someBank.product.account.service.IAccountService;

@RestController
@RequestMapping("accounts")
public class AccountController {
	
	@Autowired
	private IAccountService accountService;
	
	@PostMapping
	public void create(@RequestBody Account account) throws Exception {
		accountService.create(account);
	}
	
	@PutMapping
	public void update(@RequestBody Account account) throws Exception{
		accountService.update(account);
	}
	
	@PostMapping("/fixedTerm")
	public void create(@RequestBody FixedTermAccount account) throws Exception {
		accountService.create(account);
	}
	
	@PutMapping("/fixedTerm")
	public void update(@RequestBody FixedTermAccount account) throws Exception{
		accountService.update(account);
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable Integer id) {
		accountService.delete(id);
	}
	
	@GetMapping
	public List<Account> findAll(){
		return accountService.findAll();
	}
	
	@GetMapping("/{id}")
	public Account findById(@PathVariable Integer id) {
		return accountService.findById(id);
	}
	
	@PostMapping("/{id}/withDraw")
	public void withDraw(@PathVariable Integer idAccount, @RequestBody AccountTransaction withDraw) throws Exception{
		accountService.withDraw(idAccount, withDraw);
	}
	
	@PostMapping("/{id}/deposit")
	public void deposit(@PathVariable Integer idAccount, @RequestBody AccountTransaction deposit) throws Exception{
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