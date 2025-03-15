package com.demo.filterchecking.filters;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.security.Principal;

public class CustomFilter extends OncePerRequestFilter {
    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain filterChain) throws ServletException, IOException {
        // Before rest of the application
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if(auth != null && auth.isAuthenticated()) {
//            System.out.println(auth.toString());
            Object principal = auth.getPrincipal();
            String username = null;
            if(principal instanceof User) {
                username = ((User) principal).getUsername();
            } else if(principal instanceof OAuth2User oAuth2User) {
                username = oAuth2User.getName();
            }

            request.setAttribute("user", username);
        }

        System.out.println("🍃🍃🍃🍃🍃🍃🍃🍃🍃🍃");
        System.out.println(request.toString());

        filterChain.doFilter(request, response);
        // After the rest of the application
    }
}
