package com.fanfiction.fanfictionapi.controller;

import com.fanfiction.fanfictionapi.DTO.AuthDTO;
import com.fanfiction.fanfictionapi.Maps;
import com.fanfiction.fanfictionapi.service.impl.AuthServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(Maps.AUTH)
public class AuthController {

  private final AuthServiceImpl authService;

  @Autowired
  public AuthController(AuthServiceImpl authService) {
    this.authService = authService;
  }

  @RequestMapping(Maps.AUTH_LOGIN)
  public ResponseEntity<?> login(@RequestBody AuthDTO request){
    return authService.authorize(request.getUsername(), request.getPassword());
  }
}
