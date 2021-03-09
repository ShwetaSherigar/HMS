package com.hms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hms.dao.RoomDao;
import com.hms.entity.Room;

@Service
@Transactional
public class RoomServiceImpl implements RoomService {

	@Autowired
	RoomDao roomDao;

	@Override
	public List<String> getRoomTypes() {

		return roomDao.getRoomTypes();
	}

	@Override
	public boolean isVacant(int roomNo) {
		return roomDao.isVacant(roomNo);
	}

	@Override
	public List<Integer> getAllRoomNo(String roomType) {
		return roomDao.getAllRoomNo(roomType);
	}

	@Override
	public List<Room> getRoomDetails() {

		return roomDao.getRoomDetails();
	}

	@Override
	public int getCapacity(String roomType) {
		return roomDao.getCapacity(roomType);
	}

	@Override
	public double getPrice(String roomType) {
		return roomDao.getPrice(roomType);
	}

	@Override
	public Room allocateStatus(int roomNo, String status) {
		status = status.toUpperCase();
		return roomDao.allocateStatus(roomNo, status);
	}

	@Override
	public Room getRoomByRoomNo(int roomNo) {
		return roomDao.getRoomByRoomNo(roomNo);
	}

}
