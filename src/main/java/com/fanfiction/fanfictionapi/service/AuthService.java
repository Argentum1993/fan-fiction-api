package com.fanfiction.fanfictionapi.service;

import com.fanfiction.fanfictionapi.DTO.RegistrationDTO;
import org.springframework.http.ResponseEntity;

public interface AuthService {
  ResponseEntity<?>       authorize(String username, String password);
  ResponseEntity<String>  registration(RegistrationDTO request);
}
