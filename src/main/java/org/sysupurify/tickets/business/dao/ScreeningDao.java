package org.sysupurify.tickets.business.dao;

import org.springframework.stereotype.Repository;
import org.sysupurify.tickets.business.entity.Screening;

@Repository
public class ScreeningDao extends AbstractJpaDAO<Screening> implements IScreeningDao{
	
	public ScreeningDao() {
		super();
		setClazz(Screening.class);
	}
}
