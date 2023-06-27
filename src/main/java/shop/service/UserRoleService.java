package shop.service;

import shop.entity.UserRole;

public interface UserRoleService {
    UserRole save(UserRole userRole);
    UserRole get(Long id);
    UserRole remove(UserRole userRole);
}
