package com.fanfiction.fanfictionapi.service;

import com.fanfiction.fanfictionapi.DTO.ChapterDTO;
import com.fanfiction.fanfictionapi.DTO.FanficDTO;
import java.util.List;

public interface ChapterService {
  List<ChapterDTO>  getAllChaptersById(Long id);
  List<String>      getChapterNames(Long id);
}
