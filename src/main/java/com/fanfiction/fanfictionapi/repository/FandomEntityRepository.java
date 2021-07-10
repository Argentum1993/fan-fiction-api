package com.fanfiction.fanfictionapi.repository;

import com.fanfiction.fanfictionapi.entity.FandomEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FandomEntityRepository extends JpaRepository<FandomEntity, Long> {
}
