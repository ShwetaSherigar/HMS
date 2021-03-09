package com.hms.controller;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.hms.dao.RoomDao;

import com.hms.entity.Room;

public class RoomTestCase {

	Room room = new Room();

	@Mock
	RoomDao roomDao;

	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void testGetRoomDetails() {
		List<Room> list = new ArrayList<Room>();
		Room room1 = new Room(100, "LUXURY", 3, "AVAILABLE", 1000);
		Room room2 = new Room(101, "LUXURY", 3, "AVAILABLE", 1000);
		list.add(room1);
		list.add(room2);
		when(roomDao.getRoomDetails()).thenReturn(list);
		assertEquals(3, room1.getCapacity());
	}

	@Test
	public void testGetRoomByRoomNo() {

		Room room1 = new Room(100, "LUXURY", 3, "AVAILABLE", 1000);
		when(roomDao.getRoomByRoomNo(100)).thenReturn(room1);
		assertEquals(3, room1.getCapacity());
	}

}
