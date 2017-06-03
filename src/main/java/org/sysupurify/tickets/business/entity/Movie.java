// 电影清单

package org.sysupurify.tickets.business.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "movies")
public class Movie implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id = null;
	
	private String name = null; // 电影名字
	private float price = 0; // 电影票价
	private String genre = null; // 电影类型
	private Date releasetime = null; // 电影上映时间
	private int duration = 0; // 电影时长（分钟）
	private String language = null; // 电影语言
	
	@OneToMany(mappedBy = "movie", cascade = CascadeType.ALL)  
	private List<Screening> screenings;  
	
	public Movie() {
		super();
	}
	
	public Movie(final String name, final float price, final String genre, 
			final Date releasetime, final int duration, final String language) {
		
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
	
	public String getGenre() {
		return this.genre;
	}
	
	public void setGenre(final String genre) {
		this.genre = genre;
	}
	
	public Date getReleasetime() {
		return this.releasetime;
	}
	
	public void setReleasetime(final Date releasetime) {
		this.releasetime = releasetime;
	}
	
	public String getLanguage() {
		return this.language;
	}
	
	public void setLanguage(final String language) {
		this.language = language;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public float getPrice() {
		return price;
	}

	public int getDuration() {
		return duration;
	}

	public List<Screening> getScreenings() {
		return screenings;
	}

	public void setScreenings(List<Screening> screenings) {
		this.screenings = screenings;
	}
	
}
