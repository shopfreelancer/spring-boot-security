package com.shopfreelancer.securitydemo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {

    @Bean
    public PasswordEncoder passwordEncoder(){
        PasswordEncoder encoder = new BCryptPasswordEncoder();
        return encoder;
    }

    @Override
    public void configure(WebSecurity web) {
        web.ignoring().antMatchers("/h2-console/**");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http

                .csrf().ignoringAntMatchers("/h2-console/**").disable()
                .authorizeRequests().antMatchers("/").permitAll()
                .and().authorizeRequests().antMatchers("/protected").authenticated()
                .and().authorizeRequests().antMatchers("/admin/**").hasAnyAuthority("ADMIN")
                .and().formLogin().usernameParameter("name").permitAll()
                .and().exceptionHandling().accessDeniedPage("/no-access");
    }
}
