package pe.com.nttdata.product.credit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.com.nttdata.product.credit.entity.Credit;
import pe.com.nttdata.product.credit.entity.CreditCardConsumption;
import pe.com.nttdata.product.credit.entity.CreditPayment;
import pe.com.nttdata.product.credit.service.ICreditService;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

@RestController
@RequestMapping("/credits")
public class CreditController {
	
	@Autowired
	private ICreditService creditService;

	@PostMapping
	public void create(@RequestBody Credit credit) throws Exception{
		creditService.create(Mono.just(credit));
	}
	
	@PutMapping
	public void update(@RequestBody Credit credit) throws Exception{
		creditService.update(Mono.just(credit));
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable Integer id) throws Exception{
		creditService.delete(id);
	}
	
	@GetMapping
	public List<Credit> findAll(){
		return creditService.findAll().collectList().block();
	}
	
	@GetMapping("/{id}")
	public Credit findById(Integer id) {
		return creditService.findById(id).block();
	};
	
	
	@PostMapping("{id}/payment")
	public void AddPayment( @PathVariable Integer idCredit, @RequestBody CreditPayment creditPayment) throws Exception{
		creditService.AddPayment(idCredit, Mono.just(creditPayment));
	}
	
	@PostMapping("{id}/creditCard/consumption")
	public void AddCreditCardConsumption( @PathVariable Integer idCreditCard, CreditCardConsumption creditCardConsumption) throws Exception{
		creditService.AddCreditCardConsumption(idCreditCard, Mono.just(creditCardConsumption));
	}

	@GetMapping("/findByIdClient/{id}")
	public Flux<Credit> findByIdClient(@PathVariable Integer id) {
		return creditService.findByIdClient(id);
	};

}
