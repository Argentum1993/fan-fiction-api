package com.fanfiction.fanfictionapi.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.http.ResponseEntity;

public interface AuthService {
  ResponseEntity<?> authorize(String username, String password);
}
