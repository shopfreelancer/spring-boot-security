package com.shopfreelancer.securitydemo.services;

import com.shopfreelancer.securitydemo.domain.User;

public interface UserService {
     void save(User user);
     User findByName(String name);
     User findByEmail(String name);
}
