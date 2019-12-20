package com.shopfreelancer.securitydemo.repositories;

import com.shopfreelancer.securitydemo.domain.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, String> {

     User findByName(String name);
     User findByEmail(String email);
}
