/**
 * 
 */
package com.resturant.project;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 
 */
@Service
public class PaymentService {
	
	@Autowired
	PaymentRepository  paymentRepository;
	
	public List<Payment> getAllProducts() {
        return paymentRepository.getAllProducts();
    }
	
public Payment findByPaymentId(int id){
		return paymentRepository.findByPaymentId(id);
	}
	
	public List<Payment> searchPayment(String name) {
        return  paymentRepository.searchPayment(name);
    }

	public Payment save(Payment p) {
		 
        return paymentRepository.save(p);
    }
	
	public String delete(Integer id) {
         
        return paymentRepository.delete(id);
    }
	
	public Payment update(Payment payment) {
        
        return paymentRepository.update(payment); 
    }

}
