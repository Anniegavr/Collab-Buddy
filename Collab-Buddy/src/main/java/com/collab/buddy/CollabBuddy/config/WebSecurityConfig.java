package com.collab.buddy.CollabBuddy.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;


@Configuration
@EnableWebSecurity
public class WebSecurityConfig {
  @Bean
  public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
    http.authorizeHttpRequests().requestMatchers("/student").hasRole("STUDENT").and().formLogin();
    http.authorizeHttpRequests().requestMatchers("/teacher").hasRole("TEACHER").and().formLogin();
    http.authorizeHttpRequests().requestMatchers("/admin").hasRole("ADMIN").and().formLogin();
    http.authorizeHttpRequests().requestMatchers("/guest").hasRole("GUEST").and().formLogin();
    http.authorizeHttpRequests().requestMatchers("/**").hasRole("DEV").and().formLogin();
    http.authorizeHttpRequests().requestMatchers("/actuator").hasRole("ADMIN").and().formLogin();
    return http.build();
  }
}