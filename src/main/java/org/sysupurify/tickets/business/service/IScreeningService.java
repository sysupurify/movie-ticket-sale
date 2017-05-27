package org.sysupurify.tickets.business.service;

import org.sysupurify.tickets.business.entity.Screening;

public interface IScreeningService {
	
	void create(Screening screening);

	Screening findById(final Integer id);

}

