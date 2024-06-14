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
public class ItemService {
	
	@Autowired
	ItemRepository itemRepository;
	
	public List<Item> getAllItems() {
        return itemRepository.getAllItems();
    }
	
    public Item findByItemId(int id){	
		 return itemRepository.findByItemId(id);
	}

    public List<Item> searchItem(String name) {
        return  itemRepository.searchItem(name);
    }
     
    public Item saveItem(Item i) {
		 return itemRepository.saveItem(i);
    }

    
    public String deleteItem(Integer id) {
        return itemRepository.deleteItem(id); 
    }

    public Item updateItem(Item item) {
          return itemRepository.updateItem(item);
    }

	

}
