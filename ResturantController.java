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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * 
 */
@Controller
public class ResturantController {
	
	
	@Autowired
	ResturantService resturantService;
	
	@GetMapping
	public List<Resturant> findAllResturants() {
        return resturantService.getAllResturants();
    }
	
	
	@GetMapping("{id}")
	public Resturant findByResturantId(@PathVariable("id") int id){
		
		return resturantService.findByResturantId(id);

	}

	@GetMapping("{name}")
	public Resturant findByResturantByName(@PathVariable("name") String name){
         return resturantService.findByResturantByName(name);
	}
	
	@GetMapping("{name}")
	public List<Resturant> searchResturant(@PathVariable("name") String name) {
        return  resturantService.searchResturant(name);
    }

	@PostMapping
	public Resturant saveResturant(@RequestBody Resturant r) {
		 return resturantService.saveResturant(r);
    }
	
	@DeleteMapping("{id}")
	public String deleteResturant(@PathVariable("id") Integer id) {
         return resturantService.deleteResturant(id);
    }
	
	@PutMapping
	public Resturant updateResturant(@RequestBody Resturant resturant) {
		return resturantService.updateResturant(resturant);
             }


}
