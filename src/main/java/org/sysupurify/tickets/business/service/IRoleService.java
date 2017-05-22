package org.sysupurify.tickets.business.service;

import org.sysupurify.tickets.business.entity.Role;

public interface IRoleService {

	void create(Role role);

	void delete(Long roleId);

	Role findByRole(String name);

}
