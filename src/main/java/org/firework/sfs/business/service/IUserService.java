package org.firework.sfs.business.service;

import org.firework.sfs.business.entity.Role;
import org.firework.sfs.business.entity.User;

import java.util.Set;

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
