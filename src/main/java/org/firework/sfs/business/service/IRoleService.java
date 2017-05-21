package org.firework.sfs.business.service;

import org.firework.sfs.business.entity.Role;

public interface IRoleService {

	void create(Role role);

	void delete(Long roleId);

	Role findByRole(String name);

}
