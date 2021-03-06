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
  private final int LIMIT_FANFICS = 10;

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

  public FanficDTO  getFanfic(Long id){
    return fanficEntityDtoMapper.fanficEntityToDto(fanficEntityRepository.findById(id).get());
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

  @Override
  public List<FanficDTO> getLatestFanfics(Integer size) {
    return getLimitedAndSortedFanfics(size, "publicationDate");
  }

  @Override
  public List<FanficDTO> getRatingFanfics(Integer size) {
    return getLimitedAndSortedFanfics(size, "averageRating");
  }

  @Override
  public Integer countFanficsByUserId(Long userId) {
    return fanficEntityRepository.countByUserEntityId(userId);
  }

  @Override
  public List<FanficDTO> getFanficByFandomId(Long fandomId, PaginationRequestDTO pagination) {
    return fanficEntityDtoMapper
        .map(fanficEntityRepository.findByFandomEntityId(fandomId, createPageable(pagination)));
  }

  @Override
  public Integer countFanficByFandomId(Long fandomId) {
    return fanficEntityRepository.countByFandomEntityId(fandomId);
  }

  private List<FanficDTO> getLimitedAndSortedFanfics(Integer size, String sortBy){
    Pageable  pageable;

    if (size == null){
      size = LIMIT_FANFICS;
    }
    if (sortBy != null)
      pageable = PageRequest.of(0, size, Sort.by(sortBy));
    else
      pageable = PageRequest.of(0, size);
    return fanficEntityDtoMapper.map(fanficEntityRepository.findAll(pageable).getContent());
  }
}
