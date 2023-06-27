package shop.dao;

import shop.entity.UserRole;

public interface UserRoleDao {
    UserRole save(UserRole userRole);
    UserRole get(Long id);
    UserRole remove(UserRole userRole);
}
