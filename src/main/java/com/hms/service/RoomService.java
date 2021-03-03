package com.hms.service;

import java.util.List;

import com.hms.entity.Room;

public interface RoomService 
{
	public List<String> getRoomTypes() ;
	public boolean isVacant(int roomNo);
	public List<Integer> getAllRoomNo(String roomType);
	public List<Room> getRoomDetails();
}
