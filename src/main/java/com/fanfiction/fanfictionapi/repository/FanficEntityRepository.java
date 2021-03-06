package com.fanfiction.fanfictionapi.repository;

import com.fanfiction.fanfictionapi.entity.FanficEntity;
import java.util.List;
import java.util.Set;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface FanficEntityRepository extends JpaRepository<FanficEntity, Long> {
  List<FanficEntity>  findByUserEntityId(Long id, Pageable pageable);
  Integer             countByUserEntityId(Long id);
  List<FanficEntity>  findByFandomEntityId(Long id, Pageable pageable);
  Integer             countByFandomEntityId(Long id);
}
