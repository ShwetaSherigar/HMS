package com.hms.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hms.entity.Room;

@Repository
public class RoomDaoImpl implements RoomDao{
	@Autowired
	SessionFactory sessionFactory;

	protected Session getSession() {
		return (Session) sessionFactory.getCurrentSession();
	}

	public List<String> getRoomTypes() {
		String hql = "Select roomType from Room R group by R.roomType";
		Query query = getSession().createQuery(hql);
		List results = query.list();
		return results;
	}

	public boolean isVacant(int roomNo) {
		Criteria cr = getSession().createCriteria(Room.class);
		cr.add(Restrictions.eq("roomNo", roomNo));
		Room room = (Room) cr.uniqueResult();
		if (room.getStatus().toUpperCase().equals("AVAILABLE")) 
		{
			return true;
		} else 
		{
			return false;
		}
	}

	public List<Integer> getAllRoomNo(String roomType) {
		String hql = "Select roomNo  from Room  R where R.roomType = :roomType";
		Query query = getSession().createQuery(hql);
		query.setParameter("roomType", roomType);
		List results = query.list();
		return results;
	}
	
	public List<Room> getRoomDetails() {
		String hql = "from Room";
		Query query = getSession().createQuery(hql);
		List results = query.list();
		return results;
	}
}
