package com.hms.service;

import com.hms.entity.Reservation;

public interface ReservationService 
{
	public void createReservation(Reservation reservation);
	public Reservation getBookingDetails(int customerId);
	public Reservation updateReservation(Reservation reservation,int customerId ) ;
	public String deleteReservation(Reservation reservation,int reservationId);
}
