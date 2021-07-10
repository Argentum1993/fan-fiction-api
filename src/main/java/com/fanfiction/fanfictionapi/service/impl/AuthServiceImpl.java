package com.fanfiction.fanfictionapi.service.impl;

import com.fanfiction.fanfictionapi.DTO.LoginResponseDTO;
import com.fanfiction.fanfictionapi.DTO.RegistrationDTO;
import com.fanfiction.fanfictionapi.entity.UserEntity;
import com.fanfiction.fanfictionapi.security.jwt.JwtTokenProvider;
import com.fanfiction.fanfictionapi.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {

  private final AuthenticationManager authenticationManager;
  private final UserServiceImpl userService;
  private final JwtTokenProvider jwtTokenProvider;

  @Autowired
  public AuthServiceImpl(
      AuthenticationManager authenticationManager,
      UserServiceImpl userService,
      JwtTokenProvider jwtTokenProvider) {
    this.authenticationManager = authenticationManager;
    this.userService = userService;
    this.jwtTokenProvider = jwtTokenProvider;
  }

  @Override
  public ResponseEntity<?> authorize(String email, String password) {
    try {
      authenticationManager.authenticate(
          new UsernamePasswordAuthenticationToken(email, password));
      UserEntity userEntity = userService.findByEmail(email)
          .orElseThrow(() -> new UsernameNotFoundException("User doesn't exist"));
      String token = jwtTokenProvider.createToken(email);
      return ResponseEntity.ok(new LoginResponseDTO(
          userEntity.getId(),
          userEntity.getFirstName(),
          userEntity.getLastName(),
          userEntity.getEmail(),
          token
      ));
    } catch (AuthenticationException e){
      return new ResponseEntity<>(
          "Invalid username/password combination", HttpStatus.FORBIDDEN);
    }
  }

  @Override
  public ResponseEntity<String> registration(RegistrationDTO request) {
    UserEntity userEntity = new UserEntity(
        request.getFirstName(),
        request.getLastName(),
        request.getPassword(),
        request.getEmail()
    );
    userEntity = userService.saveUser(userEntity);
    String responseMsg = String.format(
        "%s %s you are register!",
        userEntity.getFirstName(),
        userEntity.getLastName()
    );
    return userEntity != null
        ? new ResponseEntity<>(responseMsg, HttpStatus.OK)
        : new ResponseEntity<>(HttpStatus.BAD_REQUEST);
  }
}
