package org.sysupurify.tickets.business.service;

import java.util.List;

import org.sysupurify.tickets.business.entity.Movie;

public interface IMovieService {
	
	void create(Movie movie);

	List<Movie> findAll();

	// 按年月日查找
//	List<Movie> findByDate();

	Movie findById(final Integer id);

	Movie findByName(String movieName);

}

