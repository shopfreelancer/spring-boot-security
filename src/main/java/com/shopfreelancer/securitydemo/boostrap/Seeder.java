package com.shopfreelancer.securitydemo.boostrap;

import com.shopfreelancer.securitydemo.domain.User;
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

    @Autowired
    PasswordEncoder passwordEncoder;

    public UserService getUserService() {
        return userService;
    }

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @Override
    @Transactional
    public void onApplicationEvent(ContextRefreshedEvent event) {
        User user1 = new User();
        user1.setName("firstuser");
        user1.setEmail("test@test.de");

        String password1 = "test";
        String hashedPassword1 = passwordEncoder.encode(password1);
        user1.setPassword(hashedPassword1);

        userService.save(user1);

        User user2 = new User();
        user2.setName("seconduser");
        user2.setEmail("test2@test.de");

        String password2 = "rest";
        String hashedPassword2 = passwordEncoder.encode(password2);
        user2.setPassword(hashedPassword2);

        userService.save(user2);
    }
}
