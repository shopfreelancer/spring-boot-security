package com.shopfreelancer.securitydemo.services;

import com.shopfreelancer.securitydemo.domain.User;
import com.shopfreelancer.securitydemo.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    private UserRepository userRepository;

    @Autowired
    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User findByName(String name){
        return userRepository.findByName(name);
    }

    public User findByEmail(String email){
        return userRepository.findByEmail(email);
    }

    public void save(User user){
        userRepository.save(user);
    }
}
