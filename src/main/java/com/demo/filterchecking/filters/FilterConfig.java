package com.demo.filterchecking.filters;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.AuthenticationFilter;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.filter.OncePerRequestFilter;

@Configuration
public class FilterConfig {

//    @Bean
//    public FilterRegistrationBean<OncePerRequestFilter> filterRegistrationBean() {
//        FilterRegistrationBean<OncePerRequestFilter> registrationBean = new FilterRegistrationBean<>();
//        registrationBean.setFilter(new CustomFilter());
//        registrationBean.addUrlPatterns("/api/*");
////        registrationBean.setOrder(1);
//        return registrationBean;
//    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(
                request ->
                    request.requestMatchers("/").permitAll()
                            .anyRequest().authenticated())
                .formLogin(Customizer.withDefaults())
                .logout(Customizer.withDefaults())
                        .oauth2Login(Customizer.withDefaults());

        http.addFilterBefore(new CustomFilter(), UsernamePasswordAuthenticationFilter.class);
        return http.build();
    }

}
