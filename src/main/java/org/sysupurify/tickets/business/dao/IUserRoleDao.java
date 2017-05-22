package org.sysupurify.tickets.business.dao;

import java.util.Set;

import org.sysupurify.tickets.business.entity.Role;
import org.sysupurify.tickets.business.entity.User;
import org.sysupurify.tickets.business.entity.UserRole;

public interface IUserRoleDao {

	void create(UserRole userRole);

	UserRole update(UserRole userRole);

	void delete(UserRole entity);
	
	boolean exists(User user, Role role);
	
	Set<String> findRoles(String username);

}
