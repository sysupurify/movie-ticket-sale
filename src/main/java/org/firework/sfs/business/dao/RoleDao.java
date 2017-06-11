package org.firework.sfs.business.dao;

import javax.persistence.Query;

import org.firework.sfs.business.entity.Role;
import org.springframework.stereotype.Repository;

@Repository
public class RoleDao extends AbstractJpaDAO<Role> implements IRoleDao {

	public RoleDao() {
		super();
		setClazz(Role.class);
	}

	public Role findByRole(String role) {
		String sql = "select id, role, description from roles r where role = :role";
		Query query = entityManager.createNativeQuery(sql, Role.class);
		query.setParameter("role", role);
		return (Role) query.getSingleResult();
	}

}
