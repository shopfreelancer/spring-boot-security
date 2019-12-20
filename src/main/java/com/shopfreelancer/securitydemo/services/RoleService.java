package com.shopfreelancer.securitydemo.services;

import com.shopfreelancer.securitydemo.domain.Role;

public interface RoleService {
    Role save(Role role);
    Role findByName(String name);
}
