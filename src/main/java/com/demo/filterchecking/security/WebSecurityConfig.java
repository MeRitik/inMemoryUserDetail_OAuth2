package com.demo.filterchecking.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
public class WebSecurityConfig {

    @Bean
    public InMemoryUserDetailsManager inMemoryUserDetailsManager() {
        UserDetails user = User.builder()
                .username("ritik")
                .password("{noop}ritik")
                .authorities("ROLE_USER")
                .build();

        UserDetails user1 = User.builder()
                .username("abhi")
                .password("{noop}singh")
                .authorities("ROLE_ADMIN")
                .build();

        return new InMemoryUserDetailsManager(user, user1);
    }
}
