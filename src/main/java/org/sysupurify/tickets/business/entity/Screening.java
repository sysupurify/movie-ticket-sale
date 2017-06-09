// 电影场次

package org.sysupurify.tickets.business.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "screenings")
public class Screening implements Serializable, Comparable<Screening> {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id = null;
	
	@ManyToOne
	@JoinColumn(name = "movie_id")
	private Movie movie = null;
	
	private Date time = null;
	
	@OneToMany(mappedBy = "screening", cascade = CascadeType.ALL, fetch = FetchType.EAGER)  
	private List<Seat> seats;
	 
	public Screening() {
		super();
	}
	
	public Screening(final Movie movie, final Date time) {
		this.movie = movie;
		this.time = time;
	}
	
	public Movie getMovie() {
		return this.movie;
	}
	
	public void setMovie(final Movie movie) {
		this.movie = movie;
	}
	
	public Date getTime() {
		return this.time;
	}
	
	public void setTime(final Date time) {
		this.time = time;
	}

	public List<Seat> getSeats() {
		return seats;
	}

	public void setSeats(List<Seat> seats) {
		this.seats = seats;
	}

	public int compareTo(Screening o) {
		if (o == null)
			throw new NullPointerException();
		return time.compareTo(o.time);
	}
	
}
