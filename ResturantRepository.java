/**
 * 
 */
package com.resturant.project;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;


import org.springframework.stereotype.Repository;
import com.resturant.project.Resturant;
import com.resturant.project.Resturant.ResturantNameNotFoundException;

/**
 * 
 */
@Repository
public class ResturantRepository {
	
	private List<Resturant> list = new ArrayList<Resturant>();
	
	public void createResturant() throws ParseException {

                SimpleDateFormat dtDate=new SimpleDateFormat("dd/MM/yyyy");
                SimpleDateFormat dtTime=new SimpleDateFormat("HH:mm:ss");
				list.add(new Resturant(1, "KFC", "HitechCity", "Hitech",  dtDate.parse("12/01/2014"), dtDate.parse("09:00:00"), dtDate.parse("21:30:00")));
				list.add(new Resturant(1, "Kutiga", "Ligampally", "Ligampally", dtDate.parse("15/02/2018"), dtDate.parse("10:00:00"), dtDate.parse("18:30:00")));
				list.add(new Resturant(1, "Bowrichy", "Gachibowli", "Gachibowli",  dtDate.parse("22/05/2020"), dtDate.parse("08:00:00"), dtDate.parse("20:30:00")));
				list.add(new Resturant(1, "Lemontree", "Gachibowli", "Gachibowli", dtDate.parse("18/03/2016"), dtDate.parse("11:00:00"), dtDate.parse("23:30:00")));
				list.add(new Resturant(1, "Lemontree", "HitechCity", "Hitech", dtDate.parse("11/04/2020"), dtDate.parse("07:00:00"), dtDate.parse("21:30:00")));
				list.add(new Resturant(1, "barbar", "HitechCity", "Hitech", dtDate.parse("10/02/2020"), dtDate.parse("07:00:00"), dtDate.parse("21:30:00")));
			
	}
	
	public List<Resturant> getAllResturants() {
        return list;
    }


	
	public Resturant findByResturantId(int id){
		try {
		for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getRestId() == (id)) {
                return list.get(i);
            }
        }
		return null;
		}catch(Exception e) {
			throw new com.resturant.project.ResturantIdNotFoundException(e.getMessage());
		}

	}

    public com.resturant.project.Resturant findByResturantByName(String name){
        try {
            for (int i = 0; i < list.size(); i++) {
                if (list.get(i).getName().equals(name)) {
                    return list.get(i);
                }
            }
          }catch(Exception e){
                throw new com.resturant.project.ResturantNameNotFoundException(e.getMessage());
            }

    }
	
	public List<com.resturant.project.Resturant> searchResturant(String name) throws ResturantNameNotFoundException {
		try {
        return list.stream().filter(x -> x.getName().startsWith(name)).collect(Collectors.toList());
		}catch(Exception e) {
			throw new ResturantNameNotFoundException(e.getMessage());
		}
    }

	public Resturant saveResturant(Resturant r) {
		Resturant resturant = new Resturant();
		
		resturant.setRestId(r.getRestId());
		resturant.setName(r.getName());
		resturant.setAddress(r.getAddress());
		resturant.setLandmark(r.getLandmark());
		
         
        list.add(resturant);
        return resturant;
    }
	
	public String deleteResturant(Integer id) {
        list.removeIf(x -> x.getRestId() == (id));
        return null;
    }
	
	public Resturant updateResturant(Resturant resturant) {
        int idx = 0;
        int id = 0;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getRestId() == (resturant.getRestId())) {
                id = resturant.getRestId();
                idx = i;
                break;
            }
        }

        Resturant resturant1 = new Resturant();
        resturant1.setRestId(id);
        resturant1.setName(resturant1.getName());
        resturant1.setAddress(resturant.getAddress());
        resturant1.setLandmark(resturant.getLandmark());
         
        list.set(idx, resturant1);
        return resturant1;
    }

    public boolean isRestaurantOpen(Date startTime){

        boolean isOpen = false;
        List<Resturant> restList=getAllResturants();
        if(restList != null && !restList.isEmpty()){
            for(Resturant r:restList){
                if((startTime.after(r.getStartTime())  || startTime.compareTo(r.getStartTime()) == 0)
                        && startTime.before(r.getCloseTime())){
                    isOpen = true;
                }else{
                    isOpen = false;
                }
            }
        }
        return isOpen;
    }




}
