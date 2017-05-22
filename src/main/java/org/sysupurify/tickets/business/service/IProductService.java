package org.sysupurify.tickets.business.service;

import java.util.List;

import org.sysupurify.tickets.business.entity.Product;

public interface IProductService {
	
	void create(Product product);

	List<Product> findAll();

	Product findById(final Integer id);

	Product findByName(String productName);

}
