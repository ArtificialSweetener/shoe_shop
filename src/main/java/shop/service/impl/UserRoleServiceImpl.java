package shop.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import shop.dao.UserRoleDao;
import shop.entity.UserRole;
import shop.service.UserRoleService;

@Service
public class UserRoleServiceImpl implements UserRoleService {
    @Autowired
    private UserRoleDao userRoleDao;
    @Override
    public UserRole save(UserRole userRole) {
        return userRoleDao.save(userRole);
    }

    @Override
    public UserRole get(Long id) {
        return userRoleDao.get(id);
    }

    @Override
    public UserRole remove(UserRole userRole) {
        return userRoleDao.remove(userRole);
    }
}
