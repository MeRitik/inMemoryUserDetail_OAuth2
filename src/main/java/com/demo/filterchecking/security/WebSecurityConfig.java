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
                .username("user1")
                .password("{noop}pass1")
                .authorities("ROLE_USER")
                .build();

        UserDetails user1 = User.builder()
                .username("user2")
                .password("{noop}pass2")
                .authorities("ROLE_ADMIN")
                .build();

        return new InMemoryUserDetailsManager(user, user1);
    }
}
