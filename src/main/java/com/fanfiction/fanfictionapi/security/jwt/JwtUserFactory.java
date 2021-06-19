package com.fanfiction.fanfictionapi.security.jwt;

import com.fanfiction.fanfictionapi.entity.UserEntity;
import com.fanfiction.fanfictionapi.entity.UserStatus;
import java.util.List;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

public final class JwtUserFactory {
  public JwtUserFactory() {
  }

  public static JwtUser create(UserEntity userEntity){
    return new JwtUser(
        userEntity.getEmail(),
        userEntity.getPassword(),
        List.of(
            new SimpleGrantedAuthority(userEntity.getRoleEntity().getName())
        ),
        userEntity.getStatus().equals(UserStatus.ACTIVE)
    );
  }
}
