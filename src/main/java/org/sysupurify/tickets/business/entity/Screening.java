// 电影场次

package org.sysupurify.tickets.business.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "screenings")
public class Screening implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id = null;
	@ManyToOne
	@JoinColumn(name = "movie_id")
	private Movie movie;
	private String time; 
	
	public Screening() {
		super();
	}
	
	public Screening(final Movie movie, final String time) {
		this.movie = movie;
		this.time = time;
	}
	
	public Movie getMovie() {
		return this.movie;
	}
	
	public void setMovie(final Movie movie) {
		this.movie = movie;
	}
	
	public String getTime() {
		return this.time;
	}
	
	public void setTime(final String time) {
		this.time = time;
	}
	
}
