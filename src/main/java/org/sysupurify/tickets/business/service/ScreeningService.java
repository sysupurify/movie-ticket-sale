package org.sysupurify.tickets.business.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.sysupurify.tickets.business.dao.IScreeningDao;
import org.sysupurify.tickets.business.entity.Screening;

@Service
@Transactional
public class ScreeningService implements IScreeningService {

	@Autowired
	IScreeningDao screeningDao;

	public void create(Screening screening) {
		screeningDao.create(screening);
	}
	
	@Cacheable(value="screening")
	public Screening findById(final Integer id) {
		return screeningDao.findOne(id);
	}

}

