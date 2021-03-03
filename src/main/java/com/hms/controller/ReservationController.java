package com.hms.controller;

import org.springframework.beans.factory.annotation.Autowired;
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
	public Reservation createReservation(@RequestBody Reservation reservation) 
	{
		reservationService.createReservation(reservation);
		return reservation;
	}

	@GetMapping("/bookingDetail/{customerId}")
	public Reservation getBookingDetails(@PathVariable("customerId") int customerId) 
	{
		Reservation bookingdetails = reservationService.getBookingDetails(customerId);

		return bookingdetails;
	}

	@PutMapping("/update/{customerId}")
	public Reservation updateReservation(@RequestBody Reservation reservation,@PathVariable("customerId") int customerId) 
	{
		Reservation updated = reservationService.updateReservation(reservation, customerId);
		return updated;
	}

	@DeleteMapping("/delete/{reservationId}")
	public String deleteEmployee(Reservation reservation, @PathVariable("reservationId") int reservationId) 
	{
		String deleted = reservationService.deleteReservation(reservation, reservationId);
		return deleted;
	}
}
