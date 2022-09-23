package pe.com.nttdata.product.credit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.com.nttdata.product.credit.entity.Credit;
import pe.com.nttdata.product.credit.entity.CreditCardConsumption;
import pe.com.nttdata.product.credit.entity.CreditPayment;
import pe.com.nttdata.product.credit.service.ICreditService;

import java.util.List;

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
