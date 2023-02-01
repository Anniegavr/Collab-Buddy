package com.collab.buddy.CollabBuddy.config;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig {
  private final AdminServerProperties adminServer;

  public WebSecurityConfig(AdminServerProperties adminServer) {
    this.adminServer = adminServer;
  }

  @Bean
  public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
    SavedRequestAwareAuthenticationSuccessHandler successHandler =
            new SavedRequestAwareAuthenticationSuccessHandler();
    successHandler.setTargetUrlParameter("redirectTo");
    successHandler.setDefaultTargetUrl(this.adminServer.getContextPath() + "/");

    http
            .authorizeRequests()
            .antMatchers(this.adminServer.getContextPath() + "/assets/**").permitAll()
            .antMatchers(this.adminServer.getContextPath() + "/login").permitAll()
            .anyRequest().authenticated()
            .and()
            .formLogin()
            .loginPage(this.adminServer.getContextPath() + "/login")
            .successHandler(successHandler)
            .and()
            .logout()
            .logoutUrl(this.adminServer.getContextPath() + "/logout")
            .and()
            .httpBasic()
            .and()
            .csrf()
            .csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse())
            .ignoringRequestMatchers(
                    new AntPathRequestMatcher(this.adminServer.getContextPath() +
                                                      "/instances", HttpMethod.POST.toString()),
                    new AntPathRequestMatcher(this.adminServer.getContextPath() +
                                                      "/instances/*", HttpMethod.DELETE.toString()),
                    new AntPathRequestMatcher(this.adminServer.getContextPath() + "/actuator/**"))
            .and()
            .rememberMe()
            .key(UUID.randomUUID().toString())
            .tokenValiditySeconds(1209600);
    return http.build();
  }
}