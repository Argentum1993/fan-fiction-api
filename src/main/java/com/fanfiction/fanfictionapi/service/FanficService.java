package com.fanfiction.fanfictionapi.service;

import com.fanfiction.fanfictionapi.DTO.ChapterDTO;
import com.fanfiction.fanfictionapi.DTO.FanficDTO;
import com.fanfiction.fanfictionapi.DTO.PaginationRequestDTO;
import java.util.List;

public interface FanficService {
  List<FanficDTO>   findByUserId(Long userId, PaginationRequestDTO pagination);
  FanficDTO         getFanfic(Long id);
  List<FanficDTO>   getLatestFanfics(Integer size);
  List<FanficDTO>   getRatingFanfics(Integer size);
}
