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

	public List<Reservation> getBookingDetails(Reservation reservation, int customerId) {
		String hql = " from Reservation where customerId=:customerId";
		Query query = getSession().createQuery(hql);
		query.setParameter("customerId", reservation.getCustomerId());
		List results = query.list();
		return results;
	}

	public Reservation getBookingDetailsbyReservationId(int reservationId) {
		Criteria cr = getSession().createCriteria(Reservation.class);
		cr.add(Restrictions.eq("reservationId", reservationId));
		Reservation reservation = (Reservation) cr.uniqueResult();
		return reservation;
	}

	public List<Reservation> updateReservation(Reservation reservation, int reservationId) {
		Query query = getSession().createQuery(
				"update Reservation set checkIn=:checkIn,checkOut=:checkOut,totalPrice=:totalPrice, selectedRoomType=:selectedRoomType where reservationId=:reservationId");
		query.setParameter("reservationId", reservation.getReservationId());
		query.setParameter("checkIn", reservation.getCheckIn());
		query.setParameter("checkOut", reservation.getCheckOut());
		query.setParameter("totalPrice", reservation.getTotalPrice());
		query.setParameter("selectedRoomType", reservation.getSelectedRoomType());
		query.executeUpdate();

		return getBookingDetails(reservation, reservationId);
	}

	public String deleteReservation(Reservation reservation, int reservationId) {
		Query query = getSession().createQuery("delete from Reservation where reservationId=:reservationId");
		query.setParameter("reservationId", reservationId);
		query.executeUpdate();
		return "Your Reservation deleted Successfully";
	}

	public String cancelReservation(Reservation reservation, int reservationId) {
		Query query = getSession()
				.createQuery("update Reservation set status = 'CANCELLED' where reservationId = :reservationId");
		query.setParameter("reservationId", reservationId);
		query.executeUpdate();
		return "Your reservation cancelled successfully.";
	}

	public List<Reservation> getBookedRoomDetails(String roomType) {
		Query query = getSession().createQuery(
				"from Reservation where selectedRoomType = :roomType and (status is null or status != 'CANCELLED')");
		query.setParameter("roomType", roomType);
		List<Reservation> reservation = query.list();
		return reservation;
	}

}
