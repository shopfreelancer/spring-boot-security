package com.shopfreelancer.securitydemo.boostrap;

import com.shopfreelancer.securitydemo.domain.Role;
import com.shopfreelancer.securitydemo.domain.User;
import com.shopfreelancer.securitydemo.services.RoleService;
import com.shopfreelancer.securitydemo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class Seeder implements ApplicationListener<ContextRefreshedEvent> {
    private UserService userService;
    private RoleService roleService;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @Autowired
    public void setRoleService(RoleService roleService) {
        this.roleService = roleService;
    }

    @Override
    @Transactional
    public void onApplicationEvent(ContextRefreshedEvent event) {
        saveRoles();
        saveUsers();
    }

    private void saveUsers(){
        User user1 = new User();
        user1.setName("admin");
        user1.setEmail("test@test.de");

        String password1 = "test";
        String hashedPassword1 = passwordEncoder.encode(password1);
        user1.setPassword(hashedPassword1);

        userService.save(user1);

        User user2 = new User();
        user2.setName("regular");
        user2.setEmail("test2@test.de");

        String password2 = "rest";
        String hashedPassword2 = passwordEncoder.encode(password2);
        user2.setPassword(hashedPassword2);

        userService.save(user2);
    }

    private void saveRoles() {
        Role role = new Role();
        role.setRole("CUSTOMER");
        roleService.save(role);

        Role adminRole = new Role();
        adminRole.setRole("ADMIN");
        roleService.save(adminRole);
    }
}
