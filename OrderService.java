/**
 * 
 */
package com.resturant.project;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 
 */
@Service
public class OrderService {
	
	
	@Autowired
	private OrderRepository orderRepository;
	
	public List<Order> getAllOrders() {
        return orderRepository.getAllOrders();
    }
	
	
    public Order findByOrderId(int id){
		 return orderRepository.findByOrderId(id);
	}
    
    
    public List<Order> searchOrderType(String name) {
        return  orderRepository.searchOrderType(name);
    }
    
    public Order saveOrder(Order o) { 
        return orderRepository.saveOrder(o);
    }


    public String deleteOrder(Integer id) {
    	return orderRepository.deleteOrder(id);
         
    }
    
    
    public Order updateOrder(Order o) {
        return orderRepository.updateOrder(o);
    }


}
