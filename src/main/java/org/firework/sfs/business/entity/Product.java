/*
 * =============================================================================
 * 
 *   Copyright (c) 2011-2016, The THYMELEAF team (http://www.thymeleaf.org)
 * 
 *   Licensed under the Apache License, Version 2.0 (the "License");
 *   you may not use this file except in compliance with the License.
 *   You may obtain a copy of the License at
 * 
 *       http://www.apache.org/licenses/LICENSE-2.0
 * 
 *   Unless required by applicable law or agreed to in writing, software
 *   distributed under the License is distributed on an "AS IS" BASIS,
 *   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *   See the License for the specific language governing permissions and
 *   limitations under the License.
 * 
 * =============================================================================
 */
package org.firework.sfs.business.entity;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "products")
public class Product implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id = null;
	private String name = null;
	private BigDecimal price = null;
	private boolean inStock = false;
	private boolean vipDiscount = true;
	// private List<Comment> comments = new ArrayList<Comment>();

	public Product() {
		super();
	}

	public Product(final String name, final boolean inStock, final BigDecimal price, final boolean vipDiscount) {
		super();
		this.name = name;
		this.price = price;
		this.inStock = inStock;
		this.vipDiscount = vipDiscount;
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

	public BigDecimal getPrice() {
		return this.price;
	}

	public void setPrice(final BigDecimal price) {
		this.price = price;
	}

	public boolean getInStock() {
		return this.inStock;
	}

	public void setInStock(final boolean inStock) {
		this.inStock = inStock;
	}

	public boolean getVipDiscount() {
		return this.vipDiscount;
	}

	public void setVipDiscount(final boolean vipDiscount) {
		this.vipDiscount = vipDiscount;
	}

	// public List<Comment> getComments() {
	// return this.comments;
	// }

}
