package com.shopfreelancer.securitydemo.security;

import com.shopfreelancer.securitydemo.domain.Role;
import com.shopfreelancer.securitydemo.domain.User;
import com.shopfreelancer.securitydemo.services.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service("userDetailsService")
@Slf4j
public class SecUserDetailsServiceImpl implements UserDetailsService {
    private UserService userService;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    public SecUserDetailsServiceImpl(){ }

    @Override
    public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {
        User user = userService.findByName(name);

        SecUserDetailsImpl userDetails = new SecUserDetailsImpl();

        if(user != null) {
            userDetails.setUsername(user.getName());
            userDetails.setPassword(user.getPassword());

            List<Role> roles = user.getRoles();

            if(!roles.isEmpty()){
                Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();
                for(Role role : roles){
                    authorities.add(new SimpleGrantedAuthority(role.getName()));
                }
                userDetails.setAuthorities(authorities);
            }

        }
        return userDetails;


    }


}
