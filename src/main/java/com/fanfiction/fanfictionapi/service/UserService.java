package com.fanfiction.fanfictionapi.service;

import com.fanfiction.fanfictionapi.entity.UserEntity;
import java.util.Optional;

public interface UserService {
  UserEntity saveUser(UserEntity userEntity);
  Optional<UserEntity> findByEmail(String email);
}
