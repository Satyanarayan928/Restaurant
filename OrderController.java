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
public class OrderController {
	
	@Autowired
	private OrderService orderService;
	
	@GetMapping
	public List<Order> getAllOrders() {
        return orderService.getAllOrders();
    }
	
	
	@GetMapping("{id}")
    public Order findByOrderId(@Pathvariable("Id") int id){
		 return orderService.findByOrderId(id);
	}
    
	@GetMapping("{name}")
    public List<Order> searchOrderType(@Pathvariable("name") String name) {
        return  orderService.searchOrderType(name);
    }
    
	@PostMapping
    public Order saveOrder(Order o) { 
        return orderService.saveOrder(o);
    }

    @DeleteMapping("{id}")
    public String deleteOrder(@Pathvariable("id") Integer id) {
    	return orderService.deleteOrder(id);
         
    }
    
    @PutMapping
    public Order updateOrder(Order o) {
        return orderService.updateOrder(o);
    }

}
