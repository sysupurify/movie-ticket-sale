package org.firework.sfs.business.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "user_role")
public class UserRole implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;
	@Id
	@ManyToOne
	@JoinColumn(name = "role_id")
	private Role role;

	public UserRole(User user, Role role) {
		this.user = user;
		this.role = role;
	}

	public User getUserId() {
		return user;
	}

	public void setUserId(User userId) {
		this.user = userId;
	}

	public Role getRoleId() {
		return role;
	}

	public void setRoleId(Role roleId) {
		this.role = roleId;
	}

	// @Override
	public boolean equals(UserRole userRole) {
		return user.getId() == userRole.user.getId() && role.getId() == userRole.role.getId();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + user.getId().hashCode() * role.getId().hashCode(); // FIXME temp
		return result;
	}

	@Override
	public boolean equals(final Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		final UserRole other = (UserRole) obj;
		return user.getId() == other.user.getId() && role.getId() == other.role.getId();
	}

}
