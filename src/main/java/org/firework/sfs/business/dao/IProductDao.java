package org.firework.sfs.business.dao;

import java.util.List;

import org.firework.sfs.business.entity.Product;

public interface IProductDao {

	void create(Product product);

	Product update(Product product);

	void delete(long userId);

	Product findOne(long userId);

	Product findByName(String productName);
	
	List<Product> findAll();

}
