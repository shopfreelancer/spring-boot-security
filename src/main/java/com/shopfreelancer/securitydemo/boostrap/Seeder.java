package com.shopfreelancer.securitydemo.boostrap;

import com.shopfreelancer.securitydemo.domain.Role;
import com.shopfreelancer.securitydemo.domain.User;
import com.shopfreelancer.securitydemo.services.RoleService;
import com.shopfreelancer.securitydemo.services.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Component
@Slf4j
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

        Role adminRole = roleService.findByName("ADMIN");
        List<Role> roles1 = new ArrayList<>();
        roles1.add(adminRole);
        user1.setRoles(roles1);

        userService.save(user1);

        User user2 = new User();
        user2.setName("martin");
        user2.setEmail("test2@test.de");

        String password2 = "rest";
        String hashedPassword2 = passwordEncoder.encode(password2);
        user2.setPassword(hashedPassword2);

        userService.save(user2);



    }

    private void saveRoles() {
        Role role = new Role();
        role.setName("REGULAR");
        roleService.save(role);

        Role adminRole = new Role();
        adminRole.setName("ADMIN");
        roleService.save(adminRole);
    }
}
