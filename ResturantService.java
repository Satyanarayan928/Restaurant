/**
 * 
 */
package com.resturant.project;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 
 */
@Service
public class ResturantService {
	
	@Autowired
	ResturantRepository resturantRepository;
	
	public List<Resturant> getAllResturants() {
        return resturantRepository.getAllResturants();
    }
	
	
	public Resturant findByResturantId(int id){
		
		return resturantRepository.findByResturantId(id);

	}

	public Resturant findByResturantByName(String name){

		return resturantRepository.findByResturantByName(name);
	}
	public List<Resturant> searchResturant(String name) {
        return  resturantRepository.searchResturant(name);
    }

	public Resturant saveResturant(Resturant r) {
		 return resturantRepository.saveResturant(r);
    }
	
	public String deleteResturant(Integer id) {
         return resturantRepository.deleteResturant(id);
    }
	
	public Resturant updateResturant(Resturant resturant) {
		return resturantRepository.updateResturant(resturant);
             }

	public boolean isRestaurantOpen(Date startTime){
		return resturantRepository.isRestaurantOpen(startTime);
	}
}
