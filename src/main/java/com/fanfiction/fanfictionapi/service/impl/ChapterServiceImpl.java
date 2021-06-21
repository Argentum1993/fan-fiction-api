package com.fanfiction.fanfictionapi.service.impl;

import com.fanfiction.fanfictionapi.DTO.ChapterDTO;
import com.fanfiction.fanfictionapi.mapper.ChapterEntityDtoMapper;
import com.fanfiction.fanfictionapi.repository.ChapterEntityRepository;
import com.fanfiction.fanfictionapi.service.ChapterService;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class ChapterServiceImpl implements ChapterService {
  private final ChapterEntityRepository chapterEntityRepository;
  private final ChapterEntityDtoMapper  chapterEntityDtoMapper;

  public ChapterServiceImpl(
      ChapterEntityRepository chapterEntityRepository,
      ChapterEntityDtoMapper chapterEntityDtoMapper) {
    this.chapterEntityRepository = chapterEntityRepository;
    this.chapterEntityDtoMapper = chapterEntityDtoMapper;
  }

  public List<ChapterDTO> getAllChaptersById(Long id){
    return chapterEntityDtoMapper.map(chapterEntityRepository.findByFanficEntityId(id));
  }
}
