package shop.security;

import shop.entity.User;

public interface AuthenticationService {
    void register (String email, String password);
    User login(String email, String password);
}
