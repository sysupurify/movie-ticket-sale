package org.sysupurify.tickets.business.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.sysupurify.tickets.business.dao.IUserDao;
import org.sysupurify.tickets.business.entity.User;

import java.util.Set;

@Service
@Transactional
public class UserService implements IUserService {
	@Autowired
	private IUserDao userDao;

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

	public User findByUsername(String username) {
		return userDao.findByUsername(username);
	}

}
