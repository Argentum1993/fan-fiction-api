package com.fanfiction.fanfictionapi.service;

import org.springframework.http.ResponseEntity;

public interface AuthService {
  ResponseEntity<?> authorize(String username, String password);
}
