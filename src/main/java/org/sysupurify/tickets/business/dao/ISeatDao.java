package org.sysupurify.tickets.business.dao;

import java.util.List;

import org.sysupurify.tickets.business.entity.Seat;

public interface ISeatDao {

	void create(Seat seat);

	Seat update(Seat seat);

	void delete(long userId);

	Seat findOne(long userId);
	
	List<Seat> findAll();

}