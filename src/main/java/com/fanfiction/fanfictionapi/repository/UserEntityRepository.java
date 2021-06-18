package com.fanfiction.fanfictionapi.repository;

import com.fanfiction.fanfictionapi.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserEntityRepository extends JpaRepository<UserEntity, Long> {
  UserEntity findByUserName(String userName);
}
