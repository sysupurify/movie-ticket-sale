package org.firework.sfs.business.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.firework.sfs.business.dao.IRoleDao;
import org.firework.sfs.business.entity.Role;

@Service
@Transactional
public class RoleService implements IRoleService {
	@Autowired
	private IRoleDao roleDao;

	public void create(Role role) {
		roleDao.create(role);
	}

	public void delete(Long roleId) {
		roleDao.delete(roleId);
	}

	@Cacheable("role")
	public Role findByRole(String name) {
		return roleDao.findByRole(name);
	}

}
