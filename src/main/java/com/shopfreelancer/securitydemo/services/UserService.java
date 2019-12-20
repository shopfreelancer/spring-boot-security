package com.shopfreelancer.securitydemo.services;

import com.shopfreelancer.securitydemo.domain.User;

public interface UserService {
     User save(User user);
     User findByName(String name);
     User findByEmail(String name);
}
