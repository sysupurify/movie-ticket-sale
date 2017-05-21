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
package org.firework.sfs.business.dao;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import javax.persistence.Query;

import org.firework.sfs.business.entity.Product;
import org.springframework.stereotype.Repository;

@Repository
public class ProductDao extends AbstractJpaDAO<Product> implements IProductDao {

	public ProductDao() {
		super();
		setClazz(Product.class);
	}

	public Product findByName(String productName) {
		String sql = "select id, name, price, inStock, vipDiscount from products p where name = :name";
		Query query = entityManager.createNativeQuery(sql, Product.class);
		query.setParameter("name", productName);
		return (Product) query.getSingleResult();
	}

//	@SuppressWarnings("unchecked")
//	public List<Product> findAll() {
//		String sql = "select * from products";
//		Query query = entityManager.createNativeQuery(sql, Product.class);
//		return new SlowList<Product>(query.getResultList());
//	}

	static final class SlowList<T> extends ArrayList<T> {

		private static final long serialVersionUID = 1L;

		public SlowList(final Collection<? extends T> c) {
			super(c);
		}

		@Override
		public Iterator<T> iterator() {
			final Iterator<T> iterator = super.iterator();
			return new Iterator<T>() {
				public boolean hasNext() {
					return iterator.hasNext();
				}

				public void remove() {
					iterator.remove();
				}

				public T next() {
					try {
						// Thread.currentThread().sleep(10L);
						Thread.sleep(10L);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					return iterator.next();
				}
			};
		}

	}

}
