package org.sysupurify.tickets.business.dao;

import java.util.List;

import org.sysupurify.tickets.business.entity.Movie;

public interface IMovieDao {

	void create(Movie movie);

	Movie update(Movie movie);

	void delete(long userId);

	Movie findOne(long userId);

	Movie findByName(String movieName);
	
	List<Movie> findAll();

}