package com.fanfiction.fanfictionapi.repository;

import com.fanfiction.fanfictionapi.entity.RoleEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleEntityRepository extends JpaRepository<RoleEntity, Long> {
  RoleEntity findByName(String name);
}
