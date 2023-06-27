package shop.dao;

import shop.entity.User;

import java.util.Optional;

public interface UserDao {
    User save(User user);
    User get(Long id);
    User remove(User user);
    Optional<User> findByEmail(String email);
}
