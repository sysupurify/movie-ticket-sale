package org.sysupurify.tickets.business.service;

import java.util.Set;

import org.sysupurify.tickets.business.entity.Role;
import org.sysupurify.tickets.business.entity.User;

public interface IUserService {

	boolean exist(String username);

	void create(User user);

	void correlationRoles(User user, Role role);

	void uncorrelationRoles(User user, Role role);

	User findByUsername(String username);

	boolean hasRole(User user, Role role);

	Set<String> findRoles(String username);

	boolean isVip(String username);

}
