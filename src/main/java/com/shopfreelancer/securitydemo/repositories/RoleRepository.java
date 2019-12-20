package com.shopfreelancer.securitydemo.repositories;

import com.shopfreelancer.securitydemo.domain.Role;
import com.shopfreelancer.securitydemo.domain.User;
import org.springframework.data.repository.CrudRepository;

public interface RoleRepository extends CrudRepository<Role, String> {
    Role findById(Long id);
    Role save(Role role);
}
