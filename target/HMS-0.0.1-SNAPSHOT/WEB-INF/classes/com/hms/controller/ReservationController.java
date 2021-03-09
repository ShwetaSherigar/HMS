package com.hms.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.hms.entity.Reservation;
import com.hms.service.ReservationService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class ReservationController {

	@Autowired
	ReservationService reservationService;

	@PostMapping("/reservation")
	public Reservation createReservation(@RequestBody Reservation reservation) {
		reservationService.createReservation(reservation);
		return reservation;
	}

	@GetMapping("/bookingDetail/{customerId}")
	private ResponseEntity<List<Reservation>> getBookingDetails(Reservation reservation,
			@PathVariable("customerId") int customerId) {

		List<Reservation> bookingdetails = reservationService.getBookingDetails(reservation, customerId);
		if (bookingdetails.isEmpty()) {
			return new ResponseEntity<List<Reservation>>(HttpStatus.NO_CONTENT);

		}
		return new ResponseEntity<List<Reservation>>(bookingdetails, HttpStatus.OK);
	}

	@PutMapping("/update/{reservationId}")
	public List<Reservation> updateReservation(@RequestBody Reservation reservation,
			@PathVariable("reservationId") int reservationId) {
		List<Reservation> updated = reservationService.updateReservation(reservation, reservationId);
		return updated;
	}

	@DeleteMapping("/delete/{reservationId}")
	public String deleteEmployee(Reservation reservation, @PathVariable("reservationId") int reservationId) {
		String deleted = reservationService.deleteReservation(reservation, reservationId);
		return deleted;
	}

	@GetMapping("/bookingDetailbyresId/{reservationId}")
	public Reservation getBookingDetailsbyReservationId(@PathVariable("reservationId") int reservationId) {
		Reservation bookingdetails = reservationService.getBookingDetailsbyReservationId(reservationId);

		return bookingdetails;
	}

	@GetMapping("/bookedRoomDetail/{roomType}")
	public List<Reservation> getBookedRoomDetails(@PathVariable("roomType") String roomType) {
		List<Reservation> bookedRoomDetails = reservationService.getBookedRoomDetails(roomType);

		return bookedRoomDetails;
	}

	@PutMapping("/cancel/{reservationId}")
	public ResponseEntity<Reservation> cancelReservation(Reservation reservation,
			@PathVariable("reservationId") int reservationId) {
		String cancelled = reservationService.cancelReservation(reservation, reservationId);

		return new ResponseEntity<Reservation>(reservation, HttpStatus.OK);
	}
}
