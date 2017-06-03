package org.sysupurify.tickets.business.service;

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
public class ScreeningService implements IScreeningService {

	@Autowired
	IScreeningDao screeningDao;
	@Autowired
	ISeatDao seatDao;

	public void create(Screening screening) {
		screeningDao.create(screening);
		for (int i = 0; i < 2; i++)
			for (int j = 0; j < 2; j++)
				seatDao.create(new Seat(screening, i + 1, j + 1));
	}

	@Cacheable(value = "screening")
	public Screening findById(final Integer id) {
		return screeningDao.findOne(id);
	}

}
