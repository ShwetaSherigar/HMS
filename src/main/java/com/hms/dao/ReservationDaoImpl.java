package com.hms.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hms.entity.Reservation;

@Repository
public class ReservationDaoImpl implements ReservationDao {
	@Autowired
	SessionFactory sessionFactory;

	protected Session getSession() {
		return (Session) sessionFactory.getCurrentSession();
	}

	public void createReservation(Reservation reservation) {
		getSession().saveOrUpdate(reservation);
		System.out.println("customer " + reservation.getCustomerId() + "reservation stored in DB");
	}

	 
//	 @Override public List<Employee> deleteEmployee(int empid) { Query query =
//	 getSession().createQuery("delete from Employee em where empid=:empid");
//	 query.setParameter("empid", empid); query.executeUpdate(); return
//	 getEmployeeList(); }
	 

	@Override
	public Reservation getBookingDetails(int customerId) {

		Criteria cr = getSession().createCriteria(Reservation.class);
		cr.add(Restrictions.eq("customerId", customerId));
		Reservation reservation = (Reservation) cr.uniqueResult();
		return reservation;

	}

	@Override
	public Reservation updateReservation(Reservation reservation, int customerId) {
		Query query = getSession().createQuery(
				"update Reservation set checkIn=:checkIn,checkOut=:checkOut,totalPrice=:totalPrice, selectedroomType=:selectedroomType where customerId=:customerId");
		query.setParameter("customerId", reservation.getCustomerId());
		query.setParameter("checkIn", reservation.getCheckIn());
		query.setParameter("checkOut", reservation.getCheckOut());
		query.setParameter("totalPrice", reservation.getTotalPrice());
		query.setParameter("selectedroomType", reservation.getSelectedroomType());
		query.executeUpdate();

		return getBookingDetails(customerId);
	}

	@Override
	public String deleteReservation(Reservation reservation, int reservationId) {
		Query query = getSession().createQuery("delete from Reservation where reservationId=:reservationId");
		query.setParameter("reservationId", reservationId);
		query.executeUpdate();
		return "Your Reservation deleted Successfully";
	}
}
