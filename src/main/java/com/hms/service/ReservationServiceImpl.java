package com.hms.service;

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
		reservationDao.createReservation(reservation);

	}

	@Override
	public Reservation getBookingDetails(int customerId) {

		return reservationDao.getBookingDetails(customerId);
	}

	@Override
	public Reservation updateReservation(Reservation reservation, int customerId) {
		
		return reservationDao.updateReservation(reservation, customerId);
	}

	@Override
	public String deleteReservation(Reservation reservation, int reservationId) {
		return reservationDao.deleteReservation(reservation, reservationId);
	}

}
