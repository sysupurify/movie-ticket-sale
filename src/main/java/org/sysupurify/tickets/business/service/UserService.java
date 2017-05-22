package org.sysupurify.tickets.business.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.sysupurify.tickets.business.dao.IUserDao;
import org.sysupurify.tickets.business.dao.IUserRoleDao;
import org.sysupurify.tickets.business.entity.Role;
import org.sysupurify.tickets.business.entity.User;
import org.sysupurify.tickets.business.entity.UserRole;

import java.util.Set;

@Service
@Transactional
public class UserService implements IUserService {
	@Autowired
	private IUserDao userDao;
	@Autowired
	private IUserRoleDao userRoleDao;

	public boolean exist(String username) {
		return userDao.findByUsername(username) != null;
	}
	
	public void create(User user) {
		userDao.create(user);
	}

	public void changePassword(Long userId, String newPassword) {
		User user = userDao.findOne(userId);
		user.setPassword(newPassword);
		userDao.update(user);
	}

	public void correlationRoles(User user, Role role) {
		userRoleDao.create(new UserRole(user, role));
	}

	public void uncorrelationRoles(User user, Role role) {
		userRoleDao.delete(new UserRole(user, role));
	}

	public User findByUsername(String username) {
		return userDao.findByUsername(username);
	}

	@Cacheable("user_role")
	public boolean hasRole(User user, Role role) {
		return userRoleDao.exists(user, role);
	}

	@Cacheable("user_role")
	public Set<String> findRoles(String username) {
		return userRoleDao.findRoles(username);
	}

	public boolean isVip(String username) {
		return findRoles(username).contains("vip");
	}

}
