/**
 * 
 */
package com.resturant.project;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * 
 */
@Controller
public class ItemController {
	
	@Autowired
	ItemService itemService;
	
	@GetMapping
	public List<Item> getAllItems() {
        return itemService.getAllItems();
    }
	
	@GetMapping("{id}")
    public Item findByItemId(@PathVariable("id") int id){
		 return itemService.findByItemId(id);
	}

	@GetMapping("{name}")
    public List<Item> searchItem(@PathVariable("name") String name) {
        return  itemService.searchItem(name);
    }
     
	@PostMapping
    public Item saveItem(Item i) {
		 return itemService.saveItem(i);
    }

	@DeleteMapping("{id}")
    public String deleteItem(@PathVariable("id") Integer id) {
        return itemService.deleteItem(id); 
    }

	@PutMapping
    public Item updateItem(Item item) {
          return itemService.updateItem(item);
    }

}
