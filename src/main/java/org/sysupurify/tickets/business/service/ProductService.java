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
package org.sysupurify.tickets.business.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.sysupurify.tickets.business.dao.IProductDao;
import org.sysupurify.tickets.business.entity.Product;

@Service
@Transactional
public class ProductService implements IProductService {

	@Autowired
	IProductDao productDao;

	public void create(Product product) {
		productDao.create(product);
	}
	
	@Cacheable(value="product")
	public List<Product> findAll() {
		return productDao.findAll();
	}

	@Cacheable(value="product")
	public Product findById(final Integer id) {
		return productDao.findOne(id);
	}
	
	@Cacheable(value="product")
	public Product findByName(String productName) {
		return productDao.findByName(productName);
	}

}
