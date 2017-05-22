package org.sysupurify.tickets.business.dao;

import org.sysupurify.tickets.business.entity.Role;

public interface IRoleDao {

	void create(Role role);

	void delete(long roleId);

	Role findByRole(String name);

}
