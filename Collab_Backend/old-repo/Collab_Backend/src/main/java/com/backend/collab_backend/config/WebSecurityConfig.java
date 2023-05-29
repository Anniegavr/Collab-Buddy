package com.backend.collab_backend.config;

import com.backend.collab_backend.config.authentication.jwt.AuthEntryPointJwt;
import com.backend.collab_backend.config.authentication.jwt.AuthTokenFilter;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
//@ImportResource({"classpath:springSecurityConfig.xml"})
@RequiredArgsConstructor
public class WebSecurityConfig {

  private final UserDetailsServiceImpl userDetailsService;

  private final AuthEntryPointJwt unauthorizedHandler;

//  @Bean
//  public AuthTokenFilter authenticationJwtTokenFilter(jwt) {
//    return new AuthTokenFilter(jwt);
//  }
  @Bean
  public BCryptPasswordEncoder bCryptPasswordEncoder() {
  return new BCryptPasswordEncoder();
}


  @Bean
  public DaoAuthenticationProvider authenticationProvider() {
    DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();

    authProvider.setUserDetailsService((UserDetailsService) userDetailsService);
    authProvider.setPasswordEncoder(passwordEncoder());

    return authProvider;
  }

  @Bean
  public AuthenticationManager authenticationManager(AuthenticationConfiguration authConfig) throws Exception {
    return authConfig.getAuthenticationManager();
  }

  @Bean
  public PasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder();
  }

  @Bean
  public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
    http.cors().and().csrf().disable()
            .exceptionHandling().authenticationEntryPoint(unauthorizedHandler).and()
            .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and().
            authorizeHttpRequests().requestMatchers("/student").hasRole("STUDENT").and().formLogin()
            .and().authorizeHttpRequests().requestMatchers("/teacher").hasRole("TEACHER").and().formLogin()
            .and().authorizeHttpRequests().requestMatchers("/admin").hasRole("ADMIN").and().formLogin()
            .and().authorizeHttpRequests().requestMatchers("/guest").hasRole("GUEST").and().formLogin()
            .and().authorizeHttpRequests().requestMatchers("/**").hasRole("DEV").and().formLogin();

    http.authenticationProvider(authenticationProvider());

//    http.addFilterBefore((Filter) authenticationJwtTokenFilter(), (Class<? extends Filter>) UsernamePasswordAuthenticationFilter.class);

    return http.build();
  }
}