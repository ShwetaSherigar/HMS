package com.hms.service;

import java.util.List;

import com.hms.entity.Reservation;

public interface ReservationService {

	public List<Reservation> updateReservation(Reservation reservation, int reservationId);

	public String deleteReservation(Reservation reservation, int reservationId);

	public void createReservation(Reservation reservation);

	public List<Reservation> getBookingDetails(Reservation reservation, int customerId);

	public List<Reservation> getBookedRoomDetails(String roomType);

	public Reservation getBookingDetailsbyReservationId(int reservationId);

	public String cancelReservation(Reservation reservation, int reservationId);

}
