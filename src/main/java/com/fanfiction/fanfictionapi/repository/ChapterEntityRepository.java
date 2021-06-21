package com.fanfiction.fanfictionapi.repository;

import com.fanfiction.fanfictionapi.entity.ChapterEntity;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChapterEntityRepository extends JpaRepository<ChapterEntity, Long> {
  List<ChapterEntity> findByFanficEntityId(Long id);
}
