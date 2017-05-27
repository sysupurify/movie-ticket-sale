package org.sysupurify.tickets.business.dao;

import javax.persistence.Query;

import org.sysupurify.tickets.business.entity.Screening;

public class ScreeningDao extends AbstractJpaDAO<Screening> implements IScreeningDao{
	
	public ScreeningDao() {
		super();
		setClazz(Screening.class);
	}

	public Screening findByName(String screeningName) {
		String sql = "select id, movie_id, time from screenings s where name = :name"; // 此处movie可能有bug
		Query query = entityManager.createNativeQuery(sql, Screening.class);
		query.setParameter("name", screeningName);
		return (Screening) query.getSingleResult();
	}
}
