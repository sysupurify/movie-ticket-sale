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
	private String type = null; // 电影类型
	private String release = null; // 电影上映时间
	private String duration = null; // 电影时长
	private String language = null; // 电影语言
	
	public Movie() {
		super();
	}
	
	public Movie(final String name, final String price, final String type, 
			final String release, final String duration, final String language) {
		
		super();
		this.name = name;
		this.price = price;
		this.type = type;
		this.release = release;
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
	
	public String getType() {
		return this.type;
	}
	
	public void setType(final String type) {
		this.type = type;
	}
	
	public String getRelease() {
		return this.release;
	}
	
	public void setRelease(final String release) {
		this.release = release;
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
