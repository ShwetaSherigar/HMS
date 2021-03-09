package com.hms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hms.dao.ReservationDao;
import com.hms.entity.Reservation;

@Service
@Transactional
public class ReservationServiceImpl implements ReservationService {

	@Autowired
	ReservationDao reservationDao;

	@Override
	public void createReservation(Reservation reservation) {

		reservation.setSelectedRoomType(reservation.getSelectedRoomType().toUpperCase());
		reservationDao.createReservation(reservation);

	}

	@Override
	public List<Reservation> getBookingDetails(Reservation reservation, int customerId) {

		return reservationDao.getBookingDetails(reservation, customerId);
	}

	@Override
	public List<Reservation> updateReservation(Reservation reservation, int reservationId) {

		reservation.setSelectedRoomType(reservation.getSelectedRoomType().toUpperCase());
		return reservationDao.updateReservation(reservation, reservationId);
	}

	@Override
	public String deleteReservation(Reservation reservation, int reservationId) {
		return reservationDao.deleteReservation(reservation, reservationId);
	}

	@Override
	public String cancelReservation(Reservation reservation, int reservationId) {
		return reservationDao.cancelReservation(reservation, reservationId);

	}

	@Override
	public List<Reservation> getBookedRoomDetails(String roomType) {

		return reservationDao.getBookedRoomDetails(roomType);
	}

	@Override
	public Reservation getBookingDetailsbyReservationId(int reservationId) {

		return reservationDao.getBookingDetailsbyReservationId(reservationId);
	}
}
