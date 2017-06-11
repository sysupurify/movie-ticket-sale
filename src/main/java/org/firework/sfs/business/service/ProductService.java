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
package org.firework.sfs.business.service;

import java.util.List;

import org.firework.sfs.business.dao.IProductDao;
import org.firework.sfs.business.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ProductService implements IProductService {

	@Autowired
	IProductDao productDao;

	public void create(Product product) {
		productDao.create(product);
	}
	
	
	//@CachePut("product")
	@Cacheable(value="product")
	public List<Product> findAll() {
		return productDao.findAll();
	}

	@Cacheable(value="product")
	//@CachePut("product")
	public Product findById(final Integer id) {
		return productDao.findOne(id);
	}
	
	@Cacheable(value="product")
	//@CachePut("product")
	public Product findByName(String productName) {
		return productDao.findByName(productName);
	}

}
