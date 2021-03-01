package com.hms.entity;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Reservation 
{
	@Id
	@GeneratedValue
	private int reservationId;
	private Date checkIn;
	private Date checkOut;
	

	@JoinColumn
	private Room roomNo;
	
	@JoinColumn(name = "customerId")
	private Customer customerId;
	private float totalPrice;
	
	public Reservation() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Reservation(int reservationId, Date checkIn, Date checkOut, Room roomNo, Customer customerId, float totalPrice) {
		super();
		this.reservationId = reservationId;
		this.checkIn = checkIn;
		this.checkOut = checkOut;
		this.roomNo = roomNo;
		this.customerId = customerId;
		this.totalPrice = totalPrice;
	}

	public Date getCheckIn() {
		return checkIn;
	}

	public void setCheckIn(Date checkIn) {
		this.checkIn = checkIn;
	}

	public Date getCheckOut() {
		return checkOut;
	}

	public void setCheckOut(Date checkOut) {
		this.checkOut = checkOut;
	}
	
	
	public Room getRoomNo() {
		return roomNo;
	}

	public void setRoomNo(Room roomNo) {
		this.roomNo = roomNo;
	}


	public Customer getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Customer customerId) {
		this.customerId = customerId;
	}

	public float getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(float totalPrice) {
		this.totalPrice = totalPrice;
	}

	@Override
	public String toString() {
		return "Reservation [reservationId=" + reservationId + ", checkIn=" + checkIn + ", checkOut=" + checkOut
				+ ", roomNo=" +", customerId="+", totalPrice=" + totalPrice + "]";
	}


}
