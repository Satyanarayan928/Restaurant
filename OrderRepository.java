/**
 * 
 */
package com.resturant.project;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Repository;

/**
 * 
 */
@Repository
public class OrderRepository {
	
private List<Order> list = new ArrayList<Order>();
private List<Item> itemList = new ArrayList<Item>();
	
	public void createOrder() {
		list.add(new Order(1, itemList, "Indian", 5, 50.23));
		list.add(new Order(1, itemList, "Chinse", 2, 50.23));
		list.add(new Order(1, itemList, "Itlian", 1, 50.23));
		list.add(new Order(1, itemList, "Tandoori", 8, 500.23));
		list.add(new Order(1, itemList, "Indian", 4, 50.23));
		list.add(new Order(1, itemList, "Chinse", 5, 50.23));
	}
	
	public List<Order> getAllOrders() {
        return list;
    }
	
	
    public Order findByOrderId(int id){
    	
    	try {
		
		for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getOrderId() == (id)) {
                return list.get(i);
            }
        }
		return null;
    	}catch(Exception e) {
    		throw new OrderIdNotFoundException(e.getMessage());
    	}

	}
    
    
    public List<Order> searchOrderType(String name) {
    	try {
        return list.stream().filter(x -> x.getOrderType().startsWith(name)).collect(Collectors.toList());
    	}catch(Exception e) {
    		throw new OrderNameNotFoundException(e.getMessage());
    	}
    }
    
    public Order saveOrder(Order o) {
    	Order order = new Order();
    	
    	order.setOrderId(o.getOrderId());
    	order.setOrderType(o.getOrderType());
    	order.setItems(o.getItems()); 
    	order.setPrice(o.getPrice());
    	order.setAmount(o.getAmount());
		 
        list.add(order);
        return order;
    }


    public String deleteOrder(Integer id) {
        list.removeIf(x -> x.getOrderId() == (id));
        return null;
    }
    
    
    public Order updateOrder(Order o) {
        int idx = 0;
        int id = 0;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getOrderId() == (o.getOrderId())) {
                id = o.getOrderId();
                idx = i;
                break;
            }
        }

        Order order = new Order();
        
        order.setOrderId(o.getOrderId());
        order.setOrderType(o.getOrderType());
        order.setItems(o.getItems());
        order.setAmount(o.getAmount());
        order.setPrice(o.getPrice());
         
        list.set(idx, order);
        return order;
    }




}
