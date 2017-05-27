// 电影清单

package org.sysupurify.tickets.business.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "movies")
public class Movie implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id = null;
	private String name = null; // 电影名字
	private String price = null; // 电影票价
	private String genre = null; // 电影类型
	private String releasetime = null; // 电影上映时间
	private String duration = null; // 电影时长
	private String language = null; // 电影语言
	
	public Movie() {
		super();
	}
	
	public Movie(final String name, final String price, final String genre, 
			final String releasetime, final String duration, final String language) {
		
		super();
		this.name = name;
		this.price = price;
		this.genre = genre;
		this.releasetime = releasetime;
		this.duration = duration;
		this.language = language;
	}

	public Long getId() {
		return this.id;
	}

	public void setId(final Long id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(final String name) {
		this.name = name;
	}
	
	public String getPrice() {
		return this.price;
	}
	
	public void setPrice(final String price) {
		this.price = price;
	}
	
	public String getGenre() {
		return this.genre;
	}
	
	public void setGenre(final String genre) {
		this.genre = genre;
	}
	
	public String getReleasetime() {
		return this.releasetime;
	}
	
	public void setReleasetime(final String releasetime) {
		this.releasetime = releasetime;
	}
	
	public String getDuration() {
		return this.duration;
	}
	
	public void setDuration(final String duration) {
		this.duration = duration;
	}
	
	public String getLanguage() {
		return this.language;
	}
	
	public void setLanguage(final String language) {
		this.language = language;
	}
	
}
