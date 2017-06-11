package org.firework.sfs.business.dao;

import org.firework.sfs.business.entity.User;

public interface IUserDao {

	void create(User user);

	User update(User user);

	void delete(long userId);

	User findOne(long userId);

	User findByUsername(String username);

}
