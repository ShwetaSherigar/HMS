package com.hms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hms.entity.Room;
import com.hms.service.RoomService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class RoomController {

	@Autowired
	RoomService roomService;

	@GetMapping("/getRoomTypes")
	private ResponseEntity<List<String>> getRoomTypes() {

		List<String> roomTypes = roomService.getRoomTypes();
		if (roomTypes.isEmpty()) {
			return new ResponseEntity<List<String>>(HttpStatus.NO_CONTENT);

		}
		return new ResponseEntity<List<String>>(roomTypes, HttpStatus.OK);
	}

	@GetMapping("/getStatus/{roomNo}")
	private ResponseEntity<Boolean> isVacant(@PathVariable("roomNo") int roomNo) {

		Boolean status = roomService.isVacant(roomNo);

		return new ResponseEntity<Boolean>(status, HttpStatus.OK);
	}

	@GetMapping("/getRoomNo/{roomType}")
	private ResponseEntity<List<Integer>> getAllRoomNo(@PathVariable("roomType") String roomType) {

		List<Integer> roomNos = roomService.getAllRoomNo(roomType);
		if (roomNos.isEmpty()) {
			return new ResponseEntity<List<Integer>>(HttpStatus.NO_CONTENT);

		}
		return new ResponseEntity<List<Integer>>(roomNos, HttpStatus.OK);
	}

	@GetMapping("/getRoomDetails")
	private ResponseEntity<List<Room>> getRoomDetails() {

		List<Room> roomDetails = roomService.getRoomDetails();
		if (roomDetails.isEmpty()) {
			return new ResponseEntity<List<Room>>(HttpStatus.NO_CONTENT);

		}
		return new ResponseEntity<List<Room>>(roomDetails, HttpStatus.OK);
	}

	@GetMapping("/getRoomCapacity/{roomType}")
	private ResponseEntity<Integer> getCapacity(@PathVariable("roomType") String roomType) {

		int capacity = roomService.getCapacity(roomType);
		return new ResponseEntity<Integer>(capacity, HttpStatus.OK);
	}

	@GetMapping("/getRoomPrice/{roomType}")
	private ResponseEntity<Double> getPrice(@PathVariable("roomType") String roomType) {

		double price = roomService.getPrice(roomType);
		return new ResponseEntity<Double>(price, HttpStatus.OK);
	}

	@PutMapping("/allocateStatus/{roomNo}/{status}")
	private ResponseEntity<Room> allocateStatus(@PathVariable("roomNo") int roomNo,
			@PathVariable("status") String status) {

		Room room = roomService.allocateStatus(roomNo, status);
		return new ResponseEntity<Room>(room, HttpStatus.OK);
	}
}