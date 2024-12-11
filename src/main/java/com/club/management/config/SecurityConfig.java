package com.club.management.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable()) // Disable CSRF protection for API
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/api/users/register").permitAll()
                        .requestMatchers("/api/member/register").permitAll()
                        .requestMatchers("/api/event/register").permitAll()
                        .requestMatchers("/api/club/register").permitAll() // Allow registration endpoint without authentication
                        .requestMatchers("/api/club").permitAll()
                        .requestMatchers("/api/club/{clubId}").permitAll()
                        .anyRequest().authenticated() // Secure all other requests (authentication required)
                )
                .formLogin(form -> form
                        .defaultSuccessUrl("/", true))
                .logout(config -> config.logoutSuccessUrl("/"));

        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}