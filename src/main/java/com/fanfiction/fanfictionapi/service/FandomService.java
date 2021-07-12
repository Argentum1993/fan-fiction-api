package com.fanfiction.fanfictionapi.service;

import com.fanfiction.fanfictionapi.DTO.FandomDTO;
import com.fanfiction.fanfictionapi.DTO.FanficDTO;
import com.fanfiction.fanfictionapi.DTO.PaginationRequestDTO;
import com.fanfiction.fanfictionapi.entity.FandomEntity;
import java.util.List;
import java.util.Set;

public interface FandomService {
  List<FandomEntity>  getFandomsById(Set<Long> fandomIds);
  List<FandomDTO>     getAll();
  List<FanficDTO>     getFanfics(Long fandomId, PaginationRequestDTO pagination);
  Integer             countFanfics(Long fandomId);
}
