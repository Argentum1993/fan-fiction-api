package com.fanfiction.fanfictionapi.service;

import com.fanfiction.fanfictionapi.DTO.FandomDTO;
import com.fanfiction.fanfictionapi.entity.UserEntity;
import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface UserService {
  UserEntity            saveUser(UserEntity userEntity);
  Optional<UserEntity>  findByEmail(String email);
  List<FandomDTO>       putFandoms(Long id, Set<Long> fandomsId);
}
