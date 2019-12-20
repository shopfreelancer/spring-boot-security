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

    @Override
    public User findByName(String name){
        return userRepository.findByName(name);
    }

    @Override
    public User findByEmail(String email){
        return userRepository.findByEmail(email);
    }

    @Override
    public User save(User user){
        return userRepository.save(user);
    }
}
