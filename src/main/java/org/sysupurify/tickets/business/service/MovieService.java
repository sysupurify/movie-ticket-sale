package org.sysupurify.tickets.business.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.sysupurify.tickets.business.dao.IMovieDao;
import org.sysupurify.tickets.business.entity.Movie;

@Service
@Transactional
public class MovieService implements IMovieService {

	@Autowired
	IMovieDao movieDao;

	public void create(Movie movie) {
		movieDao.create(movie);
	}
	
//	@Cacheable(value="movie")
	public List<Movie> findAll() {
		return movieDao.findAll();
	}

//	@Cacheable(value="movie")
	public Movie findById(final Integer id) {
		return movieDao.findOne(id);
	}
	
//	@Cacheable(value="movie")
	public Movie findByName(String movieName) {
		return movieDao.findByName(movieName);
	}

}

