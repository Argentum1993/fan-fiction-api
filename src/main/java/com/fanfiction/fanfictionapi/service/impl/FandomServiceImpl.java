package com.fanfiction.fanfictionapi.service.impl;

import com.fanfiction.fanfictionapi.DTO.FandomDTO;
import com.fanfiction.fanfictionapi.entity.FandomEntity;
import com.fanfiction.fanfictionapi.mapper.FandomEntityDTOMapper;
import com.fanfiction.fanfictionapi.repository.FandomEntityRepository;
import com.fanfiction.fanfictionapi.service.FandomService;
import java.util.List;
import java.util.Set;
import org.springframework.stereotype.Service;

@Service
public class FandomServiceImpl implements FandomService {
  private final FandomEntityRepository  fandomEntityRepository;
  private final FandomEntityDTOMapper   fandomEntityDTOMapper;

  public FandomServiceImpl(
      FandomEntityRepository fandomEntityRepository,
      FandomEntityDTOMapper fandomEntityDTOMapper) {
    this.fandomEntityRepository = fandomEntityRepository;
    this.fandomEntityDTOMapper = fandomEntityDTOMapper;
  }

  @Override
  public List<FandomEntity> getFandomsById(Set<Long> fandomIds) {
    return fandomEntityRepository.findAllById(fandomIds);
  }

  @Override
  public List<FandomDTO> getAll() {
    return fandomEntityDTOMapper.map(fandomEntityRepository.findAll());
  }
}
