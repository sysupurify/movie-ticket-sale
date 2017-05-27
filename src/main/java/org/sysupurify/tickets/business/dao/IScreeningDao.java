package org.sysupurify.tickets.business.dao;

import java.util.List;

import org.sysupurify.tickets.business.entity.Screening;

public interface IScreeningDao {

	void create(Screening screening);

	Screening update(Screening screening);

	void delete(long userId);

	Screening findOne(long userId);
	
	List<Screening> findAll();

}