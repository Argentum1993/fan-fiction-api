package com.fanfiction.fanfictionapi.service.impl;

import com.fanfiction.fanfictionapi.DTO.ChapterDTO;
import com.fanfiction.fanfictionapi.DTO.FanficDTO;
import com.fanfiction.fanfictionapi.DTO.PaginationRequestDTO;
import com.fanfiction.fanfictionapi.entity.FanficEntity;
import com.fanfiction.fanfictionapi.mapper.FanficEntityDtoMapper;
import com.fanfiction.fanfictionapi.repository.ChapterEntityRepository;
import com.fanfiction.fanfictionapi.repository.FanficEntityRepository;
import com.fanfiction.fanfictionapi.service.ChapterService;
import com.fanfiction.fanfictionapi.service.FanficService;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class FanficServiceImpl implements FanficService {
  private final FanficEntityRepository  fanficEntityRepository;
  private final FanficEntityDtoMapper   fanficEntityDtoMapper;

  @Autowired
  public FanficServiceImpl(
      FanficEntityRepository fanficEntityRepository,
      FanficEntityDtoMapper fanficEntityDtoMapper) {
    this.fanficEntityRepository = fanficEntityRepository;
    this.fanficEntityDtoMapper = fanficEntityDtoMapper;
  }

  @Override
  public List<FanficDTO> findByUserId(Long userId, PaginationRequestDTO pagination) {
    Pageable pageable;

    pageable =  createPageable(pagination);
    return fanficEntityDtoMapper.map(fanficEntityRepository.findByUserEntityId(userId, pageable));
  }

  private Pageable createPageable(PaginationRequestDTO pagination){
    int       pageNumber;
    int       pageSize;

    pageNumber = 0;
    pageSize = 30;
    if (pagination != null) {
      if (pagination.getPageNumber() != null)
        pageNumber =pagination.getPageNumber();
      if (pagination.getPageSize() != null)
        pageSize = pagination.getPageSize();
      if (pagination.getSortedBy() != null){
        return PageRequest.of(pageNumber, pageSize, Sort.by(pagination.getSortedBy()));
      }
    }
    return PageRequest.of(pageNumber, pageSize);
  }
}
