package com.example.security;

import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class SecurityConfig {

    private final JwtFilter jwtFilter;

    public SecurityConfig(JwtFilter jwtFilter) {
        this.jwtFilter = jwtFilter;
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        http.csrf(csrf -> csrf.disable());

        // ENABLE H2 CONSOLE DISPLAY
        http.headers(headers -> headers.frameOptions().disable());

        http.authorizeHttpRequests(auth -> auth

                // allow h2-console
                .requestMatchers("/h2-console/**").permitAll()

                // allow html pages
                .requestMatchers("/", "/login.html", "/register.html",
                                 "/sd.html", "/teamlead.html").permitAll()

                // allow auth apis
                .requestMatchers("/api/auth/**").permitAll()

                // role-based apis
                .requestMatchers("/api/teamlead/**").hasRole("TEAMLEAD")
                .requestMatchers("/api/sd/**").hasRole("SD")

                // everything else requires auth
                .anyRequest().authenticated()
        );

        http.sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS));

        http.addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class);

        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}