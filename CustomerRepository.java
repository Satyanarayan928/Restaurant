/**
 * 
 */
package com.resturant.project;


import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import com.resturant.project.Customer;

import org.springframework.stereotype.Repository;

/**
 * 
 */
@Repository
public class CustomerRepository {
	
	private List<Customer> list = new ArrayList<Customer>();
	
	public void createCustomer() {
		
		   list.add(new Customer(1,"satya", "Gachibowli", "9877745612"));
		   list.add(new Customer(2,"hari", "HitechCity", "9877756743"));
		   list.add(new Customer(3,"dama", "Secuderbad", "9877787634"));
		   list.add(new Customer(4,"naba", "Gopanapally", "9877798712"));
		   list.add(new Customer(5,"sanju", "Kondapur", "9877789734"));
		   list.add(new Customer(6,"jaga", "Madhapur", "9877745612"));
	}
	
	public List<Customer> getAllCustomers() {
        return list;
    }
	
    public Customer findByCustId(int id){
    	
    	try {
		
		for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getCustId() == (id)) {
                return list.get(i);
            }
        }
		return null;
    	}catch(Exception e) {
    		throw new com.resturant.project.CustomerNameNotFoundException(e.getMessage());
    	}
	}
    
    public List<Customer> searchCustomer(String name) {
    	try {
        return list.stream().filter(x -> x.getName().startsWith(name)).collect(Collectors.toList());
    	}catch(Exception e) {
    		throw new com.resturant.project.CustomerNameNotFoundException(e.getMessage());
    	}
    }

    public Customer saveCustomer(Customer c) {
    	Customer customer = new Customer();
    	
    	customer.setCustId(c.getCustId());
    	customer.setName(c.getName());
    	customer.setAddress(c.getAddress());
    	customer.setPhone(c.getPhone());
		 
        list.add(customer);
        return customer;
    }
    
    public String deleteCustomer(Integer id) {
        list.removeIf(x -> x.getCustId() == (id));
        return null;
    }
    
    public Customer updateCustomer(Customer cust) {
        int idx = 0;
        int id = 0;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getCustId() == (cust.getCustId())) {
                id = cust.getCustId();
                idx = i;
                break;
            }
        }

        Customer customer = new Customer();
        
        customer.setCustId(id);
        customer.setName(cust.getName());
        customer.setAddress(cust.getAddress());
        customer.setPhone(cust.getPhone());
         
        list.set(idx, customer);
        return customer;
    }





	


}
