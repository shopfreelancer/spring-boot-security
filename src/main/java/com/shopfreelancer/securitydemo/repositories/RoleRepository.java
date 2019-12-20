package com.shopfreelancer.securitydemo.repositories;

import com.shopfreelancer.securitydemo.domain.Role;
import org.springframework.data.repository.CrudRepository;

public interface RoleRepository extends CrudRepository<Role, String> {

    Role findById(Long id);
    Role findByName(String name);
    Role save(Role role);


}
