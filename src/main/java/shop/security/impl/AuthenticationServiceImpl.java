package shop.security.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import shop.entity.User;
import shop.exceptions.AuthenticationException;
import shop.security.AuthenticationService;
import shop.service.UserService;
import shop.util.HashUtil;

import java.util.Optional;
@Service
public class AuthenticationServiceImpl implements AuthenticationService {
    @Autowired
    private UserService userService;

    @Override
    public void register(String email, String password) {
//
    }

    @Override
    public User login(String email, String password) {
       Optional<User> userFromDbOptional = userService.findByEmail(email);
       if(userFromDbOptional.isEmpty()){
           throw new AuthenticationException("Can't authenticate user");
       }
       User user = userFromDbOptional.get();
       String hashedPassword = HashUtil.hashPassword(password, user.getSalt());
       if (user.getPassword().equals(hashedPassword)){
           return user;
       }
        throw new AuthenticationException("Can´t authenticate user");
    }
}
