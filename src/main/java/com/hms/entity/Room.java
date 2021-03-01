package com.hms.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Room 
{
	@Id
	@GeneratedValue
	private int roomNo;
	private String roomType;
	private int capacity;
	private String status;
	private double price;
	
	public Room() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Room(int roomNo, String roomType, int capacity, String status, double price) {
		super();
		this.roomNo = roomNo;
		this.roomType = roomType;
		this.capacity = capacity;
		this.status = status;
		this.price = price;
	}

	public int getRoomNo() {
		return roomNo;
	}

	public void setRoomNo(int roomNo) {
		this.roomNo = roomNo;
	}

	public String getRoomType() {
		return roomType;
	}

	public void setRoomType(String roomType) {
		this.roomType = roomType;
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
		
	
}
