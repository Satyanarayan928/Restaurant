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
public class ItemRepository {
	
private List<Item> list = new ArrayList<Item>();
	
	public void createItem() {
		
				list.add(new Item(1, "Rice", 500.00));
				list.add(new Item(2, "MixVegRice",200.00));
				list.add(new Item(3, "MixVegCurry", 300.00));
				list.add(new Item(4, "PaneerCurry", 500.00));
				list.add(new Item(5, "Roti", 30.00));
				list.add(new Item(6, "Paratha", 60.00));
			
	}
	
	public List<Item> getAllItems() {
        return list;
    }
	
    public Item findByItemId(int id){
    	
    	try {
		
		for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getItemId() == (id)) {
                return list.get(i);
            }
        }
		return null;
    	}catch(Exception e) {
    		throw new ItemIdNotFoundException(e.getMessage());
    	}

	}

    public List<Item> searchItem(String name) {
    	try {
        return list.stream().filter(x -> x.getItem().startsWith(name)).collect(Collectors.toList());
    	}catch(Exception e) {
    		throw new ItemNameNotFoundException(e.getMessage());
    	}
    }
    
    
    
    public Item saveItem(Item i) {
		Item item = new Item();
		
		item.setItemId(i.getItemId());
		item.setItem(i.getItem());
		item.setPrice(i.getPrice());
         
        list.add(item);
        return item;
    }

    
    public String deleteItem(Integer id) {
        list.removeIf(x -> x.getItemId() == (id));
        return null;
    }

    public Item updateItem(Item item) {
        int idx = 0;
        int id = 0;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getItemId() == (item.getItemId())) {
                id = item.getItemId();
                idx = i;
                break;
            }
        }

        Item itemUpdate = new Item();
        itemUpdate.setItemId(item.getItemId());
        itemUpdate.setItem(item.getItem());
        itemUpdate.setPrice(item.getPrice());
         
        list.set(idx, itemUpdate);
        return itemUpdate;
    }



	

}
