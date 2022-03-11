package com.qa.entity;

import java.util.Objects;

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

	@Override
	public int hashCode() {
		return Objects.hash(capacity, id, price, type);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Airport other = (Airport) obj;
		return capacity == other.capacity && id == other.id
				&& Float.floatToIntBits(price) == Float.floatToIntBits(other.price) && Objects.equals(type, other.type);
	}
	
	
	
	
}
