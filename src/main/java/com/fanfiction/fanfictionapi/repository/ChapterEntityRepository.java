package com.fanfiction.fanfictionapi.repository;

import com.fanfiction.fanfictionapi.entity.ChapterEntity;
import java.util.List;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ChapterEntityRepository extends JpaRepository<ChapterEntity, Long> {
  List<ChapterEntity> findByFanficEntityId(Long id);

  @Query("SELECT c.name FROM ChapterEntity c WHERE c.fanficEntity.id = ?1")
  List<String>        findNamesByFanficEntityId(Long id, Sort sort);
  ChapterEntity       findByFanficEntityIdAndAndNumber(Long id, int number);
}
