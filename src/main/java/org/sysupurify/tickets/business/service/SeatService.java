package org.sysupurify.tickets.business.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.sysupurify.tickets.business.dao.IScreeningDao;
import org.sysupurify.tickets.business.dao.ISeatDao;
import org.sysupurify.tickets.business.entity.Screening;
import org.sysupurify.tickets.business.entity.Seat;

@Service
@Transactional
public class SeatService implements ISeatService {

	@Autowired
	IScreeningDao screeningDao;
	@Autowired
	ISeatDao seatDao;

	public void create(Screening screening) {
		for (int i = 0; i < 3; i++)
			for (int j = 0; j < 3; j++)
				seatDao.create(new Seat(screening, i + 1, j + 1));
	}

	@Cacheable(value = "screening")
	public Seat findById(final Integer id) {
		return seatDao.findOne(id);
	}
	
//	@Cacheable(value="movie")
	public List<Seat> findAll() {
		return seatDao.findAll();
	}

}
