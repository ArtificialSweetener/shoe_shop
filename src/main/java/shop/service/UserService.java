package shop.service;

import shop.entity.User;

import java.util.Optional;

public interface UserService {
    User save(User user);
    Optional<User> findByEmail(String email);
}
