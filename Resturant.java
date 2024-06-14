/**
 * 
 */
package com.resturant.project;

import java.util.Date;

/**
 * 
 */
public class Resturant {
	
	private int restId;
	private String name;
	private String address;
	private String landmark;
	private Date date;
	private Date startTime;
	private Date closeTime;

	public Resturant(int restId, String name, String address, String landmark, Date date, Date startTime, Date closeTime) {
		this.restId = restId;
		this.name = name;
		this.address = address;
		this.landmark = landmark;
		this.date = date;
		this.startTime = startTime;
		this.closeTime = closeTime;
	}

	public Resturant() {
		// TODO Auto-generated constructor stub
	}
	public int getRestId() {
		return restId;
	}
	public void setRestId(int restId) {
		this.restId = restId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getLandmark() {
		return landmark;
	}
	public void setLandmark(String landmark) {
		this.landmark = landmark;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Date getStartTime() {
		return startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	public Date getCloseTime() {
		return closeTime;
	}

	public void setCloseTime(Date closeTime) {
		this.closeTime = closeTime;
	}
}
