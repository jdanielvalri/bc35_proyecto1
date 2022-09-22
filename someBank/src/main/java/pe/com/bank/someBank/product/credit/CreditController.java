package pe.com.bank.someBank.product.credit;

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

import pe.com.bank.someBank.product.credit.entity.Credit;
import pe.com.bank.someBank.product.credit.entity.CreditCardConsumption;
import pe.com.bank.someBank.product.credit.entity.CreditPayment;
import pe.com.bank.someBank.product.credit.service.ICreditService;

@RestController
@RequestMapping("/credits")
public class CreditController {
	
	@Autowired
	private ICreditService creditService;

	@PostMapping
	public void create(@RequestBody Credit credit) throws Exception{
		creditService.create(credit);
	}
	
	@PutMapping
	public void update(@RequestBody Credit credit) throws Exception{
		creditService.update(credit);
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable Integer id) throws Exception{
		creditService.delete(id);
	}
	
	@GetMapping
	public List<Credit> findAll(){
		return creditService.findAll();
	}
	
	@GetMapping("/{id}")
	public Credit findById(Integer id) {
		return creditService.findById(id);
	};
	
	
	@PostMapping("{id}/payment")
	public void AddPayment( @PathVariable Integer idCredit, @RequestBody CreditPayment creditPayment) throws Exception{
		creditService.AddPayment(idCredit, creditPayment);
	}
	
	@PostMapping("{id}/creditCard/consumption")
	public void AddCreditCardConsumption( @PathVariable Integer idCreditCard, CreditCardConsumption creditCardConsumption) throws Exception{
		creditService.AddCreditCardConsumption(idCreditCard, creditCardConsumption);
	}
	
}
