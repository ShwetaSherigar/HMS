package com.hms.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;


@Entity
public class Reservation 
{
	@Id
	@GeneratedValue
	private int reservationId;
	private Date checkIn;
	private Date checkOut;
	@JoinColumn
	private int roomNo;
	
	@JoinColumn(name = "customerId")
	private int customerId;
	private float totalPrice;
	private String selectedroomType;
	
//	@Embedded
//	@AttributeOverrides({
//		  @AttributeOverride( name = "roomNo", column = @Column(name = "roomNo"))
//		})
	
	
	
//	@Embedded
//	@AttributeOverrides({
//		  @AttributeOverride( name = "customerId", column = @Column(name = "customerId"))
//		})

	
	public Reservation() {
		super();
		// TODO Auto-generated constructor stub
	}

	

	public Reservation(int reservationId, Date checkIn, Date checkOut, int roomNo, int customerId, float totalPrice,
		String selectedroomType) {
	super();
	this.reservationId = reservationId;
	this.checkIn = checkIn;
	this.checkOut = checkOut;
	this.roomNo = roomNo;
	this.customerId = customerId;
	this.totalPrice = totalPrice;
	this.selectedroomType = selectedroomType;
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
	
	
	public int getRoomNo() {
		return roomNo;
	}

	public void setRoomNo(int roomNo) {
		this.roomNo = roomNo;
	}


	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public float getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(float totalPrice) {
		this.totalPrice = totalPrice;
	}

	
	public String getSelectedroomType() {
		return selectedroomType;
	}



	public void setSelectedroomType(String selectedroomType) {
		this.selectedroomType = selectedroomType;
	}



	@Override
	public String toString() {
		return "Reservation [reservationId=" + reservationId + ", checkIn=" + checkIn + ", checkOut=" + checkOut
				+ ", roomNo=" + roomNo + ", customerId=" + customerId + ", totalPrice=" + totalPrice
				+ ", selectedroomType=" + selectedroomType + "]";
	}




}
