package org.firework.sfs.business.dao;

import org.firework.sfs.business.entity.Role;

public interface IRoleDao {

	void create(Role role);

	void delete(long roleId);

	Role findByRole(String name);

}
