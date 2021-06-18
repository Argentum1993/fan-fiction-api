package com.fanfiction.fanfictionapi.service.impl;

import com.fanfiction.fanfictionapi.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {

  private final AuthenticationManager authenticationManager;

  @Autowired
  public AuthServiceImpl(
      AuthenticationManager authenticationManager) {
    this.authenticationManager = authenticationManager;
  }

  @Override
  public ResponseEntity<?> authorize(String username, String password) {
    try {
      authenticationManager.authenticate(
          new UsernamePasswordAuthenticationToken(username, password));

      //TODO
    } catch (Exception e){

    }

    return null;
  }
}
