package com.hms.controller;
import static org.junit.Assert.*;
import static org.mockito.Mockito.when;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import com.hms.dao.ReservationDao;
import com.hms.entity.Reservation;

public class ReservationTestCase {
	Date date1 = new Date(2021 - 05 - 03);
	Date date2 = new Date(2021 - 05 - 10);
	Reservation customer = new Reservation();

	@Mock
	ReservationDao reservationDao;

	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void testGetBookingDetails() {

		Reservation reservation1 = new Reservation(112, date1, date2, 100, 15, 1500, "AC", null);

		when(reservationDao.getBookingDetailsbyReservationId(112)).thenReturn(reservation1);
		System.out.println(reservation1.getSelectedRoomType());
		assertEquals(date1, reservation1.getCheckIn());
	}

	@Test
	public void testGetBookingDetailsByType() {
		List<Reservation> list = new ArrayList<Reservation>();
		Reservation reservation1 = new Reservation(112, date1, date2, 100, 15, 1500, "AC", null);
		Reservation reservation2 = new Reservation(113, date1, date2, 101, 15, 1500, "AC", null);
		list.add(reservation1);
		list.add(reservation2);
		when(reservationDao.getBookedRoomDetails("AC")).thenReturn(list);
		assertEquals(15, reservation2.getCustomerId());
	}
}
