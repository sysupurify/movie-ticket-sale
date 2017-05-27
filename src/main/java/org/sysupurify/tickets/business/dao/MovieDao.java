package org.sysupurify.tickets.business.dao;

import javax.persistence.Query;

import org.sysupurify.tickets.business.entity.Movie;

public class MovieDao extends AbstractJpaDAO<Movie> implements IMovieDao {
	public MovieDao() {
		super();
		setClazz(Movie.class);
	}

	public Movie findByName(String movieName) {
		String sql = "select id, name, price, type, release, duration, language from movies m where name = :name";
		Query query = entityManager.createNativeQuery(sql, Movie.class);
		query.setParameter("name", movieName);
		return (Movie) query.getSingleResult();
	}
}
