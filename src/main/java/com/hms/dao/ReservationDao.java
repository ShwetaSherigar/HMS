package com.hms.dao;

import java.util.List;

import com.hms.entity.Reservation;

public interface ReservationDao 
{

	public Reservation updateReservation(Reservation reservation,int customerId );
	public  String deleteReservation(Reservation reservation,int reservationId);
	public void createReservation(Reservation reservation);
	public Reservation getBookingDetails(int customerId);
	
}
