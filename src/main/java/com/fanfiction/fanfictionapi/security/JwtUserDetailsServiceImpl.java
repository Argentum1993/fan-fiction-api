package com.fanfiction.fanfictionapi.security;

import static org.springframework.transaction.annotation.Propagation.SUPPORTS;

import com.fanfiction.fanfictionapi.entity.UserEntity;
import com.fanfiction.fanfictionapi.security.jwt.JwtUser;
import com.fanfiction.fanfictionapi.security.jwt.JwtUserFactory;
import com.fanfiction.fanfictionapi.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("JwtUserDetailsServiceImpl")
public class JwtUserDetailsServiceImpl implements UserDetailsService {

  private final UserServiceImpl userService;

  @Autowired
  public JwtUserDetailsServiceImpl(
      UserServiceImpl userService) {
    this.userService = userService;
  }


  @Override
  @Transactional(propagation = SUPPORTS, readOnly = true)
  public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
    UserEntity userEntity = userService.findByEmail(email).orElseThrow(
        () -> new UsernameNotFoundException(String.format("User with email: %s not found", email))
    );
    JwtUser jwtUser = JwtUserFactory.create(userEntity);
    return JwtUserFactory.create(userEntity);
  }
}
