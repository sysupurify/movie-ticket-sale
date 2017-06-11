package org.firework.sfs.business.dao;

import org.firework.sfs.business.entity.User;
import org.springframework.stereotype.Repository;

import java.util.List;

import javax.persistence.Query;

@Repository
public class UserDao extends AbstractJpaDAO<User> implements IUserDao {

	public UserDao() {
		super();
		setClazz(User.class);
	}

	@SuppressWarnings("unchecked")
	public User findByUsername(String username) {
		String sql = "select id, username, password, salt from users u where username = :username";
		Query query = entityManager.createNativeQuery(sql, User.class);
		query.setParameter("username", username);
		List<User> list = query.getResultList();
		if (list.isEmpty())
			return null;
		return list.get(0);
	}

}
