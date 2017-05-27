// 电影场次

package org.sysupurify.tickets.business.entity;

import java.io.Serializable;
import java.util.ArrayList;

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
	private Movie movie = null;
	private String time = null;
	private ArrayList<Boolean> seat = new ArrayList<Boolean>(); // 定义座位是否可用
	 
	public Screening() {
		super();
	}
	
	public Screening(final Movie movie, final String time) {
		this.movie = movie;
		this.time = time;
		// 初始化座位是否可用
		for (int i = 0; i < 16 * 16; i++) {
			seat.add(true);
		}
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
	
	public Boolean getSeatAvailable(final int index) {
		return seat.get(index);
	}
	
	// 票已预订，将位置设为不可用
	public void setSeatAvailable(final int index) {
		seat.set(index, false);
	}
	
}
