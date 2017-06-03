package org.sysupurify.tickets.business.dao;

import org.springframework.stereotype.Repository;
import org.sysupurify.tickets.business.entity.Seat;

@Repository
public class SeatDao extends AbstractJpaDAO<Seat> implements ISeatDao{
	
	public SeatDao() {
		super();
		setClazz(Seat.class);
	}
}
