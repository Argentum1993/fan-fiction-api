package com.fanfiction.fanfictionapi.service;

import com.fanfiction.fanfictionapi.DTO.ChapterDTO;;
import java.util.List;

public interface ChapterService {
  List<ChapterDTO>  getAllChaptersById(Long id);
  List<String>      getChapterNames(Long id);
  ChapterDTO        getChapter(Long id, int num);
}
