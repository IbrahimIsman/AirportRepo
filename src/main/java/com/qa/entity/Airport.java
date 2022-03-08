package com.qa.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Airport {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int id;
	String type;
	int capacity;
	float price;
	
	public Airport () {}
	
	public Airport(String type, int capacity, float price) {
		super();
		this.type = type;
		this.capacity = capacity;
		this.price = price;
	}
	
    public Airport(int id, String type, int capacity, float price) {
		super();
		this.id = id;
		this.type = type;
		this.capacity = capacity;
		this.price = price;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}
	
	
	
	
}
