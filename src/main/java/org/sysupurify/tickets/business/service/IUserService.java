package org.sysupurify.tickets.business.service;

import org.sysupurify.tickets.business.entity.User;

public interface IUserService {

	boolean exist(String username);

	void create(User user);

	User findByUsername(String username);

}
