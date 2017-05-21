package org.firework.sfs.business.dao;

import org.firework.sfs.business.entity.Role;
import org.firework.sfs.business.entity.User;
import org.firework.sfs.business.entity.UserRole;
import org.springframework.stereotype.Repository;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Query;

@Repository
public class UserRoleDao extends AbstractJpaDAO<UserRole> implements IUserRoleDao {

	public UserRoleDao() {
		super();
		setClazz(UserRole.class);
	}

	public boolean exists(User user, Role role) {
		return entityManager.contains(new UserRole(user, role));
		// String sql = "select count(1) from users_roles where user_id=:userId
		// and role_id=:roleId";
		// Query query = entityManager.createNativeQuery(sql, Integer.class);
		// query.setParameter("userId", userId);
		// query.setParameter("roleId", roleId);
		// return query.getFirstResult() != 0;
	}

	@SuppressWarnings("unchecked") // TODO @SuppressWarnings("unchecked") (包括其他dao
	public Set<String> findRoles(String username) {
		String sql = "select r.role from users u, roles r,user_role ur where u.username=:username and u.id=ur.user_id and r.id=ur.role_id";
		Query query = entityManager.createNativeQuery(sql);
		query.setParameter("username", username);
		return new HashSet<String>(query.getResultList());
	}

}
