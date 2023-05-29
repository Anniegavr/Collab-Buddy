package com.backend.collab_backend.config;

import com.backend.collab_backend.config.security.IPFilterInterceptor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class WebConfig implements WebMvcConfigurer {
  private List<String> allowedIps = new ArrayList<>();

  @Override
  public void addInterceptors(InterceptorRegistry registry) {
    getAllowedIps().add("127.0.0.1/admin");
    registry.addInterceptor(new IPFilterInterceptor(allowedIps));
  }
}
