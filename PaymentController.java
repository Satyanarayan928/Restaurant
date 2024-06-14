/**
 * 
 */
package com.resturant.project;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

/**
 * 
 */
@Controller
public class PaymentController {

	@Autowired
	PaymentService paymentService;
	
	@GetMapping
	public List<Payment> getAllProducts() {
        return paymentService.getAllProducts();
    }
	
    @GetMapping("{id}")
	public Payment findByPaymentId(@Pathvariable("id") int id){
		return paymentService.findByPaymentId(id);
	}
	
    @GetMapping("{name}")
	public List<Payment> searchPayment(@Pathvariable("name") String name) {
        return  paymentService.searchPayment(name);
    }

    @PostMapping
	public Payment save(Payment p) {
		 
        return paymentService.save(p);
    }
	
    @DeleteMapping("{id}")
	public String delete(@Pathvariable("id") Integer id) {
         
        return paymentService.delete(id);
    }
	
    @PutMapping
	public Payment update(Payment payment) {
        
        return paymentService.update(payment); 
    }
	
	
}
