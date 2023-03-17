package com.collab.buddy.CollabBuddy.config.security;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.HandlerInterceptor;

import java.util.List;

public class IPFilterInterceptor implements HandlerInterceptor {
  private List<String> allowedIps;

  public IPFilterInterceptor(List<String> allowedIps) {
    this.allowedIps = allowedIps;
  }

  @Override
  public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
    String ipAddress = request.getRemoteAddr();
    if (!allowedIps.contains(ipAddress)) {
      response.setStatus(HttpServletResponse.SC_FORBIDDEN);
      return false;
    }
    return true;
  }
}
