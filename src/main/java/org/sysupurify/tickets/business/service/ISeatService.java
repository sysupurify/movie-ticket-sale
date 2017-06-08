package org.sysupurify.tickets.business.service;

import java.util.List;

import org.sysupurify.tickets.business.entity.Seat;
import org.sysupurify.tickets.business.entity.Screening;

public interface ISeatService {
	void create(Screening screening);

	Seat findById(final Integer id);
	
	List<Seat> findAll();
}
