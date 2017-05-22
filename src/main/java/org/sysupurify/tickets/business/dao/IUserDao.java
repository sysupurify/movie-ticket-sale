package org.sysupurify.tickets.business.dao;

import org.sysupurify.tickets.business.entity.User;

public interface IUserDao {

	void create(User user);

	User update(User user);

	void delete(long userId);

	User findOne(long userId);

	User findByUsername(String username);

}
