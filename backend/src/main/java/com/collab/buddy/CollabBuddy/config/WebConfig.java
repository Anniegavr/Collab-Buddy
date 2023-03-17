package com.collab.buddy.CollabBuddy.config;

import com.collab.buddy.CollabBuddy.config.security.IPFilterInterceptor;
import lombok.Value;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.Arrays;

public class WebConfig implements WebMvcConfigurer {
  @Value("${app.admin.ips}")
  private String[] allowedIps;

  @Override
  public void addInterceptors(InterceptorRegistry registry) {
    registry.addInterceptor(new IPFilterInterceptor(Arrays.asList(allowedIps)));
  }
}
