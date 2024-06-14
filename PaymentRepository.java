/**
 * 
 */
package com.resturant.project;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Repository;

/**
 * 
 */
@Repository
public class PaymentRepository {
	
private List<Payment> list = new ArrayList<Payment>();
Date date=new Date();
	
	public void createResturant() {
		
				list.add(new Payment(1, "Cheque", 10000.00, date.toString()));
				list.add(new Payment(1, "Cash", 20000, date.toString()));
				list.add(new Payment(1, "Paytm", 50000, date.toString()));
				list.add(new Payment(1, "GPay", 70000, date.toString()));
				list.add(new Payment(1, "PhonePay", 45000, date.toString()));
				list.add(new Payment(1, "Card", 80000, date.toString()));
			
	}
	
	public List<Payment> getAllProducts() {
        return list;
    }
	
public Payment findByPaymentId(int id){
		
	try {
		for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getPaymentId() == (id)) {
                return list.get(i);
            }
        }
		return null;
	}catch(Exception e) {
		throw new PaymentIdNotFoundException(e.getMessage());
	}

	}
	
	public List<Payment> searchPayment(String name) {
		try {
        return list.stream().filter(x -> x.getPaymentMode().startsWith(name)).collect(Collectors.toList());
		}catch(Exception e) {
			throw new PaymentIdNotFoundException(e.getMessage());
		}
    }

	public Payment save(Payment p) {
		Payment payment = new Payment();
		
		payment.setPaymentId(p.getPaymentId());
		payment.setPaymentMode(p.getPaymentMode());
		payment.setAmount(p.getAmount());
		payment.setDate(p.getDate());
         
        list.add(payment);
        return payment;
    }
	
	public String delete(Integer id) {
        list.removeIf(x -> x.getPaymentId() == (id));
        return null;
    }
	
	public Payment update(Payment payment) {
        int idx = 0;
        int id = 0;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getPaymentId() == (payment.getPaymentId())) {
                id = payment.getPaymentId();
                idx = i;
                break;
            }
        }

        Payment paymentUpdate = new Payment();
        
        paymentUpdate.setPaymentId(id);
        paymentUpdate.setPaymentMode(payment.getPaymentMode());
        paymentUpdate.setAmount(payment.getAmount());
        paymentUpdate.setDate(payment.getDate());
         
        list.set(idx, paymentUpdate);
        return paymentUpdate;
    }





}
