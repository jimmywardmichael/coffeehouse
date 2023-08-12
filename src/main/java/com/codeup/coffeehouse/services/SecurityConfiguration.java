package com.codeup.coffeehouse.services;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
public class SecurityConfiguration {

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .formLogin()
                .loginPage("/login")
                .defaultSuccessUrl("/coffeehome") // user's home page, it can be any URL
                .permitAll() // Anyone can go to the login page
                .and()
                .logout()
                .logoutSuccessUrl("/") // append a query string value
                .and()
                .authorizeRequests(authorize -> authorize
                        .requestMatchers(new AntPathRequestMatcher("/", "/signup")).permitAll() // Anyone can see the home and signup pages
                        .requestMatchers(new AntPathRequestMatcher("/coffeehome")).authenticated() // Requires authentication for coffeehome
                        .anyRequest().authenticated() // All other requests require authentication
                );
        return http.build();
    }
}
